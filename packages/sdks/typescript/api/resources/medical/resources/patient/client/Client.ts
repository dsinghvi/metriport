/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as environments from "../../../../../../environments";
import * as core from "../../../../../../core";
import * as Metriport from "../../../../..";
import { default as URLSearchParams } from "@ungap/url-search-params";
import * as serializers from "../../../../../../serialization";
import urlJoin from "url-join";
import * as errors from "../../../../../../errors";

export declare namespace Patient {
    interface Options {
        environment?: core.Supplier<environments.MetriportEnvironment | string>;
        apiKey: core.Supplier<string>;
    }

    interface RequestOptions {
        timeoutInSeconds?: number;
    }
}

export class Patient {
    constructor(protected readonly _options: Patient.Options) {}

    /**
     * Creates a Patient in Metriport for the specified Facility where the patient is receiving care.
     *
     * The more demographic info you can provide about a Patient,
     * the higher chances Metriport will be able to find a match.
     * For example, nicknames, old addresses, multiple phone numbers,
     * a pre-marital last name, etc.
     *
     */
    public async create(
        request: Metriport.medical.PatientCreate,
        requestOptions?: Patient.RequestOptions
    ): Promise<Metriport.medical.Patient> {
        const { facilityId, body: _body } = request;
        const _queryParams = new URLSearchParams();
        _queryParams.append("facilityId", facilityId);
        const _response = await core.fetcher({
            url: urlJoin(
                (await core.Supplier.get(this._options.environment)) ?? environments.MetriportEnvironment.Production,
                "/patient"
            ),
            method: "POST",
            headers: {
                "X-API-Key": await core.Supplier.get(this._options.apiKey),
                "X-Fern-Language": "JavaScript",
            },
            contentType: "application/json",
            queryParameters: _queryParams,
            body: await serializers.medical.BasePatient.jsonOrThrow(_body, { unrecognizedObjectKeys: "strip" }),
            timeoutMs: requestOptions?.timeoutInSeconds != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
        });
        if (_response.ok) {
            return await serializers.medical.Patient.parseOrThrow(_response.body, {
                unrecognizedObjectKeys: "passthrough",
                allowUnrecognizedUnionMembers: true,
                allowUnrecognizedEnumValues: true,
                breadcrumbsPrefix: ["response"],
            });
        }

        if (_response.error.reason === "status-code") {
            throw new errors.MetriportError({
                statusCode: _response.error.statusCode,
                body: _response.error.body,
            });
        }

        switch (_response.error.reason) {
            case "non-json":
                throw new errors.MetriportError({
                    statusCode: _response.error.statusCode,
                    body: _response.error.rawBody,
                });
            case "timeout":
                throw new errors.MetriportTimeoutError();
            case "unknown":
                throw new errors.MetriportError({
                    message: _response.error.errorMessage,
                });
        }
    }

    /**
     * Get a Patient
     */
    public async get(id: string, requestOptions?: Patient.RequestOptions): Promise<Metriport.medical.Patient> {
        const _response = await core.fetcher({
            url: urlJoin(
                (await core.Supplier.get(this._options.environment)) ?? environments.MetriportEnvironment.Production,
                `/patient/${id}`
            ),
            method: "GET",
            headers: {
                "X-API-Key": await core.Supplier.get(this._options.apiKey),
                "X-Fern-Language": "JavaScript",
            },
            contentType: "application/json",
            timeoutMs: requestOptions?.timeoutInSeconds != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
        });
        if (_response.ok) {
            return await serializers.medical.Patient.parseOrThrow(_response.body, {
                unrecognizedObjectKeys: "passthrough",
                allowUnrecognizedUnionMembers: true,
                allowUnrecognizedEnumValues: true,
                breadcrumbsPrefix: ["response"],
            });
        }

        if (_response.error.reason === "status-code") {
            throw new errors.MetriportError({
                statusCode: _response.error.statusCode,
                body: _response.error.body,
            });
        }

        switch (_response.error.reason) {
            case "non-json":
                throw new errors.MetriportError({
                    statusCode: _response.error.statusCode,
                    body: _response.error.rawBody,
                });
            case "timeout":
                throw new errors.MetriportTimeoutError();
            case "unknown":
                throw new errors.MetriportError({
                    message: _response.error.errorMessage,
                });
        }
    }

