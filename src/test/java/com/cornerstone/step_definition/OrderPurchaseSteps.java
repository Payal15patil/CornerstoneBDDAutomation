package com.cornerstone.step_definition;

import com.cornerstone.driver.DriverManager;
import com.cornerstone.page.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class OrderPurchaseSteps extends DriverManager {
    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();

    @Given("^I have a product in my cart$")
    public void i_have_a_product_in_my_cart() throws Throwable {
//      homePage.clickOnAcceptAllCookies();
        homePage.clickOnSearchFromHeader();
        homePage.enterItemInSearchBox();
        searchPage.clickOnProduct();
        productPage.clickOnAddToCartButton();
        productPage.clickOnContinueShoppingButton();
        productPage.clickOnCart();
        productPage.clickOnViewCart();
        cartPage.clickOnCheckout();
    }

    @When("^I complete the checkout process$")
    public void i_complete_the_checkout_process() throws Throwable {
        checkoutPage.enterCustomerDetails();
        checkoutPage.enterShippingAddressDetails();
        checkoutPage.enterPaymentDetails();
    }

    @Then("^I am presented with a purchase confirmation page for my order$")
    public void i_am_presented_with_a_purchase_confirmation_page_for_my_order() throws Throwable {
        String myConfirmationText = orderConfirmationPage.getConfirmationText();
        System.out.println(myConfirmationText);

    }


}
