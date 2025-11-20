package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BrowserUtility {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    Logger logger = LoggerUtility.getLogger(this.getClass());

    public WebDriver getDriver() {
        return driver.get();
    }

    public BrowserUtility(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        }
    }

    public BrowserUtility(Browser browserName) {
        if (browserName == Browser.CHROME) {
            driver.set(new ChromeDriver());
        }

        if (browserName == Browser.EDGE) {
            driver.set(new EdgeDriver());
        }

    }


    public BrowserUtility(Browser browserName, boolean isHeadless){
        if (browserName == Browser.CHROME){
            if(isHeadless) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless"); //headless
                chromeOptions.addArguments("--window-size=1920,1080");
                driver.set(new ChromeDriver(chromeOptions));
            }
            else
                driver.set(new ChromeDriver());
        }

        if (browserName == Browser.EDGE){
            if(isHeadless)
            {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=old"); //headless
                edgeOptions.addArguments("disbale-gpu");
                driver.set(new EdgeDriver(edgeOptions));
            }
            else
                driver.set(new EdgeDriver());
        }

    }




    public BrowserUtility(WebDriver driver) {
        this.driver.set(driver); //Initialise the instance variable driver.
    }

    public void goToWebsite(String url) {

        logger.info("Website URL" + " " + url);
        driver.get().get(url);
    }

    public void maximizeWindow() {
        driver.get().manage().window().maximize();

    }

    public void clickOn(By Locator) {
        WebElement element = driver.get().findElement(Locator);
        element.click();
    }

    public void enterText(By Locator, String text) {
        WebElement enterPassword = driver.get().findElement(Locator);
        enterPassword.sendKeys(text);
    }

    public String getVisibleText(By Locator) {
        WebElement text = driver.get().findElement(Locator);
        return text.getText();
    }

    public String takeScreenShot(String name) {
        TakesScreenshot screenshot = (TakesScreenshot) driver.get();
        File screenShotData = screenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = simpleDateFormat.format(date);
        String path = "./screenshots/" + name + " - " + timeStamp+ ".png";
        File screenShotFile = new File(path);
        try {
            FileUtils.copyFile(screenShotData, screenShotFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;

    }

}
