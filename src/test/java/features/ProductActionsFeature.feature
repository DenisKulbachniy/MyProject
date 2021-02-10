Feature: Product actions

  Scenario: User adds product in cart
    Given user is on home page
    When user navigates to laptop category
    And user adds product in cart
    And user navigates to product cart
    Then user can see product in cart

  Scenario: User adds kit product in cart
    Given user is on home page
    When user navigates to laptop category
    And user clicks on product
    And user adds product with kit in cart
    Then user can see his product with kit in cart

  Scenario: User can delete product from cart
    Given user is on home page
    When user navigates to laptop category
    And user adds product in cart
    And user navigates to product cart
    And user removes product from cart
    Then user can see that cart is empty

  Scenario Outline: User can add and delete product from wish list
    Given user is on home page
    When user enters '<login>' and '<password>' field
    When user navigates to laptop category
    And user adds product in wish list
    And user navigates on header wish list
    And user removes product from wish list
    Then user can see that wish list is empty
    Examples:
      | login                         | password      |
      | Petrovartem01061996@gmail.com | 01061996Artem |

  Scenario Outline:User can get in stock status
    Given user is on home page
    When user enters '<login>' and '<password>' field
    And user navigate to playstation category
    And user chooses out of stock product
    And user wants to notify himself about in stock of product
    And user navigates on header wish list
    Then user can see out of stock product
    When user removes product from wish list
    Then user can see that wish list is empty

    Examples:
      | login                         | password      |
      | Petrovartem01061996@gmail.com | 01061996Artem |

  Scenario: user can compare a few products
    Given user is on home page
    When user navigates to laptop category
    And user adds a few products in order to compare
    And user navigates to compare products
    Then user can see comparison products