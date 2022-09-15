Feature: Display an actor on load
  Scenario: verify an actor loads
    Given there is an Actor ID
    And the api connects to actor
    Then display an actor