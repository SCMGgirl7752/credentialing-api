-- Active: 1759930206245@@127.0.0.1@3306@credential_info
INSERT INTO location (location_name, location_address, location_state, location_zip, location_website, location_phone)
VALUES ('Fields, Avery and Lopez', '046 Ariana Lodge', 'Missouri', '49027', 'https://morse.com/', '924-555-2044');

INSERT INTO location (location_name, location_address, location_state, location_zip, location_website, location_phone)
VALUES ('Kelly, Murphy and Moore', '195 Garcia Union Apt. 724', 'Washington', '32545', 'https://butler.net/', '907-465-2043');



INSERT INTO provider (provider_npi, provider_first_name, provider_last_name, taxonomy_code, cell_number)
VALUES ('9118028528', 'Margaret', 'Marsh', 'pySfaAFMqU', '9077963142');

INSERT INTO provider (provider_npi, provider_first_name, provider_last_name, taxonomy_code, cell_number)
VALUES ('2457123242', 'Kevin', 'White', 'QVQScZcLFu', '5083192990');

INSERT INTO provider (provider_npi, provider_first_name, provider_last_name, taxonomy_code, cell_number)
VALUES ('4245484553', 'Christopher', 'Strong', 'makFFAkVJa', '2382100524');



INSERT INTO license (license_number, license_state, license_start, license_end, license_board, provider_id)
VALUES ('Qp56AT68', 'Georgia', '2024-06-12', '2026-10-01', 'Stevens LLC', 2);

INSERT INTO license (license_number, license_state, license_start, license_end, license_board, provider_id)
VALUES ('FH92WN92', 'Georgia', '2022-10-24', '2026-05-16', 'Johnson Ltd', 8);



INSERT INTO insurance (insurance_company, insurance_policy_number, insurance_type, insurance_start,
insurance_end, insurance_amount_full, insurance_amount_aggregate) VALUES ('Hawkins LLC', 'AR67Ww26',
'Liability', '2023-04-17', '2026-12-04', 486556.68, 905542.62);

INSERT INTO provider_location (provider_id, location_id) VALUES (1, 1);
INSERT INTO provider_location (provider_id, location_id) VALUES (2, 2);

INSERT INTO provider_insurance (provider_id, insurance_id) VALUES (1, 1);
