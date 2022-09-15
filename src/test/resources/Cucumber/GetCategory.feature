Feature: A category is retrieved on load
  Scenario: verify the category is retrieved
    Given there is a category ID
    And the api gets the category
    Then display a category