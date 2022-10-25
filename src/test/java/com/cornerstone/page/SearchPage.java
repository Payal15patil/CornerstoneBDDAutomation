package com.cornerstone.page;

import com.cornerstone.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class SearchPage extends DriverManager {
    DriverManager driverManager = new DriverManager();

    @FindBy(xpath = "//*[@id=\"product-listing-container\"]/div/ul/li/article/div/h3/a")
    WebElement product;



    public void clickOnProduct(){
        driverManager.scrollTo(product);
        product.click();
    }

}
