Feature: Display a requested film
  Scenario Outline: Confrim the correct films are loaded
    Given The webpage is loaded and is in use
    When The user opens "<page>" and is loaded
    And The API returns the list of films
    Then Display a list of films

    Examples:
      |page  |
      |Home  |
      |Actor |
      |Film  |