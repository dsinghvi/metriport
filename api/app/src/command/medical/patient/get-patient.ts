import { Op } from "sequelize";
import NotFoundError from "../../../errors/not-found";
import { FacilityModel } from "../../../models/medical/facility";
import { OrganizationModel } from "../../../models/medical/organization";
import { Patient, PatientModel } from "../../../models/medical/patient";
import { getFacilities } from "../facility/get-facility";
import { getOrganizationOrFail } from "../organization/get-organization";
import { PatientData } from "../../../models/medical/patient";

export const getPatients = async ({
  facilityId,
  cxId,
}: {
  facilityId: string;
  cxId: string;
}): Promise<Patient[]> => {
  const patients = await PatientModel.findAll({
    where: {
      cxId,
      facilityIds: {
        [Op.contains]: [facilityId],
      },
    },
    order: [["id", "ASC"]],
  });
  return patients;
};

export const getPatientByDemo = async ({
  facilityId,
  cxId,
  demo,
}: {
  facilityId: string;
  cxId: string;
  demo: PatientData;
}): Promise<Patient | null> => {
  const patient = await PatientModel.findOne({
    where: {
      cxId,
      facilityIds: {
        [Op.contains]: [facilityId],
      },
      data: {
        firstName: demo.firstName,
        lastName: demo.lastName,
        ...(demo.personalIdentifiers && demo.personalIdentifiers.length
          ? {
              personalIdentifiers: {
                [Op.in]: demo.personalIdentifiers,
              },
            }
          : undefined),
        dob: demo.dob,
        address: {
          addressLine1: demo.address.addressLine1,
          city: demo.address.city,
          state: demo.address.state,
          zip: demo.address.zip,
          country: demo.address.country,
          ...(demo.address.addressLine2 ? { addressLine2: demo.address.addressLine2 } : undefined),
        },
        contact: demo.contact,
      },
    },
  });

  return patient;
};

export const getPatientOrFail = async ({
  id,
  cxId,
}: {
  id: string;
  cxId: string;
}): Promise<PatientModel> => {
  const patient = await PatientModel.findOne({
    where: { cxId, id },
  });
  if (!patient) throw new NotFoundError(`Could not find patient`);
  return patient;
};

export const getPatientWithDependencies = async ({
  id,
  cxId,
}: {
  id: string;
  cxId: string;
}): Promise<{
  patient: PatientModel;
  facilities: FacilityModel[];
  organization: OrganizationModel;
}> => {
  const patient = await getPatientOrFail({ id, cxId });
  const facilities = await getFacilities({ cxId, ids: patient.facilityIds });
  const organization = await getOrganizationOrFail({ cxId });
  return { patient, facilities, organization };
};