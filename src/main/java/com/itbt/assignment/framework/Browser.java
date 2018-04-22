package com.itbt.assignment.framework;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Collections;

import static com.itbt.assignment.framework.Config.*;

public class Browser {
    private static WebDriver driver;
    private static void start() {

        try {
            switch (getBrowser().toLowerCase()) {
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", getFirefoxDriver());
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--test-type");
                    chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                    System.setProperty("webdriver.chrome.driver", getChromeDriver());
                    driver = new ChromeDriver(chromeOptions);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void maximize() {
        getDriver().manage().window().maximize();
    }

    public static boolean isStarted() {
        return driver != null;
    }

    public static void quit() {
        if (isStarted()) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        if (!isStarted()) {
            start();
            maximize();
        }
        return driver;
    }

    public static byte[] getScreenShot() {
        try {
            return ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            return null;
        }
    }
}
