Feature: User is able to find product in search field

  Scenario Outline: User is able to find product in search field
    Given user is on home page
    When user fills search field '<Laptops>'
    Then user can see that input word is displayed
    Examples:
      | Laptops  |
      | Ноутбуки |