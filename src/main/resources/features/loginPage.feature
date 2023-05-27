Feature: Login Page
  As a user, I want to be able to perform login.

  @loginPageTest
  Scenario Outline: Successful login with valid username and password
    Given the user is on the login page
    When the user enters a valid "<username>" and "<password>"
    And clicks the login button
    Then the user is successfully redirected to the home page

    Examples:
      | username                     | password |
      | helpdesk1@cybertekschool.com | UserUser |
      | hr1@cybertekschool.com       | UserUser |

  @loginPageTest
  Scenario Outline: Failed login with invalid username or password
    Given the user is on the login page
    When the user enters an invalid "<username>" or "<password>"
    And clicks the login button
    Then the user sees the error message "Incorrect login or password"

    Examples:
      | username                     | password        |
      | helpdesk1@cybertekschool.com | invalidPassword |
      | invalidUsername              | UserUser        |
