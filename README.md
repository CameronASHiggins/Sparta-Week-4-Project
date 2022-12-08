# MySQL Employees Projects Week 4 - SOLID/OOP

### General Requirements
All projects:

- Must be run as Scrum projects
- Should be groups or 5 or 6
- Must apply SOLID & OO principles
- Must use the MVC pattern where there is a user interface
- Should use well-known design patterns where appropriate
- Must include comprehensive JUnit testing or equivalent
- Should begin with the creation of tests, in line with a test-driven development approach
- Must use log4j2 for appropriate runtime logging or equivalent
- Must implement appropriate exception handling
- Must be hosted on GitHub and thoroughly documented, through a README.md file

### Purpose
In addition to the general goals of projects, this project will give trainees an opportunity to:

- Use JDBC to read data from and write to the database
- Manage database connections efficiently and reliably
- Work with collections
- Write methods to serialize objects to JSON or XML
- Use the Jackson library for serialization and deserialization
- Write data to a text file
- Read employee data from a CSV, XML or JSON file and write it to the employees table
- Validate data using appropriate pattern matching technologies

### Requirements

Phase 1

- Download and install the Employees database for MySQL - see this installation guide
- Read from the employees table in the database using appropriate SQL
- Each record should be used to create a new object of a suitable class and these objects added to a suitable collection
- Implement the Data Access Object pattern for accessing the database and the Data Transfer Object pattern to decouple the database access part of the program from the front end
- Remember to close connections to the database as soon as they have been finished with

Phase 2

- Using Jackson object serialization, ObjectMapper, write a method that stores all the employees who worked in a chosen department during a specific period in a JSON-formatted file
  - You will need to use the department and dept_emp tables, following relationships to figure our which employees are in which department during the required period
- Similarly, write a method that stores the employees of the chosen & time period in XML using Jackson's XML serialization features, XMLMapper
- Allow the user to choose the file name, using a Scanner to get the user input
- The program should polymorphically write the data in the appropriate format depending on the file extension, using the Factory Method design pattern

Phase 3

- Given a .csv, .json or .xml file containing new employees, add this to the database table
- This should be done polymorphically, based on the file extension
- Any corrupt or duplicated data should be added to a separate collection for further analysis - corrupt or duplicated values should be displayed to the user for review
- Valid data should be written to the database
- Sample files are provided, which may contain data errors
  - employees01.csv
  - employees02.json
  - employees03.xml
- Validation rules
  - emp_no should be only digits up to 8 characters
  - dates should be YYYY-MM-DD
  - dates should be in the past
  - birth_date should be after 1900-01-01
  - hire_date should be more recent than birth_date
  - names should only contain alpha chars, spaces and hyphens and should begin with a capital letter
  - gender should be X, F or M
- The original database structure doesn't allow for X as a value for gender, so the column definition should be altered accordingly in the table
