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

  @mainPageTest @wip
  Scenario Outline: Event Setting
  Send a message and observe it on Activity Stream
    Given User is in the main page
    When User clicks the EVENT button
    And User texts a event name "<eventName>" to the message box
    And User texts a event details "<eventDetails>" to the message box
    And User select start date and time
    And User clicks SEND button
    Then Event should be displayed correctly and should be same with event name "<eventName>" and event details "<eventDetails>"

    Examples:
      | eventName | eventDetails      |
      | Test15.59 | Test15.59 - event Details|

