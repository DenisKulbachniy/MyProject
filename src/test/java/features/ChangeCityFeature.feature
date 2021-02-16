Feature: User is able to change city

  Scenario: User is able to change city
    Given user is on home page and switches language
    When user wants to change city on "Киев"
    Then user can see chosen city "Киев"

