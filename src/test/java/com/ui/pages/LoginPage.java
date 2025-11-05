package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Browser;

public final class LoginPage extends BrowserUtility {

    private static final By email =By.id("email");
    private static final By password =By.name("passwd");
    private static final By signInAfterPassword = By.xpath("//i[@class=\"icon-lock left\"]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage dologinWith(String emailAddress, String pass)
    {
        enterText(email,emailAddress);
        enterText(password,pass);
        clickOn(signInAfterPassword);
        /*MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        return myAccountPage;*/
         return new MyAccountPage(getDriver());// we can also write like this for above statement.
    }
}
