-- Implement the logical data model (Data_Model.png) of Hospital database. --

-- Ensure
--    a. We use correct data type as available in MySQL
--    b. All Constraints are implemented as indicated (PK, FK, UK)
--    c. On Medication Table, restrict the usage of Brand as “CIPLA”, “GSK” and it should not allow null values.
--    d. The Date column in Prescribes table must not allow the prescription of future dates.
--    e. The end date column value cannot be earlier then start date in appointment and stay tables.
--    f. The duration (oncallstart to oncallend) in on_call table must not be more than 8 hours.

CREATE DATABASE hospital;

USE hospital;

CREATE TABLE IF NOT EXISTS `procedure`
(
	code INT UNSIGNED,
	name VARCHAR(20),
	cost REAL,
	PRIMARY KEY(code)
);

CREATE TABLE IF NOT EXISTS physician
(
	employeeid INT UNSIGNED,
	name VARCHAR(15),
	position VARCHAR(20),
	ssn INT UNSIGNED UNIQUE,
	PRIMARY KEY(employeeid)
);

CREATE TABLE IF NOT EXISTS trained_in
(
	physician INT UNSIGNED,
	treatment INT UNSIGNED,
	certificationdate DATE,
	certificationexpires DATE,
	PRIMARY KEY(physician,treatment),
	FOREIGN KEY (physician) REFERENCES physician(employeeid),
	FOREIGN KEY (treatment) REFERENCES `procedure`(code)
);

CREATE TABLE IF NOT EXISTS block
(
	blockfloor INT UNSIGNED,
	blockcode INT UNSIGNED,
	PRIMARY KEY(blockfloor,blockcode)
);

CREATE TABLE IF NOT EXISTS room
(
	roomnumber INT UNSIGNED,
	roomtype VARCHAR(15),
	blockfloor INT UNSIGNED,
	blockcode INT UNSIGNED,
	unavailable BOOLEAN,
	PRIMARY KEY(roomnumber),
	FOREIGN KEY (blockfloor,blockcode) REFERENCES block(blockfloor,blockcode)
);

CREATE TABLE IF NOT EXISTS patient
(
	ssn INT UNSIGNED,
	name VARCHAR(20),
	address VARCHAR(40),
	phone CHAR(10) UNIQUE,
	insuranceid INT UNSIGNED UNIQUE,
	pcp INT UNSIGNED,
	PRIMARY KEY(ssn),
	FOREIGN KEY (pcp) REFERENCES physician(employeeid)
);

CREATE TABLE IF NOT EXISTS stay
(
	stayid INT UNSIGNED,
	patient INT UNSIGNED,
	room INT UNSIGNED,
	start_time TIMESTAMP,
	end_time TIMESTAMP,
	PRIMARY KEY(stayid),
	FOREIGN KEY (patient) REFERENCES patient(ssn),
	FOREIGN KEY (room) REFERENCES room(roomnumber),
	CHECK (end_time > start_time)
);

CREATE TABLE IF NOT EXISTS nurse
(
	employeeid INT UNSIGNED,
	name VARCHAR(20),
	position VARCHAR(20),
	registered BOOLEAN,
	ssn INT UNSIGNED UNIQUE,
	PRIMARY KEY(employeeid)
);

CREATE TABLE IF NOT EXISTS department
(
	departmentid INT UNSIGNED,
	name VARCHAR(20),
	head INT UNSIGNED,
	PRIMARY KEY(departmentid),
	FOREIGN KEY (head) REFERENCES physician(employeeid)
);

CREATE TABLE IF NOT EXISTS affiliated_with
(
	physician INT UNSIGNED,
	department INT UNSIGNED,
	primaryaffiliation BOOLEAN,
	PRIMARY KEY(physician,department),
	FOREIGN KEY (physician) REFERENCES physician(employeeid),
	FOREIGN KEY (department) REFERENCES department(departmentid)
);

CREATE TABLE IF NOT EXISTS medication
(
	code INT UNSIGNED,
	name VARCHAR(20),
	brand VARCHAR(10) CHECK (brand IN ('CIPLA','GSK')) NOT NULL,
	description VARCHAR(30),
	PRIMARY KEY(code)
);

CREATE TABLE IF NOT EXISTS appointment
(
	appointmentid INT UNSIGNED,
	patient INT UNSIGNED,
	prepnurse INT UNSIGNED,
	physician INT UNSIGNED,
	start_dt_time TIMESTAMP,
	end_dt_time TIMESTAMP,
	examinationroom VARCHAR(20),
	PRIMARY KEY(appointmentid),
	FOREIGN KEY (patient) REFERENCES patient(ssn),
	FOREIGN KEY (prepnurse) REFERENCES nurse(employeeid),
	FOREIGN KEY (physician) REFERENCES physician(employeeid),
	CHECK (end_dt_time > start_dt_time)
);

CREATE TABLE IF NOT EXISTS prescribes
(
	physician INT UNSIGNED,
	patient INT UNSIGNED,
	medication INT UNSIGNED,
	`date` TIMESTAMP, -- CHECK(`date` <= current_timestamp),
	appointment INT UNSIGNED,
	dose VARCHAR(20),
	PRIMARY KEY(physician,patient,medication,`date`),
	FOREIGN KEY (physician) REFERENCES physician(employeeid),
	FOREIGN KEY (patient) REFERENCES patient(ssn),
	FOREIGN KEY (medication) REFERENCES medication(code),
	FOREIGN KEY (appointment) REFERENCES appointment(appointmentid)
);

CREATE TABLE IF NOT EXISTS undergoes
(
	patient INT UNSIGNED,
	`procedure` INT UNSIGNED,
	stay INT UNSIGNED,
	`date` TIMESTAMP,
	physician INT UNSIGNED,
	assistingnurse INT UNSIGNED,
	PRIMARY KEY(patient,`procedure`,stay,`date`),
	FOREIGN KEY (patient) REFERENCES patient(ssn),
	FOREIGN KEY (`procedure`) REFERENCES `procedure`(code),
	FOREIGN KEY (stay) REFERENCES stay(stayid),
	FOREIGN KEY (physician) REFERENCES physician(employeeid)
);

CREATE TABLE IF NOT EXISTS on_call
(
	nurse INT UNSIGNED,
	blockfloor INT UNSIGNED,
	blockcode INT UNSIGNED,
	oncallstart TIMESTAMP,
	oncallend TIMESTAMP,
	PRIMARY KEY(nurse,blockfloor,blockcode,oncallstart,oncallend),
	FOREIGN KEY (nurse) REFERENCES nurse(employeeid),
	FOREIGN KEY (blockfloor,blockcode) REFERENCES block(blockfloor,blockcode),
	CHECK ((oncallend - oncallstart) <= 8)
);