    /**
     * Updates the specified Patient.
     */
    public async update(
        id: string,
        request: Metriport.medical.PatientUpdate,
        requestOptions?: Patient.RequestOptions
    ): Promise<Metriport.medical.Patient> {
        const { facilityId, body: _body } = request;
        const _queryParams = new URLSearchParams();
        _queryParams.append("facilityId", facilityId);
        const _response = await core.fetcher({
            url: urlJoin(
                (await core.Supplier.get(this._options.environment)) ?? environments.MetriportEnvironment.Production,
                `/patient/${id}`
            ),
            method: "PUT",
            headers: {
                "X-API-Key": await core.Supplier.get(this._options.apiKey),
                "X-Fern-Language": "JavaScript",
            },
            contentType: "application/json",
            queryParameters: _queryParams,
            body: await serializers.medical.BasePatient.jsonOrThrow(_body, { unrecognizedObjectKeys: "strip" }),
            timeoutMs: requestOptions?.timeoutInSeconds != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
        });
        if (_response.ok) {
            return await serializers.medical.Patient.parseOrThrow(_response.body, {
                unrecognizedObjectKeys: "passthrough",
                allowUnrecognizedUnionMembers: true,
                allowUnrecognizedEnumValues: true,
                breadcrumbsPrefix: ["response"],
            });
        }

        if (_response.error.reason === "status-code") {
            throw new errors.MetriportError({
                statusCode: _response.error.statusCode,
                body: _response.error.body,
            });
        }

        switch (_response.error.reason) {
            case "non-json":
                throw new errors.MetriportError({
                    statusCode: _response.error.statusCode,
                    body: _response.error.rawBody,
                });
            case "timeout":
                throw new errors.MetriportTimeoutError();
            case "unknown":
                throw new errors.MetriportError({
                    message: _response.error.errorMessage,
                });
        }
    }

    /**
     * Lists all Patients receiving care at the specified Facility.
     */
    public async list(
        request: Metriport.medical.PatientList = {},
        requestOptions?: Patient.RequestOptions
    ): Promise<Metriport.medical.ListPatientsResponse> {
        const { facilityId } = request;
        const _queryParams = new URLSearchParams();
        if (facilityId != null) {
            _queryParams.append("facilityId", facilityId);
        }

        const _response = await core.fetcher({
            url: urlJoin(
                (await core.Supplier.get(this._options.environment)) ?? environments.MetriportEnvironment.Production,
                "/patient"
            ),
            method: "GET",
            headers: {
                "X-API-Key": await core.Supplier.get(this._options.apiKey),
                "X-Fern-Language": "JavaScript",
            },
            contentType: "application/json",
            queryParameters: _queryParams,
            timeoutMs: requestOptions?.timeoutInSeconds != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
        });
        if (_response.ok) {
            return await serializers.medical.ListPatientsResponse.parseOrThrow(_response.body, {
                unrecognizedObjectKeys: "passthrough",
                allowUnrecognizedUnionMembers: true,
                allowUnrecognizedEnumValues: true,
                breadcrumbsPrefix: ["response"],
            });
        }

        if (_response.error.reason === "status-code") {
            throw new errors.MetriportError({
                statusCode: _response.error.statusCode,
                body: _response.error.body,
            });
        }

        switch (_response.error.reason) {
            case "non-json":
                throw new errors.MetriportError({
                    statusCode: _response.error.statusCode,
                    body: _response.error.rawBody,
                });
            case "timeout":
                throw new errors.MetriportTimeoutError();
            case "unknown":
                throw new errors.MetriportError({
                    message: _response.error.errorMessage,
                });
        }
    }

    /**
     * Removes the specified Patient.
     */
    public async delete(
        id: string,
        request: Metriport.medical.PatientDelete = {},
        requestOptions?: Patient.RequestOptions
    ): Promise<void> {
        const { facilityId } = request;
        const _queryParams = new URLSearchParams();
        if (facilityId != null) {
            _queryParams.append("facilityId", facilityId);
        }

        const _response = await core.fetcher({
            url: urlJoin(
                (await core.Supplier.get(this._options.environment)) ?? environments.MetriportEnvironment.Production,
                `/patient/${id}`
            ),
            method: "DELETE",
            headers: {
                "X-API-Key": await core.Supplier.get(this._options.apiKey),
                "X-Fern-Language": "JavaScript",
            },
            contentType: "application/json",
            queryParameters: _queryParams,
            timeoutMs: requestOptions?.timeoutInSeconds != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
        });
        if (_response.ok) {
            return;
        }

        if (_response.error.reason === "status-code") {
            throw new errors.MetriportError({
                statusCode: _response.error.statusCode,
                body: _response.error.body,
            });
        }

        switch (_response.error.reason) {
            case "non-json":
                throw new errors.MetriportError({
                    statusCode: _response.error.statusCode,
                    body: _response.error.rawBody,
                });
            case "timeout":
                throw new errors.MetriportTimeoutError();
            case "unknown":
                throw new errors.MetriportError({
                    message: _response.error.errorMessage,
                });
        }
    }
}