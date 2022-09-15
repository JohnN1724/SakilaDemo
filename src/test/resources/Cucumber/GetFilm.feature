Feature: A film is displayed on load
  Scenario: verify the film is displayed
    Given there is an ID
    And the api is connected
    Then display a single film