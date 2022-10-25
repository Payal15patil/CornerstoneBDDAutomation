package com.cornerstone;

import com.cornerstone.driver.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    DriverManager driverManager = new DriverManager();
    @Before
    public void setUp() throws IllegalAccessException {
        driverManager.runOnLocalBrowser();
//        driverManager.runInHeadlessBrowser();
        driverManager.gotoUrl();
        driverManager.maxWindow();
        driverManager.applyImplicitWait();

    }
    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            driverManager.takeScreenshot(scenario);
        }
        driverManager.closeWindow();
    }
}
