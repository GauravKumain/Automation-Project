package com.ui.pages;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import static com.utility.PropertiesUtil.*;

import com.utility.JSONUtility;
import com.utility.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public final class HomePage extends BrowserUtility {

    private static final By SIGN_IN_TEXT =By.xpath("//a[contains(text(),\"Sign in\")]");

    public HomePage(Browser driver,boolean isHeadless) {
        super(driver,isHeadless); // To call parent class constructor from child class
        goToWebsite(JSONUtility.readJSON(QA));
    }

    public HomePage(WebDriver driver) {
        super(driver);
        goToWebsite(JSONUtility.readJSON(QA));
    }

   /* public void goToLoginpage() //Page Functions----> we cant use void return type so we rewrite it below
    {
        clickOn(SIGN_IN_TEXT);

    }*/

    public LoginPage goToLoginpage() //Page Functions----> we cant use void return type so we rewrite
    {
        clickOn(SIGN_IN_TEXT);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }

    public void quit() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }



}
