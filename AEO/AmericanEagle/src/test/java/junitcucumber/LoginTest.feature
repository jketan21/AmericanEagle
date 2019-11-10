Feature: Reset functionality on login page of Application


  Scenario Outline: Select the Item, Checkout and pay
  
   Given I launch the chrome browser
   When I Launch AE, select the item, checkout and execute the pay with card details "<cardnumber>" , "<expiry>" , "<cvv>"
   Then I verify user is not able to checkout
 
 Examples:
 
  | cardnumber        | expiry  | cvv |
  | 5423987342393452  | 09/2021 | 359 |