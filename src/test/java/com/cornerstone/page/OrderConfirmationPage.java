package com.cornerstone.page;

import com.cornerstone.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;

public class OrderConfirmationPage extends DriverManager {

    @FindBy(xpath = "//*[@id=\"checkout-app\"]/div/div[1]/div/h1")
    WebElement confirmationHeading;

    public String  getConfirmationText(){
        return confirmationHeading.getText();

    }

}
