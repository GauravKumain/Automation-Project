package com.ui.tests;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;
import static org.testng.Assert.*;
import com.ui.pojo.UserLogin;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest3 extends TestBase {



    Logger logger = LoggerUtility.getLogger(this.getClass());
    //@Test(description = "Verifies if correct user able to login into the application", groups = {"e2e", "sanity"} , dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")

    /*public void loginTest() {
        assertEquals(homePage.goToLoginpage().dologinWith("kisabam968@dropeso.com", "Password").getUserName(), "Gaurav Kumain");
    }*/

    @Test(description = "Verifies if correct user able to login into the application", groups = {"e2e", "sanity"} , dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
    public void loginTest(UserLogin user) {
        assertEquals(homePage.goToLoginpage().dologinWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Gaurav Kumain");
    }

    @Test(description = "Verifies if correct user able to login into the application", groups = {"e2e", "sanity"} , dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
    public void loginExcelTest(UserLogin user) {
        assertEquals(homePage.goToLoginpage().dologinWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Gaurav Kumain");
    }

    @Test(description = "Verifies if correct user able to login into the application", groups = {"e2e", "sanity"} , dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
    public void loginCSVTest(UserLogin user) {

        assertEquals(homePage.goToLoginpage().dologinWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Gaurav Kumain");
    }
}
