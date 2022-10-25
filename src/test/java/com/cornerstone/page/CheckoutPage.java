package com.cornerstone.page;

import com.cornerstone.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends DriverManager {
    DriverManager driverManager = new DriverManager();
    String emailId = "payalpatel157@gmail.com";

    @FindBy(id = "email")
    WebElement email;

    @FindBy(name = "privacyPolicy")
    WebElement privacyPolicy;

    @FindBy(css = "#checkout-customer-continue")
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

    @FindBy(css = "#checkout-shipping-continue")
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
        int myRandomNumber = driverManager.generateRandomNumber();
        email.sendKeys(myRandomNumber + emailId);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", privacyPolicy);
//        privacyPolicy.click();
        waitUntilElementIsClickable(customerContinueButton);
        customerContinueButton.click();

    }

    public void enterShippingAddressDetails(){
        firstName.sendKeys("payal");
        lastName.sendKeys("patel");
        address.sendKeys("98 boleyn road");
        city.sendKeys("London");
        postCode.sendKeys("E79QG");
        phoneNumber.sendKeys("07685845678");
        waitUntilElementIsClickable(shippingContinueButton);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()",shippingContinueButton);
//        shippingContinueButton.click();

    }

    public void enterPaymentDetails(){
        waitUntilElementIsVisible(creditCardNumber,30,"continue button is not visible");
        creditCardNumber.sendKeys("4111 1111 1111 1111");
        expiryDate.sendKeys("10/23");
        creditCardName.sendKeys("MRS PAYAL PATIL");
        cvv.sendKeys("123");
        placeOrderButton.click();
    }


}
