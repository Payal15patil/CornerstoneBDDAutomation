package com.cornerstone.page;

import com.cornerstone.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.sql.Driver;

public class ProductPage extends DriverManager {
    DriverManager driverManager = new DriverManager();

    @FindBy(id = "form-action-addToCart")
    WebElement addToCart;

    @FindBy(linkText = "Continue Shopping")
    WebElement continueShopping;

    @FindBy(xpath = "/html/body/header/nav/ul/li[5]/a/span[1]")
    WebElement cart;

    @FindBy(linkText = "Check out now")
    WebElement checkout;

    @FindBy(linkText = "View Cart")
    WebElement viewCart;

    public void clickOnAddToCartButton(){
        driverManager.scrollTo(addToCart);
        addToCart.click();
    }

    public void clickOnContinueShoppingButton(){
        continueShopping.click();
    }

    public void clickOnCart(){
        cart.click();
    }

    public void clickOnViewCart(){
        viewCart.click();
    }

}
