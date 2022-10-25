package com.cornerstone.driver;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static WebDriver driver;
    String browser = "chrome";
    String url = "https://cornerstone-light-demo.mybigcommerce.com";

    public DriverManager(){
        PageFactory.initElements(driver,this);
    }

    public void runOnLocalBrowser() throws IllegalAccessException {
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver= new EdgeDriver();
                break;
            case "safari":
                driver= new SafariDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            default:
                throw new IllegalAccessException("Unexpected browser");
        }
    }

    public void runInHeadlessBrowser() throws IllegalAccessException {
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);
                options.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions=new FirefoxOptions();
                firefoxOptions.setHeadless(true);
                firefoxOptions.addArguments("--window-size=1920,1080");
                driver=new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability("headless", true);
                driver= new EdgeDriver(edgeOptions);
                break;
            default:
                throw new IllegalAccessException("Unexpected browser");
        }
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }
    public void gotoUrl(){
        driver.get(url);
    }
    public void applyImplicitWait(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public WebElement waitUntilElementIsClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,30);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitUntilElementIsVisible(WebElement element,int timeOut,String failureMessage){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.withMessage(failureMessage);
    }
    public int generateRandomNumber(){
        Random random = new Random();
        // Obtain a number between [0 - 200].
        return random.nextInt(200);
    }

    public static String getRandomString(int length) {
        final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();

        while (length > 0) {
            Random random1 = new Random();
            result.append(characters.charAt(random1.nextInt(characters.length())));
            length--;
        }
        return result.toString();
    }

    public void takeScreenshot(Scenario scenario){

        byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenShot, "image/png");
        //take a screen shot
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("/Users/patil/OneDrive/Desktop/screenShotTest/error.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void takeElementScreenshot(WebElement element, String fileName)  {
        File scnFile =element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scnFile, new File("./target/screenshots/" +fileName+ ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void maxWindow(){
        driver.manage().window().maximize();
    }
    public void sleepWindow(int ms) throws InterruptedException {
        Thread.sleep(ms);
    }

    public void closeWindow(){
        driver.quit();
    }
}
