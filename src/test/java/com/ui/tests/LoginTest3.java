package com.ui.tests;

import static com.constants.Browser.*;

import com.ui.pages.HomePage;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest3 {
    HomePage homePage;

    @BeforeMethod(description = "Load the HomePage of the website")
    public void setup() {

        homePage = new HomePage(EDGE);
    }

    @Test(description = "Verifies if correct user able to login into the application", groups = {"e2e", "sanity"})
    public void loginTest() {
        assertEquals(homePage.goToLoginpage().dologinWith("kisabam968@dropeso.com", "Password").getUserName(), "Gaurav Kumain");
    }
}
