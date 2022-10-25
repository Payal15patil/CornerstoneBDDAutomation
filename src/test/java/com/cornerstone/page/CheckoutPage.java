package com.cornerstone.page;

import com.cornerstone.driver.DriverManager;
import cucumber.api.java.ca.I;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends DriverManager {

    @FindBy(id = "email")
    WebElement email;

    @FindBy(css = "label[for='privacyPolicy']")
    WebElement privacyPolicy;

    @FindBy(id = "checkout-customer-continue")
    WebElement customerContinueButton;

    @FindBy(id = "firstNameInput")
    WebElement firstName;

    @FindBy(id = "lastNameInput")
    WebElement lastName;

    @FindBy(id = "addressLine1Input")
    WebElement address;

    @FindBy(id = "cityInput")
    WebElement city;

    @FindBy(id = "postCodeInput")
    WebElement postCode;

    @FindBy(id = "phoneInput")
    WebElement phoneNumber;

    @FindBy(id = "checkout-shipping-continue")
    WebElement shippingContinueButton;

    @FindBy(id = "ccNumber")
    WebElement creditCardNumber;

    @FindBy(id = "ccExpiry")
    WebElement expiryDate;

    @FindBy(id = "ccName")
    WebElement creditCardName;

    @FindBy(id = "ccCvv")
    WebElement cvv;

    @FindBy(id = "checkout-payment-continue")
    WebElement placeOrderButton;

    public void enterCustomerDetails() {
        email.sendKeys("payal157patel@gmail.com");
        privacyPolicy.click();
        customerContinueButton.click();
    }

    public void enterShippingAddressDetails(){
        firstName.sendKeys("payal");
        lastName.sendKeys("patel");
        address.sendKeys("98 boleyn road");
        city.sendKeys("London");
        postCode.sendKeys("E79QG");
        phoneNumber.sendKeys("07685845678");
        shippingContinueButton.click();
    }

    public void enterPaymentDetails(){
        creditCardNumber.sendKeys("4111 1111 1111 1111");
        expiryDate.sendKeys("10/23");
        creditCardName.sendKeys("MRS PAYAL PATIL");
        cvv.sendKeys("123");
        placeOrderButton.click();
    }


}
