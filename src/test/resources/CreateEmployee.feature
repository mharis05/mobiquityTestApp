Feature: Creating an Employee and Validating that Employee records have been updated

"""
Summary of Scenarios:
All scenarios are independent hence each time User logs back in and a new Employee is created
Scenario 1: Create a new employee with
            valid data, (all data is generated dynamically),
            then validate that the eployee has been added to the list

Scenario 2: Try to create an employee with an invalid email address,
            Validate that employee is not created

Scenario 3: Try to create an employee with an invalid Start Date.
            Validate that employee is not created
"""

  Background:
    Given Employee management app is open in browser
    And User enters credentials
      | Username | Password  |
      | Luke     | Skywalker |
    And Presses login button
    And Validate that User has successfully logged in

  @CreateEmployeeValid
  Scenario: Create an Employee with Valid Data
    When User clicks on Create Button
    And Enters details in the form
      | First Name | Last Name | Start Date | Email |
      | FIRSTNAME  | LASTNAME  | STARTDATE  | EMAIL |
    And Presses Add Button
    Then Validate that employee has been added or updated in the employee list

  @CreateEmployeeInvalidEmail
  Scenario: Create and Employee with Invalid Email Address
    When User clicks on Create Button
    And Enters details in the form
      | First Name | Last Name | Start Date | Invalid Email |
      | FIRSTNAME  | LASTNAME  | STARTDATE  | EMAIL |
    And Presses Add Button
    Then Validate that employee is not saved

  @CreateEmployeeInvalidStartDate
  Scenario: Create and Employe with Invalid Start Date
    When User clicks on Create Button
    And Enters details in the form
      | First Name | Last Name | Invalid Start Date | Email |
      | FIRSTNAME  | LASTNAME  | STARTDATE          | EMAIL |
    And Presses Add Button
    Then Validate that Invalid Date Error message is shown
