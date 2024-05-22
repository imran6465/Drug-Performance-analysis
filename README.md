# Drug Performance Analysis

## Table of Contents
- [Introduction](#introduction)
- [Project Description](#project-description)
- [Database Schema](#database-schema)
- [Data Definitions](#data-definitions)
- [Constraints](#constraints)
- [Sample Data](#sample-data)
- [Usage](#usage)
- [ER Diagram](#er-diagram)
- [Contributing](#contributing)
- [License](#license)

## Introduction
The "Drug Performance Analysis" project is designed to analyze the performance of drugs prescribed to patients. It includes information about patients, doctors, prescriptions, clinical trials, reviews, and adverse events related to drug usage.

## Project Description
This project aims to create a robust database management system to store and analyze various aspects of drug performance. By integrating data from multiple sources, the system provides valuable insights into drug efficacy, side effects, and overall patient satisfaction. This analysis helps healthcare providers make informed decisions and improve patient outcomes.

### Why is it useful?
- **Improved Patient Care:** By analyzing drug performance, healthcare providers can identify the most effective treatments and reduce adverse events.
- **Informed Decisions:** Doctors and researchers can make data-driven decisions based on comprehensive drug performance data.
- **Regulatory Compliance:** Ensures that drugs meet safety and efficacy standards through continuous monitoring and analysis.

### Problem it Solves
The project addresses the challenge of managing and analyzing large volumes of data related to drug performance. It provides a centralized system to track prescriptions, patient feedback, clinical trial results, and adverse events, ensuring data integrity and accessibility for better healthcare outcomes.

## Database Schema
The database consists of the following tables:

1. **Patient**: Contains information about patients.
2. **Doctor**: Contains information about doctors prescribing the drugs.
3. **Drug**: Contains information about the drugs being analyzed.
4. **Prescription**: Contains information about prescriptions issued to patients.
5. **Reviews**: Contains information about reviews given by patients on the drugs.
6. **Clinical Trial**: Contains information about the clinical trials conducted on the drugs.
7. **Adverse Event**: Contains information about adverse events experienced by patients while using the drugs.

## Data Definitions

### Patient Table
- `patient_id` (integer, primary key)
- `name` (varchar(50))
- `date_of_birth` (date)
- `gender` (varchar(10))
- `address` (varchar(100))
- `phone_number` (varchar(20))
- `email` (varchar(50))

### Doctor Table
- `doctor_id` (integer, primary key)
- `doctor_name` (varchar(50))
- `specialization` (varchar(50))
- `contact_details` (varchar(100))

### Drug Table
- `drug_id` (integer, primary key)
- `drug_name` (varchar(50))
- `drug_type` (varchar(50))
- `manufacturer` (varchar(50))
- `approval_date` (date)
- `side_effects` (varchar(100))
- `price` (decimal(10,2))
- `form` (varchar(50))
- `type` (varchar(50))

### Prescription Table
- `prescription_id` (integer, primary key)
- `patient_id` (integer, foreign key referencing Patient table)
- `drug_id` (integer, foreign key referencing Drug table)
- `diagnosis` (varchar(100))
- `dosage` (varchar(20))
- `frequency` (varchar(20))
- `start_date` (date)
- `end_date` (date)

### Reviews Table
- `review_id` (integer, primary key)
- `drug_id` (integer, foreign key referencing Drug table)
- `prescription_id` (integer, foreign key referencing Prescription table)
- `satisfaction` (integer)
- `ease_of_use` (integer)
- `effectiveness` (integer)
- `reviews` (varchar(500))

### Clinical Trial Table
- `trial_id` (integer, primary key)
- `drug_id` (integer, foreign key referencing Drug table)
- `trial_date` (date)
- `sample_size` (integer)
- `success_rate` (decimal(10,2))
- `adverse_events` (varchar(100))
- `results` (varchar(100))

### Adverse Event Table
- `event_id` (integer, primary key)
- `prescription_id` (integer, foreign key referencing Prescription table)
- `event_date` (date)
- `event_description` (varchar(100))
- `severity_level` (varchar(20))

## Constraints
- **Primary Keys:** Ensure unique identification of records in each table.
- **Foreign Keys:** Ensure referential integrity between related tables.

## Sample Data
Here are some examples of data operations:

### Inserting Data
```sql
INSERT INTO Patient (patient_id, name, date_of_birth, gender, address, phone_number, email) 
VALUES (1, 'John Doe', '1990-05-15', 'Male', '123 Main St, Anytown USA', '555-555-1234', 'johndoe@example.com');

INSERT INTO Doctor (doctor_id, doctor_name, specialization, contact_details) 
VALUES (1, 'Dr. Smith', 'Cardiology', '123-456-7890');
```

### Updating Data
```sql
UPDATE Patient 
SET phone_number = '555-555-5678' 
WHERE patient_id = 1;
```

### Deleting Data
```sql
DELETE FROM Patient 
WHERE patient_id = 1;
```

### Selecting Data
```sql
SELECT * FROM Patient;
```

## Usage
To use this project:
1. Clone the repository.
2. Set up the database using the provided DDL scripts.
3. Insert sample data using the provided DML scripts.
4. Query the database to analyze drug performance.

## ER Diagram
Include the ER diagram here to visualize the relationships between the tables.

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License
This project is licensed under the MIT License.

---

Feel free to customize this README further based on your project's specifics and any additional information you want to include.
