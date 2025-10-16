from faker import Faker
from random import randint, choice, uniform
from datetime import timedelta
import os

fake = Faker()
num_records = 10

    # --- Location ---
for i in range(1, num_records + 1):
        name = fake.company()
        address = fake.street_address()
        state = fake.state()
        zip_code = fake.zipcode()
        website = fake.url()
        phone = fake.phone_number()
        print(f"INSERT INTO location (location_name, location_address, location_state, location_zip, location_website, location_phone) "
                f"VALUES ('{name}', '{address}', '{state}', '{zip_code}', '{website}', '{phone}');\n")
print(f"Generated {num_records} locations.")
    
    # --- Provider ---
for i in range(1, num_records + 1):
        npi = fake.random_number(digits=10, fix_len=True)
        first = fake.first_name()
        last = fake.last_name()
        taxonomy = fake.lexify(text='??????????')
        area_code = randint(200, 999)
        exchange = randint(200, 999)
        subscriber = randint(1000, 9999)
        cell = f"{area_code}-{exchange}-{subscriber}"
        print(f"INSERT INTO provider (provider_npi, provider_first_name, provider_last_name, taxonomy_code, cell_number) "
                f"VALUES ('{npi}', '{first}', '{last}', '{taxonomy}', '{cell}');\n")
print(f"Generated {num_records} providers.")
    
    # --- License ---
for i in range(1, num_records + 1):
        number = fake.bothify(text='??##??##')
        state = fake.state()
        start = fake.date_between(start_date='-5y', end_date='-1y')
        end = fake.date_between(start_date='today', end_date='+2y')
        board = fake.company()
        provider_id = randint(1, num_records)
        print(f"INSERT INTO license (license_number, license_state, license_start, license_end, license_board, provider_id) "
                f"VALUES ('{number}', '{state}', '{start}', '{end}', '{board}', {provider_id});\n")
print(f"Generated {num_records} licenses.")
    
    # --- Insurance ---
for i in range(1, num_records + 1):
        company = fake.company()
        policy = fake.bothify(text='??##??##')
        type_ = choice(['Medical', 'Dental', 'Vision', 'Liability'])
        start = fake.date_between(start_date='-3y', end_date='-1y')
        end = fake.date_between(start_date='today', end_date='+2y')
        full = round(uniform(100000, 500000), 2)
        aggregate = round(uniform(500000, 1000000), 2)
        print(f"INSERT INTO insurance (insurance_company, insurance_policy_number, insurance_type, insurance_start, insurance_end, insurance_amount_full, insurance_amount_aggregate) "
                f"VALUES ('{company}', '{policy}', '{type_}', '{start}', '{end}', {full}, {aggregate});\n")
print(f"Generated {num_records} insurances.")
    
    # --- ProviderLocation ---
    # for i in range(1, num_records + 1):
    #    provider_id = randint(1, num_records)
    #   location_id = randint(1, num_records)
    #  print(f"INSERT INTO provider_location (provider_id, location_id) VALUES ({provider_id}, {location_id});\n")
    
    # --- ProviderInsurance ---
    #for i in range(1, num_records + 1):
    #    provider_id = randint(1, num_records)
    #    insurance_id = randint(1, num_records)
    #    print(f"INSERT INTO provider_insurance (provider_id, insurance_id) VALUES ({provider_id}, {insurance_id});\n")