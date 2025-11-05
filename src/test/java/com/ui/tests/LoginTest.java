package com.ui.tests;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {


        WebDriver wd = new ChromeDriver();//launch a browser window.
        //BrowserUtility browserUtility = new BrowserUtility(wd);
/*

        browserUtility.goToWebsite("http://www.automationpractice.pl/index.php?");
        browserUtility.maximizeWindow();

        By signInText =By.xpath("//a[contains(text(),\"Sign in\")]");
        browserUtility.clickOn(signInText);

        By email =By.id("email");
        browserUtility.enterText(email,"kisabam968@dropeso.com");

        By password =By.name("passwd");
        browserUtility.enterText(password,"Password");

        By signInAfterPassword = By.xpath("//i[@class=\"icon-lock left\"]");
        browserUtility.clickOn(signInAfterPassword);
*/




    }
}
