# mobiquityTestApp
A small Behavior Driven framework that utilizes Selenium WebDriver with Java and Cucumber to automate some basic flows.

# Technology Stack:
- Java
- Cucumber BDD
- Selenium WebDriver
- Maven

## Additional Features:
- Pretty Reporting with ExtentReports.
- Support for Multiple Browsers (FireFox, Chrome, Headless)
- Independent Scenarios
- Dynamic Input Data Generation

# Scenarios Covered:

- Login and Logout:
    - Log in to the application with valid Credentials and validate login, then log out and validate logout
    - Failure validation for incorrect credentials 

For each of the scenarios below, Log In is executed first.

- Create Employee:
    - Create Employee with Valid Data and validate addition
    - Failure validation for Invalid Email
    - Failure validation for Invalid Start Date
- Edit Employee: 
  (What feields to edit can be configure in the Feature file and code will handle the rest)
    - Update Employee with Edit button and validate updates
    - Update Employee with Double-click and validate updates
- Delete Employee:
    - Delete an employee from the Employee list and Validate removal
    - Delete an employee from the Employee Details screen and Validate removal

# Instructions:

- Driver files for both Chrome and Firefox can be found inside /test/resources/ folder. 
- URL for the application is configured inside "BaseTest.java"
- ExtentReport for the test suite generates at target/testReport.html

# Browser Support:

Test Suite runs confugurably on Firefox, Chrome and Chrome Headless. This setting can be configured inside BaseTest.initializeWebDriver(). Available options: "headless", "chrome", "firefox"

This project has been tested on:
- Chrome version Version 65.0 (chromeDriver version 2.36)
- FireFox version 56.0 (geckoDriver version 16.1)
- Selenium version 3.4.0

# How to Run:
- To Run Individual Feature (For e.g. running only Create Employee Scenarios):
        - In TestRunner.java file, provide feature filename in features tag. For example:
        '''
        
        features="src/test/resources/CreateEmployee.feature", ...
        
        '''
- To Run Individual Scenario within a Feature (For e.g. running only Create Valid Employee scenario)
        - In TestRunner.java file. provide:
        '''
        
        @CucumberOptions(features="src/test/resources/CreateEmployee.feature", tags = "@CreateEmployeeValid", ...
        
        '''
- To Run the whole Suite
        - In TestRunner.java file, just provide the path till the resources folder:
        '''
        
        features="src/test/resources/", ...
        
        '''
        
 Similarly, Suite, Feature(s) and Scenario(s) can be run from maven by providing the plugins with -DCucumberOptions argumentlist.
