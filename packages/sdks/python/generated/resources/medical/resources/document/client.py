# This file was auto-generated by Fern from our API Definition.

import typing
import urllib.parse
from json.decoder import JSONDecodeError

from .....core.api_error import ApiError
from .....core.client_wrapper import AsyncClientWrapper, SyncClientWrapper
from .....core.remove_none_from_dict import remove_none_from_dict
from .types.conversion_type import ConversionType
from .types.document_query import DocumentQuery
from .types.document_url import DocumentUrl
from .types.list_documents_response import ListDocumentsResponse

try:
    import pydantic.v1 as pydantic  # type: ignore
except ImportError:
    import pydantic  # type: ignore


class DocumentClient:
    def __init__(self, *, client_wrapper: SyncClientWrapper):
        self._client_wrapper = client_wrapper

    def start_query(self, *, patient_id: str, facility_id: str) -> DocumentQuery:
        """
        Triggers a document query for the specified patient across HIEs.
        When executed, this endpoint triggers an asynchronous document query across HIEs.
        This is a two step process where the documents will first be downloaded from
        the respective HIE and, if they are C-CDA/XML, then converted to FHIR.
        Each process (download, conversion) will contain its own `total` and `status`
        as well as the count for `successful` operations and `errors`.
        When the asynchronous document query finishes, it stores new/updated document
        references for future requests and updates the status of download to `completed`.
        Meanwhile, in the background, files will be converted and the convert count will be
        incremented. Once all documents have been converted it too will be marked as `completed`.
        If there's no document to be converted, the total will be set to zero and
        the status to `completed`.

        Parameters:
            - patient_id: str. The ID of the Patient for which to list available Documents.

            - facility_id: str. The ID of the Facility where the patient is receiving care.
        ---
        from metriport.client import Metriport

        client = Metriport(
            api_key="YOUR_API_KEY",
        )
        client.medical.document.start_query(
            patient_id="12345678",
            facility_id="12345678",
        )
        """
        _response = self._client_wrapper.httpx_client.request(
            "POST",
            urllib.parse.urljoin(f"{self._client_wrapper.get_base_url()}/", "medical/v1/document/query"),
            params=remove_none_from_dict({"patientId": patient_id, "facilityId": facility_id}),
            headers=self._client_wrapper.get_headers(),
            timeout=60,
        )
        if 200 <= _response.status_code < 300:
            return pydantic.parse_obj_as(DocumentQuery, _response.json())  # type: ignore
        try:
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)

    def get_query_status(self, *, patient_id: str) -> DocumentQuery:
        """
        Returns the document query status for the specified patient.
        Can be used in to check the progress when the final status
        of the document query is taking longer than expected.
        See more on [Start Document Query](/medical-api/api-reference/document/start-document-query).

        Parameters:
            - patient_id: str. The ID of the Patient for which to list available Documents.
        ---
        from metriport.client import Metriport

        client = Metriport(
            api_key="YOUR_API_KEY",
        )
        client.medical.document.get_query_status(
            patient_id="12345678",
        )
        """
        _response = self._client_wrapper.httpx_client.request(
            "POST",
            urllib.parse.urljoin(f"{self._client_wrapper.get_base_url()}/", "medical/v1/document/query"),
            params=remove_none_from_dict({"patientId": patient_id}),
            headers=self._client_wrapper.get_headers(),
            timeout=60,
        )
        if 200 <= _response.status_code < 300:
            return pydantic.parse_obj_as(DocumentQuery, _response.json())  # type: ignore
        try:
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)

    def list(
        self,
        *,
        patient_id: str,
        facility_id: str,
        date_from: typing.Optional[str] = None,
        date_to: typing.Optional[str] = None,
    ) -> ListDocumentsResponse:
        """
        Lists all Documents that can be retrieved for a Patient.
        This endpoint returns the document references available
        at Metriport which are associated with the given Patient.
        To start a new document query, see the [Start Document Query endpoint](/api-reference/medical/document/start-query).

        Parameters:
            - patient_id: str. The ID of the Patient for which to list available Documents.

            - facility_id: str. The ID of the Facility where the patient is receiving care.

            - date_from: typing.Optional[str]. The start date (inclusive) for which to filter returned documents - formatted `YYYY-MM-DD` as per ISO 8601. If not provided, no start date filter will be applied.

            - date_to: typing.Optional[str]. The end date (inclusive) for which to filter returned documents - formatted `YYYY-MM-DD` as per ISO 8601. If not provided, no end date filter will be applied.
        ---
        from metriport.client import Metriport

        client = Metriport(
            api_key="YOUR_API_KEY",
        )
        client.medical.document.list(
            patient_id="12345678",
            facility_id="12345678",
        )
        """
        _response = self._client_wrapper.httpx_client.request(
            "GET",
            urllib.parse.urljoin(f"{self._client_wrapper.get_base_url()}/", "medical/v1/document"),
            params=remove_none_from_dict(
                {"patientId": patient_id, "facilityId": facility_id, "dateFrom": date_from, "dateTo": date_to}
            ),
            headers=self._client_wrapper.get_headers(),
            timeout=60,
        )
        if 200 <= _response.status_code < 300:
            return pydantic.parse_obj_as(ListDocumentsResponse, _response.json())  # type: ignore
        try:
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)

    def get_url(self, *, file_name: str, conversion_type: typing.Optional[ConversionType] = None) -> DocumentUrl:
        """
        Gets a presigned URL for downloading the specified document.
        This endpoint returns a URL which you can use to download
        the specified document and/or convert using the file name
        provided from the [List Documents](/api-reference/medical/document/list) endpoint.

        Parameters:
            - file_name: str. The file name of the document

            - conversion_type: typing.Optional[ConversionType]. The doc type to convert to. Either `html` or `pdf`.
                                                                This parameter should only be used for converting XML/CDA files.
                                                                ---
        from metriport.client import Metriport
        from metriport.resources.medical import ConversionType

        client = Metriport(
            api_key="YOUR_API_KEY",
        )
        client.medical.document.get_url(
            file_name="x-ray",
            conversion_type=ConversionType.PDF,
        )
        """
        _response = self._client_wrapper.httpx_client.request(
            "GET",
            urllib.parse.urljoin(f"{self._client_wrapper.get_base_url()}/", "medical/v1/document/downloadUrl"),
            params=remove_none_from_dict({"fileName": file_name, "conversionType": conversion_type}),
            headers=self._client_wrapper.get_headers(),
            timeout=60,
        )
        if 200 <= _response.status_code < 300:
            return pydantic.parse_obj_as(DocumentUrl, _response.json())  # type: ignore
        try:
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)


