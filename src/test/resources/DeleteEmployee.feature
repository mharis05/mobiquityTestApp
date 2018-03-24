Feature: Delete an existing Employee and validate that employee has been removed from the employee list
"""
Summary of Scenarios:
All scenarios are independent hence each time User logs back in and a new Employee is created
Scenario 1: Delete Employee by clicking Delete button on Employee List
Scenario 2: Delete Employee by clicking Delete button inside Employee Detail
"""
  Background:
    Given Employee management app is open in browser
    And User enters credentials
      | Username | Password  |
      | Luke     | Skywalker |
    And Presses login button
    And Validate that User has successfully logged in
    And User clicks on Create Button
    And Enters details in the form
      | First Name | Last Name | Start Date | Email |
      | FIRSTNAME  | LASTNAME  | STARTDATE  | EMAIL |
    And Presses Add Button
    And Validate that employee has been added or updated in the employee list

  @DeleteFromList
  Scenario: Delete an Existing Employee from Employee List
    When User selects an employee record
    And Presses Delete button on Employee List
    And Responds to Alert with "Ok"
    Then Validate that employee does not exist in Employee List

  @DeleteFromDetails
  Scenario: Delete an Existing Employee from Employee Details
    When User selects an employee record
    And Presses Edit button on Employee List
    And Presses Delete button on Employee Details screen
    And Responds to Alert with "Ok"
    Then Validate that employee does not exist in Employee List
