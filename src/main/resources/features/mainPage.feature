Feature: Main Page Actions
  As a user, I want to be able to use main page's features.

  @mainPageTest
  Scenario Outline: Activity Stream
      Send a message and observe it on Activity Stream
    Given User is in the main page
    When User clicks the MESSAGE button
    And User texts a message "<message>" to the message box
    And User clicks SEND button
    Then Text should be displayed correctly and should be same with message "<message>"

    Examples:
      | message     |
      | hello340012 |