class AsyncDocumentClient:
    def __init__(self, *, client_wrapper: AsyncClientWrapper):
        self._client_wrapper = client_wrapper

    async def start_query(self, *, patient_id: str, facility_id: str) -> DocumentQuery:
        """
        Triggers a document query for the specified patient across HIEs.
        When executed, this endpoint triggers an asynchronous document query across HIEs.
        This is a two step process where the documents will first be downloaded from
        the respective HIE and, if they are C-CDA/XML, then converted to FHIR.
        Each process (download, conversion) will contain its own `total` and `status`
        as well as the count for `successful` operations and `errors`.
        When the asynchronous document query finishes, it stores new/updated document
        references for future requests and updates the status of download to `completed`.
        Meanwhile, in the background, files will be converted and the convert count will be
        incremented. Once all documents have been converted it too will be marked as `completed`.
        If there's no document to be converted, the total will be set to zero and
        the status to `completed`.

        Parameters:
            - patient_id: str. The ID of the Patient for which to list available Documents.

            - facility_id: str. The ID of the Facility where the patient is receiving care.
        ---
        from metriport.client import AsyncMetriport

        client = AsyncMetriport(
            api_key="YOUR_API_KEY",
        )
        await client.medical.document.start_query(
            patient_id="12345678",
            facility_id="12345678",
        )
        """
        _response = await self._client_wrapper.httpx_client.request(
            "POST",
            urllib.parse.urljoin(f"{self._client_wrapper.get_base_url()}/", "medical/v1/document/query"),
            params=remove_none_from_dict({"patientId": patient_id, "facilityId": facility_id}),
            headers=self._client_wrapper.get_headers(),
            timeout=60,
        )
        if 200 <= _response.status_code < 300:
            return pydantic.parse_obj_as(DocumentQuery, _response.json())  # type: ignore
        try:
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)

    async def get_query_status(self, *, patient_id: str) -> DocumentQuery:
        """
        Returns the document query status for the specified patient.
        Can be used in to check the progress when the final status
        of the document query is taking longer than expected.
        See more on [Start Document Query](/medical-api/api-reference/document/start-document-query).

        Parameters:
            - patient_id: str. The ID of the Patient for which to list available Documents.
        ---
        from metriport.client import AsyncMetriport

        client = AsyncMetriport(
            api_key="YOUR_API_KEY",
        )
        await client.medical.document.get_query_status(
            patient_id="12345678",
        )
        """
        _response = await self._client_wrapper.httpx_client.request(
            "POST",
            urllib.parse.urljoin(f"{self._client_wrapper.get_base_url()}/", "medical/v1/document/query"),
            params=remove_none_from_dict({"patientId": patient_id}),
            headers=self._client_wrapper.get_headers(),
            timeout=60,
        )
        if 200 <= _response.status_code < 300:
            return pydantic.parse_obj_as(DocumentQuery, _response.json())  # type: ignore
        try:
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)

    async def list(
        self,
        *,
        patient_id: str,
        facility_id: str,
        date_from: typing.Optional[str] = None,
        date_to: typing.Optional[str] = None,
    ) -> ListDocumentsResponse:
        """
        Lists all Documents that can be retrieved for a Patient.
        This endpoint returns the document references available
        at Metriport which are associated with the given Patient.
        To start a new document query, see the [Start Document Query endpoint](/api-reference/medical/document/start-query).

        Parameters:
            - patient_id: str. The ID of the Patient for which to list available Documents.

            - facility_id: str. The ID of the Facility where the patient is receiving care.

            - date_from: typing.Optional[str]. The start date (inclusive) for which to filter returned documents - formatted `YYYY-MM-DD` as per ISO 8601. If not provided, no start date filter will be applied.

            - date_to: typing.Optional[str]. The end date (inclusive) for which to filter returned documents - formatted `YYYY-MM-DD` as per ISO 8601. If not provided, no end date filter will be applied.
        ---
        from metriport.client import AsyncMetriport

        client = AsyncMetriport(
            api_key="YOUR_API_KEY",
        )
        await client.medical.document.list(
            patient_id="12345678",
            facility_id="12345678",
        )
        """
        _response = await self._client_wrapper.httpx_client.request(
            "GET",
            urllib.parse.urljoin(f"{self._client_wrapper.get_base_url()}/", "medical/v1/document"),
            params=remove_none_from_dict(
                {"patientId": patient_id, "facilityId": facility_id, "dateFrom": date_from, "dateTo": date_to}
            ),
            headers=self._client_wrapper.get_headers(),
            timeout=60,
        )
        if 200 <= _response.status_code < 300:
            return pydantic.parse_obj_as(ListDocumentsResponse, _response.json())  # type: ignore
        try:
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)

    async def get_url(self, *, file_name: str, conversion_type: typing.Optional[ConversionType] = None) -> DocumentUrl:
        """
        Gets a presigned URL for downloading the specified document.
        This endpoint returns a URL which you can use to download
        the specified document and/or convert using the file name
        provided from the [List Documents](/api-reference/medical/document/list) endpoint.

        Parameters:
            - file_name: str. The file name of the document

            - conversion_type: typing.Optional[ConversionType]. The doc type to convert to. Either `html` or `pdf`.
                                                                This parameter should only be used for converting XML/CDA files.
                                                                ---
        from metriport.client import AsyncMetriport
        from metriport.resources.medical import ConversionType

        client = AsyncMetriport(
            api_key="YOUR_API_KEY",
        )
        await client.medical.document.get_url(
            file_name="x-ray",
            conversion_type=ConversionType.PDF,
        )
        """
        _response = await self._client_wrapper.httpx_client.request(
            "GET",
            urllib.parse.urljoin(f"{self._client_wrapper.get_base_url()}/", "medical/v1/document/downloadUrl"),
            params=remove_none_from_dict({"fileName": file_name, "conversionType": conversion_type}),
            headers=self._client_wrapper.get_headers(),
            timeout=60,
        )
        if 200 <= _response.status_code < 300:
            return pydantic.parse_obj_as(DocumentUrl, _response.json())  # type: ignore
        try:
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)