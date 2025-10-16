-- Active: 1759930206245@@127.0.0.1@3306@credential_info
DROP TABLE IF EXISTS provider_insurance;
DROP TABLE IF EXISTS provider_location;
DROP TABLE IF EXISTS insurance;
DROP TABLE IF EXISTS license;
DROP TABLE IF EXISTS provider;
DROP TABLE IF EXISTS location;


CREATE TABLE location (
    location_id int NOT NULL AUTO_INCREMENT,
    location_name VARCHAR(255) NOT NULL,
    location_address VARCHAR(100) NOT NULL,
    location_state VARCHAR(100) NOT NULL,
    location_zip VARCHAR(20) NOT NULL,
    location_website VARCHAR(200),
    location_phone VARCHAR(20),
    PRIMARY KEY (location_id)
);

CREATE TABLE provider(
    provider_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    provider_npi VARCHAR(20) NOT NULL,
    provider_first_name VARCHAR(100) NOT NULL,
    provider_last_name VARCHAR(100) NOT NULL,
    taxonomy_code VARCHAR(100),
    cell_number VARCHAR(20)
);

CREATE TABLE license (
    license_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    license_number VARCHAR(100) NOT NULL,
    license_state VARCHAR(100) NOT NULL,
    license_start DATE,
    license_end DATE,
    license_board VARCHAR(100),
    provider_id int,
    FOREIGN KEY (provider_id) REFERENCES provider(provider_id) ON DELETE CASCADE
);

CREATE TABLE insurance (
    insurance_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    insurance_company VARCHAR(255) NOT NULL,
    insurance_policy_number VARCHAR(100) NOT NULL,
    insurance_type VARCHAR(100),
    insurance_start DATE,
    insurance_end DATE,
    insurance_amount_full DECIMAL(15,2),
    insurance_amount_aggregate DECIMAL(15,2)
);

CREATE TABLE provider_location (
    provider_location_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    provider_id int,
    location_id int,
    FOREIGN KEY (provider_id) REFERENCES provider(provider_id) ON DELETE CASCADE,
    FOREIGN KEY (location_id) REFERENCES location(location_id) ON DELETE CASCADE
);

CREATE TABLE provider_insurance (
    provider_insurance_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    provider_id int,
    insurance_id int,
    FOREIGN KEY (provider_id) REFERENCES provider(provider_id) ON DELETE CASCADE,
    FOREIGN KEY (insurance_id) REFERENCES insurance(insurance_id) ON DELETE CASCADE
);