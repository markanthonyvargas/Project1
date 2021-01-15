# ERS REIMBURSEMENT SYSTEM

## Project Description

The ERS Reimbursement System is a project that simulates a real-world employee reimbursement system. Employees are able to log in and either submit a new reimbursement request or view their past reimbursement requests. Admins are able to log in and either view all reimbursement requests made by all employees, approve/deny pending reimbursement requests, or view reimbursement requests by approval status.

## Technologies Used

* Java JDK - Version 8
* Maven
* JDBC
* HTML/CSS/JavaScript/Bootstrap

## Features

List of features ready and TODOs for future development
* Employees can submit and view reimbursement requests
* Admins can view reimbursement requests and approve/deny pending requests

To-do list:
* Add ability for admins to submit reimbursement requests
* Fix CSS styling issue on admin and employee homepage
* Add JUnit Testing
* Add Logging

## Getting Started
1. Clone this repository. Use "git clone https://github.com/markanthonyvargas/Project1.git" in your terminal to clone this project to a destination on your personal machine.
2. Once this project is cloned you will need to import this project into your IDE. In STS you will import an existing Maven project.
3. Once imported, you will have to configure your IDE so that your project uses An Apache Tomcat V9 server. Make sure this server is using port 9002.

## Usage

Once the project is ready and the server is running, visit http://localhost:9002/Project1/ to access the website login page. You may use either the manager credentials to view the website from a manager perspective or user credentials to view the website from a user perspective.

NOTE: For security purpose this project uses system enviornment variables for JDBC. You will have to enter your own credentials for your database inside the ReimbDaoImpl.java file.

Manager Credentials:
username: defaultManager
password: p4ssw0rd

User credentials:
username: defaultEmployee
password: p4ssw0rd
