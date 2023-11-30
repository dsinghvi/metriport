import os

from generated.client import Metriport
from generated import commons
from generated.resources import medical, UsState, Address
from generated.resources.medical import BasePatient, PersonalIdentifier_DriversLicense


import os
from dotenv import load_dotenv

load_dotenv()

api_key = os.environ.get("METRIPORT_API_KEY")
facility_id = os.environ.get("FACILITY_ID")
base_url = os.environ.get("BASE_URL")


def test_get_all_patients() -> None:
    """
    The function `get_all_patients` retrieves a list of all patients from a medical API and prints their
    IDs.
    """
    client = Metriport(api_key=api_key, base_url=base_url)
    patient_data = BasePatient(
        first_name="John",
        last_name="Doe",
        dob="1980-01-01",
        gender_at_birth="M",
        personal_identifiers=[
            PersonalIdentifier_DriversLicense(
                type="driversLicense",
                state=UsState.CA,
                value="12345678",
            )
        ],
        address=[Address(
            address_line_1="123 Main St",
            city="Los Angeles",
            state=UsState.CA,
            zip="90001",
            country="USA"
        )]
    )
    response = client.medical.patient.create(facility_id=facility_id, request=patient_data)
    print(f"Received patient with ID: {response.id}")