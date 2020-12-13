package Pages;

import DriverWrapper.Web;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class BasePage {

    public WebElement findElementUsingFluentWait(By locator) {
        Wait fWait = new FluentWait(Web.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoAlertPresentException.class)
                .ignoring(NoSuchElementException.class)
                .withMessage("Element is not found after 30 seconds of wait");

        WebElement element = (WebElement) fWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        return element;
    }


    public void type(By locator, String data) {
        findElementUsingFluentWait(locator).clear();
        findElementUsingFluentWait(locator).sendKeys(data);
    }

    public void clickThis(By locator) {
        findElementUsingFluentWait(locator).click();
    }

    public void isElementDisplayed(By locator) {
        findElementUsingFluentWait(locator).isDisplayed();
    }

    public String text(By locator){
        return findElementUsingFluentWait(locator).getText();
    }

    public void scroll(){
        JavascriptExecutor js = (JavascriptExecutor)Web.getDriver();
        js.executeScript("scrollBy(0,700);");
    }



}