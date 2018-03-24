Feature: Update an existing employee and validating that changes have been saved

"""
Summary of Scenarios:
----- All scenarios are independent                   -----
----- Data provided in both scenarios is configurable -----

Scenario 1: Update employee by navigating to Details screen using Edit button.
            make changes to the employee details and validate that updates
            were made
Scenario 2: Update employee by navigating to Details screen using double click.
            make changes to the employee details and validate that updates
            were made
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

  @EditEmployeeUsingEditButton
  Scenario: Update an existing employee with valid data using Edit Button
    When User selects an employee record
    And Presses Edit button on Employee List
    And Enters details in the form
      | First Name | Last Name | Email |
      | FIRSTNAME  | LASTNAME  | EMAIL |
    And Presses Update Button
    Then Validate that employee has been added or updated in the employee list

  @EditEmployeeUsingDoubleClick
  Scenario: Update and existing employee with valid data using Double-click to open Employee details
    When User opens an employee record with double click
    And Enters details in the form
      | Last Name | Start Date |
      | LASTNAME  | STARTDATE  |
    And Presses Update Button
    Then Validate that employee has been added or updated in the employee list
