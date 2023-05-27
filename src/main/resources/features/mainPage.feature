Feature: Main Page Actions
  As a user, I want to be able to use main page's features.

  Scenario Outline: Send a message and observe it on Activity Stream
    Given User is in the main page
    Then User clicks the MESSAGE button
    Then User texts a message "<message>" to the message box
    And User clicks SEND button