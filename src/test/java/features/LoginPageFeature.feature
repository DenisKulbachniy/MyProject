Feature: Login to account

  Scenario Outline: user logs in to account
    Given user is on home page
    When user enters '<login>' and '<password>' field
    Then user can see his name in account
    Examples:
      | login                         | password      |
      | petrovartem01061996@gmail.com | 01061996Artem |


