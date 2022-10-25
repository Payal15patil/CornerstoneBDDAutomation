@EndToEnd
Feature: Product Checkout Feature
  As a customer
  I want to add product to a cart
  So I can buy that product and get confirmation for that order

  Scenario: Validate purchase confirmation for customer order
    Given I have a product in my cart
    When I complete the checkout process
    Then I am presented with a purchase confirmation page for my order