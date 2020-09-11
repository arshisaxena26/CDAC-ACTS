-- Data Model for Car Hire Business (Data_Model.png) --

-- Prepare CREATE TABLE STATEMENT based on your understanding of data types and width of mentioned entities.

-- Note: Please do not enforce any constraints as of now.

CREATE database car_hire_business;

USE car_hire_business;


CREATE TABLE IF NOT EXISTS customer
(
	customer_id INT UNSIGNED NOT NULL,
	customer_name VARCHAR(30),
	customer_details VARCHAR(50),
	gender CHAR(1),
	email_address VARCHAR(15),
	phone_number INT UNSIGNED,
	address_line_1 VARCHAR(15),
	address_line_2 VARCHAR(15),
	address_line_3 VARCHAR(15),
	town VARCHAR(10),
	county VARCHAR(10),
	country VARCHAR(10),
	PRIMARY KEY (customer_id)
);

CREATE TABLE IF NOT EXISTS booking
(
	booking_id INT UNSIGNED NOT NULL,
	date_from DATE,
	date_to DATE,
	confirmation_letter_sent_yn CHAR(1),
	payment_received_yn CHAR(1),
	PRIMARY KEY (booking_id)
);

CREATE TABLE IF NOT EXISTS booking_status
(
	booking_status_code VARCHAR(10) NOT NULL,
	booking_status_description VARCHAR(30),
	PRIMARY KEY (booking_status_code)
);

CREATE TABLE IF NOT EXISTS vehicle
(
	reg_number INT UNSIGNED NOT NULL,
	current_mileage DECIMAL(4,2),
	daily_hire_rate DECIMAL(4,2),
	date_mot_due DATE,
	engine_size DECIMAL(3,1),
	PRIMARY KEY (reg_number)
);

CREATE TABLE IF NOT EXISTS vehicle_category
(
	vehicle_category_code VARCHAR(10) NOT NULL,
	vehicle_category_description VARCHAR(30),
	PRIMARY KEY (vehicle_category_code)
);

CREATE TABLE IF NOT EXISTS model
(
	model_code VARCHAR(10) NOT NULL,
	daily_hire_rate DECIMAL(4,2),
	model_name VARCHAR(20),
	PRIMARY KEY (model_code)
);

CREATE TABLE IF NOT EXISTS manufacturer
(
	manufacturer_code VARCHAR(10) NOT NULL,
	manufacturer_name VARCHAR(30),
	manufacturer_details VARCHAR(50),
	PRIMARY KEY (manufacturer_code)
);
