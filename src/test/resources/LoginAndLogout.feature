Feature: Login and Logout mechanism for Employee Management Application

"""
Summary of Scenarios:
----- All scenarios are independent -----
Scenario 1: Log in to the application and validate successful login
Scenario 2: Validate that Incorrect credentials result in failure to login

"""

  Background:
    Given Employee management app is open in browser

  @LoginTest
  Scenario: Validate that User is able to log in and log out of the application with valid credentials

    When User enters credentials
      | Username | Password    |
      | Luke     | Skywalker   |
    And Presses login button
    Then Validate that User has successfully logged in
    And User is able to log out

  @FailedLoginTest
  Scenario: Validate that User is Unable to log in to the application with Invalid credentials

    When User enters credentials
      | Username | Password    |
      | Luke     | thedarkside |
    And Presses login button
    Then Validate that Error message is shown
