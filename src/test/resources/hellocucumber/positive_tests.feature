Feature: Positive scenarios
  Positive testing of registration form and authorization form

  Scenario: Testing TC_1
    Given URL-page for testing registration form
    When I am testing registration form
    Then The registration has completed successfully

  Scenario: Testing TC_2
    Given URL-page for testing authorization form
    When I am testing authorization form
    Then The log in has completed successfully