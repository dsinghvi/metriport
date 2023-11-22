import { Request, Response, Router } from "express";
import httpStatus from "http-status";
import { peekIntoSidechainDLQ } from "../command/medical/admin/peek-dlq";
import {
  populateFhirServer,
  PopulateFhirServerResponse,
} from "../command/medical/admin/populate-fhir";
import { redriveSidechainDLQ } from "../command/medical/admin/redrive-dlq";
import { allowMapiAccess, revokeMapiAccess } from "../command/medical/mapi-access";
import BadRequestError from "../errors/bad-request";
import { countResources } from "../external/fhir/patient/count-resources";
import { OrganizationModel } from "../models/medical/organization";
import userRoutes from "./devices/internal-user";
import docsRoutes from "./medical/internal-docs";
import patientRoutes from "./medical/internal-patient";
import carequalityRoutes from "./medical/internal-cq";
import { getUUIDFrom } from "./schemas/uuid";
import { asyncHandler, getFrom } from "./util";

const router = Router();

router.use("/docs", docsRoutes);
router.use("/patient", patientRoutes);
router.use("/user", userRoutes);
router.use("/carequality", carequalityRoutes);

/** ---------------------------------------------------------------------------
 * POST /internal/mapi-access
 *
 * Give access to MAPI for a (customer's) account. This is an idempotent
 * operation, which means it can be called multiple times without side effects.
 *
 * @param req.query.cxId - The customer/account's ID.
 * @return 200/201 Indicating access has been given (201) or already had access (200).
 */
router.post(
  "/mapi-access",
  asyncHandler(async (req: Request, res: Response) => {
    const cxId = getUUIDFrom("query", req, "cxId").orFail();
    const outcome = await allowMapiAccess(cxId);
    return res.sendStatus(outcome === "new" ? httpStatus.CREATED : httpStatus.OK);
  })
);

/** ---------------------------------------------------------------------------
 * DELETE /internal/mapi-access
 *
 * Revoke access to MAPI for a (customer's) account.
 *
 * @param req.query.cxId - The customer/account's ID.
 * @return 204 When access revoked, 404 when access was not provided.
 */
router.delete(
  "/mapi-access",
  asyncHandler(async (req: Request, res: Response) => {
    const cxId = getUUIDFrom("query", req, "cxId").orFail();
    await revokeMapiAccess(cxId);
    return res.sendStatus(httpStatus.NO_CONTENT);
  })
);

/** ---------------------------------------------------------------------------
 * POST /internal/populate-fhir-server
 *
 * Populate the FHIR server with customer's data.
 * This an idempotent endpoint, which means it can be called multiple times and it
 * will not have side effects.
 *
 * @param req.query.cxId - The customer/account's ID.
 * @param req.query.allCustomers - Whether we should populate all customers.
 * @param req.query.createIfNotExists - Creates the tenant on the FHIR server if
 *          it does not exist. (optional, default false)
 * @param req.query.triggerDocQuery - Triggers a new document query for each patient.
 *          (optional, default false)
 * @return 200 When successful, including the patient count.
 */
router.post(
  "/populate-fhir-server",
  asyncHandler(async (req: Request, res: Response) => {
    const cxId = getUUIDFrom("query", req, "cxId").optional();
    const allCustomers = getFrom("query").optional("allCustomers", req) === "true";
    const createIfNotExists = getFrom("query").optional("createIfNotExists", req) === "true";
    const triggerDocQuery = getFrom("query").optional("triggerDocQuery", req) === "true";

    if (cxId && allCustomers) {
      throw new BadRequestError("Either cxId or allCustomers must be provided, not both");
    }

    if (cxId) {
      const result = await populateFhirServer({ cxId, createIfNotExists, triggerDocQuery });
      return res.json({ [cxId]: result });
    }

    if (!allCustomers) {
      throw new BadRequestError("Either cxId or allCustomers must be provided, not both");
    }

    const allOrgs = await OrganizationModel.findAll();
    const result: Record<string, PopulateFhirServerResponse> = {};
    for (const org of allOrgs) {
      const orgRes = await populateFhirServer({
        cxId: org.cxId,
        createIfNotExists,
        triggerDocQuery,
      });
      result[org.cxId] = orgRes;
    }
    return res.json(result);
  })
);

/** ---------------------------------------------------------------------------
 * POST /internal/redrive-sidechain-dlq
 *
 * Pull messages from the sidechain DLQ, unique, and reprocess them.
 *
 * @param req.query.maxNumberOfMessages - The maximum number of messages to pull. Defaults to all (-1).
 * @return 200 When successful, including the original and unique counts.
 */
router.post(
  "/redrive-sidechain-dlq",
  asyncHandler(async (req: Request, res: Response) => {
    const maxNumberOfMessagesRaw = getFrom("query").optional("maxNumberOfMessages", req);
    const maxNumberOfMessages = maxNumberOfMessagesRaw ? parseInt(maxNumberOfMessagesRaw) : -1;

    const result = await redriveSidechainDLQ(maxNumberOfMessages);
    return res.json(result);
  })
);

/** ---------------------------------------------------------------------------
 * GET /internal/peek-sidechain-dlq
 *
 * Read the first 10 messages from the sidechain DLQ without removing them, and return a link
 * to download the files they point to.
 */
router.get(
  "/peek-sidechain-dlq",
  asyncHandler(async (req: Request, res: Response) => {
    const result = await peekIntoSidechainDLQ();
    return res.json(result);
  })
);

/** ---------------------------------------------------------------------------
 * GET /internal/count-fhir-resources
 *
 * Count all resources for this customer in the FHIR server.
 */
router.get(
  "/count-fhir-resources",
  asyncHandler(async (req: Request, res: Response) => {
    const cxId = getUUIDFrom("query", req, "cxId").orFail();
    const result = await countResources({ patient: { cxId } });
    return res.json(result);
  })
);

export default router;
