package com.cornerstone.page;

import com.cornerstone.driver.DriverManager;
import cucumber.api.java.ca.I;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class HomePage extends DriverManager {

//    @FindBy(linkText = "Accept All Cookies")
//    WebElement cookies;

    @FindBy(id = "quick-search-expand")
    WebElement search;

    @FindBy(id = "nav-quick-search")
    WebElement searchBox;

    public void clickOnSearchFromHeader(){
        search.click();
    }

    public void enterItemInSearchBox(){
        searchBox.sendKeys("cheese grater");
        searchBox.submit();
    }

//    public void clickOnAcceptAllCookies(){
//        cookies.click();
//    }

}
