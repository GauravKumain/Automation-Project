package com.ui.tests;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;
import org.testng.annotations.Test;

public class LoginTest3 {

    @Test(description ="Verifies if correct user able to login into the application", groups={"e2e","sanity"})
    public void loginTest() {


        //WebDriver wd = new ChromeDriver();//launch a browser window.
        HomePage homePage = new HomePage(EDGE);
        String userName =homePage.goToLoginpage().dologinWith("kisabam968@dropeso.com","Password").getUserName();
        System.out.println(userName);




    }
}
