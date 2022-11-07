@wahoo
Feature: Wahoo Fitness
  I want to use this template for my feature file

  Scenario Outline: Validate Checkout
    Given I am on the wahoo homepage.
    And I close all the popups.
    And I click on all products
    And I randomly select a product and I check if it has size and/or color and I add to cart until I have two items.
    And I click on the cart to remove one item from cart
    And I click the okay popup
    And I click on view or edit
    And I change the <quantity> and I update the cart
    And I check if the price has changed and I click on checkout
    And I input <email>, <fName>, <lName>, <address>, <city>,  <zip>, <phone>
    And I click on the address validation popup
    And I select the credit card and input <cardNum>, <cardDate>, <cvc>
    When I click the checkout button
    Then I verify the <message>

    Examples: 
      | quantity |email| fName   | lName   | address               | city      | zip     | phone        | cardNum            | cardDate | cvc    | message                                                                              |
      | "3"      |"davidsmith@yahoo.com"| "David" | "Smith" | "3150 Rochambeau Ave" | "Bronx" |    "10467" | "7186539773" | "5565444503350346" | "1228"   | "6206" | "Your card was declined. Your request was in live mode, but used a known test card." |
