Feature: User is able to find product in search field

  Scenario: User is able to find product in search field
    Given user is on home page and switches language
    When user fills search field "Ноутбуки"
    Then user can see displayed "Ноутбуки"

    Scenario: User is able to enter wrong input
      Given user is on home page and switches language
      When user fills search field "Wrong input"
      Then  user can see in search "По заданным параметрам не найдена ни одна модель"