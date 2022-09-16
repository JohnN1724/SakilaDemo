Feature: A category is returned
  Scenario: Confrim the correct category is returned
    Given A category has been requested
    And The API returns the requested category
    Then The requested category is displayed