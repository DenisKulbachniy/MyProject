Feature: Product actions

  Scenario: User adds product in cart
    Given user is on home page and switches language
    When user navigates to laptop category
    When user adds "Ноутбук Acer Aspire 5 A515-55G" in cart
    When user navigates to product cart
    Then user can see "Ноутбук Acer Aspire 5 A515-55G (NX.HZFEU.009) Pure Silver Суперцена!!!" in cart

  Scenario: User adds kit product in cart
    Given user is on home page and switches language
    When user navigates to laptop category
    When user clicks on product name "Ноутбук Acer Aspire 5 A515-55G"
    When user adds product with kit in cart
    Then user can see added product with "Вместе дешевле" in cart

  Scenario: User can delete product from cart
    Given user is on home page and switches language
    When user navigates to laptop category
    When user adds "Ноутбук Acer Aspire 5 A515-55G" in cart
    When user navigates to product cart
    When user removes product from cart
    Then user can see that "Корзина пуста"

  Scenario: user can compare a few products
    Given user is on home page and switches language
    When user navigates to laptop category
    When user adds product "Ноутбук Acer Aspire 5 A515-55G" in order to compare
    When user navigates to laptop category
    When user adds product "Ноутбук HP Pavilion Gaming 15-ec1007ua" in order to compare
    When user navigates to compare products
    Then user can see "Сравниваем ноутбуки"

  Scenario: user removes product kit from cart
    Given user is on home page and switches language
    When user navigates to laptop category
    When user clicks on product name "Ноутбук Acer Aspire 5 A515-55G"
    When user adds product with kit in cart
    Then user can see added product with "Вместе дешевле" in cart
    When user removes product from cart
    Then user can see that "Корзина пуста"

  Scenario: user is able to change color of product
    Given user is on home page and switches language
    When user navigates to laptop category
    When user clicks on product name "Ноутбук Acer Aspire 5 A515-55G"
    When user switches color of product
    Then user can see that product color is "Черный"

  Scenario: user can filter laptops by brand
    Given user is on home page and switches language
    When user navigates to laptop category
    When user chooses laptops by brand "Acer"
    Then user can see filtered laptops by brand "Acer"