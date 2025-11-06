package com.ui.pages;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import static com.utility.PropertiesUtil.*;

import com.utility.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage extends BrowserUtility {

    private static final By SIGN_IN_TEXT =By.xpath("//a[contains(text(),\"Sign in\")]");

    public HomePage(Browser driver) {
        super(driver); // To call parent class constructor from child class
        //goToWebsite("http://www.automationpractice.pl/index.php?"); //New way of wrting from properties file
        goToWebsite(readProperty(QA,"URL"));
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



}
