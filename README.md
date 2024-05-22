# Drug-Performance-analysis
The project begins with a comprehensive data collection phase, where relevant  datasets are obtained and curated. These datasets encompass a wide range of  variables, including patient demographics, treatment protocols, drug dosages, adverse  events, and treatment responses.

Table of Contents
Introduction
Project Description
Database Schema
Data Definitions
Constraints
Sample Data
Usage
ER Diagram
Contributing
License
Introduction
This project is designed to analyze the performance of drugs prescribed to patients. It includes information about patients, doctors, prescriptions, clinical trials, reviews, and adverse events related to drug usage.

Project Description
The "Drug Performance Analysis" project aims to create a robust database management system to store and analyze various aspects of drug performance. It involves multiple tables interconnected through primary and foreign keys to maintain data integrity and consistency.

Database Schema
The database consists of the following tables:

Patient: Contains information about patients.
Doctor: Contains information about doctors prescribing the drugs.
Drug: Contains information about the drugs being analyzed.
Prescription: Contains information about prescriptions issued to patients.
Reviews: Contains information about reviews given by patients on the drugs.
Clinical Trial: Contains information about the clinical trials conducted on the drugs.
Adverse Event: Contains information about adverse events experienced by patients while using the drugs.
Data Definitions
Patient Table
patient_id (integer, primary key)
name (varchar(50))
date_of_birth (date)
gender (varchar(10))
address (varchar(100))
phone_number (varchar(20))
email (varchar(50))
Doctor Table
doctor_id (integer, primary key)
doctor_name (varchar(50))
specialization (varchar(50))
contact_details (varchar(100))
Drug Table
drug_id (integer, primary key)
drug_name (varchar(50))
drug_type (varchar(50))
manufacturer (varchar(50))
approval_date (date)
side_effects (varchar(100))
price (decimal(10,2))
form (varchar(50))
type (varchar(50))
Prescription Table
prescription_id (integer, primary key)
patient_id (integer, foreign key referencing Patient table)
drug_id (integer, foreign key referencing Drug table)
diagnosis (varchar(100))
dosage (varchar(20))
frequency (varchar(20))
start_date (date)
end_date (date)
Reviews Table
review_id (integer, primary key)
drug_id (integer, foreign key referencing Drug table)
prescription_id (integer, foreign key referencing Prescription table)
satisfaction (integer)
ease_of_use (integer)
effectiveness (integer)
reviews (integer)
Clinical Trial Table
trial_id (integer, primary key)
drug_id (integer, foreign key referencing Drug table)
trial_date (date)
sample_size (integer)
success_rate (decimal(10,2))
adverse_events (varchar(100))
results (varchar(100))
Adverse Event Table
event_id (integer, primary key)
prescription_id (integer, foreign key referencing Prescription table)
event_date (date)
event_description (varchar(100))
severity_level (varchar(20))
Constraints
Each table's primary key constraint ensures unique identification of records.
Foreign key constraints ensure referential integrity between tables.
Sample Data
Here are some examples of data operations:

Inserting Data
sql
Copy code
INSERT INTO Patient (patient_id, name, date_of_birth, gender, address, phone_number, email) 
VALUES (1, 'John Doe', '1990-05-15', 'Male', '123 Main St, Anytown USA', '555-555-1234', 'johndoe@example.com');

INSERT INTO Doctor (doctor_id, doctor_name, specialization, contact_details) 
VALUES (1, 'Dr. Smith', 'Cardiology', '123-456-7890');
Updating Data
sql
Copy code
UPDATE Patient 
SET phone_number = '555-555-5678' 
WHERE patient_id = 1;
Deleting Data
sql
Copy code
DELETE FROM Patient 
WHERE patient_id = 1;
Selecting Data
sql
Copy code
SELECT * FROM Patient;
Usage
To use this project:

Clone the repository.
Set up the database using the provided DDL scripts.
Insert sample data using the provided DML scripts.
Query the database to analyze drug performance.
ER Diagram
Include the ER diagram here to visualize the relationships between the tables.

Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.
