package DriverWrapper;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {

    private static WebDriver driver;
    public static String url = "https://www.facebook.com";
    public static String url2= "https://www.hotels.com";

    @Before
    public void openDriver(){
        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url2);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
