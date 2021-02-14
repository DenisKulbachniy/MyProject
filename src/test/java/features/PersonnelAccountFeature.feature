Feature: User does some actions in personnel account

  Scenario Outline: User can create own wish list
    Given user is on home page
    When user enters '<login>' and '<password>' field
    And user navigates to account and creates new own wish list '<Laptops>'
    Then user can see own list of wishes
    And user navigates to laptop category
    And user adds product in wish list
    And user navigates on header wish list
    Then user can see product in wish list
    When user removes own wish list
    Then user can see that wish list is empty
    Examples:
    Examples:
      | login                         | password      |  | Laptops  |
      | Petrovartem01061996@gmail.com | 01061996Artem |  | Ноутбуки |

