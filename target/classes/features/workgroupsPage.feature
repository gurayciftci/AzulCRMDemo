Feature: Workgroup Join Feature
  As a user, I want to be able to join workgroups or projects

  @workgroupsPageTest @wip
  Scenario: Join a project or a group
    Given User is in Workgroups and projects page
    When User clicks to a group
    Then Request has been sent text should be displayed

