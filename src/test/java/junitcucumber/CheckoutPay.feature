Feature: Reset functionality on login page of Application


  Scenario Outline: Select the Item, Checkout and pay
  
   Given I launch the chrome browser
   When I Launch AE, select the item, checkout and execute the pay with card details "<cardnumber>" , "<expiry>" , "<cvv>"
   Then I verify user is not able to checkout
 
 Examples:
 
  | cardnumber        | expiry  | cvv |
  | 4234234234253289  | 10/2021 | 223 |
  | 4239873423934523  | 11/2020 | 359 |
  | 379785904102007  | 09/2021 | 111 |