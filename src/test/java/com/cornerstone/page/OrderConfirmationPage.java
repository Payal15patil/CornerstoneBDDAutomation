package com.cornerstone.page;

import com.cornerstone.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;

public class OrderConfirmationPage extends DriverManager {

    @FindBy(linkText = "Thank you Payal!")
    WebElement confirmationHeading;

    public String  getConfirmationText(){
        return confirmationHeading.getText();

    }

}
