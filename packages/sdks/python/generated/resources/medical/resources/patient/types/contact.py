# This file was auto-generated by Fern from our API Definition.

import datetime as dt
import typing

from ......core.datetime_utils import serialize_datetime
from .facility_id import FacilityId

try:
    import pydantic.v1 as pydantic  # type: ignore
except ImportError:
    import pydantic  # type: ignore


class Contact(pydantic.BaseModel):
    """
    from metriport.resources.medical import Contact

    Contact(
        phone="1234567899",
        email="karen@cvspharmacy.com",
        facility_ids=[
            "2.16.840.1.113883.3.666.5.2004.4.2005",
            "2.16.840.1.113883.3.666.123",
        ],
    )
    """

    phone: typing.Optional[str] = pydantic.Field(
        description="The Patient's 10 digit phone number, formatted `1234567899`."
    )
    email: typing.Optional[str] = pydantic.Field(description="The Patient's email address.")
    facility_ids: typing.List[FacilityId] = pydantic.Field(
        alias="facilityIds", description="Array of the IDs of the Facilities where the Patient is receiving care."
    )

    def json(self, **kwargs: typing.Any) -> str:
        kwargs_with_defaults: typing.Any = {"by_alias": True, "exclude_unset": True, **kwargs}
        return super().json(**kwargs_with_defaults)

    def dict(self, **kwargs: typing.Any) -> typing.Dict[str, typing.Any]:
        kwargs_with_defaults: typing.Any = {"by_alias": True, "exclude_unset": True, **kwargs}
        return super().dict(**kwargs_with_defaults)

    class Config:
        frozen = True
        smart_union = True
        allow_population_by_field_name = True
        json_encoders = {dt.datetime: serialize_datetime}