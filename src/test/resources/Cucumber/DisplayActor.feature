Feature: Display an actor
  Scenario: verify the correct actor is returned
    Given when an Actor ID is requested
    And the API requests the actor
    Then the actor is displayed