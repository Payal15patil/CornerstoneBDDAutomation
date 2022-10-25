package com.cornerstone.page;

import com.cornerstone.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends DriverManager {
    DriverManager driverManager = new DriverManager();

    @FindBy(linkText = "Check out")
    WebElement checkout;

        public void clickOnCheckout(){
            driverManager.scrollTo(checkout);
            checkout.click();
    }
}
