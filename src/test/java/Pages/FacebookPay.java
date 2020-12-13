package Pages;

import org.openqa.selenium.By;

public class FacebookPay extends BasePage{

    By waysToPay = By.linkText("Ways to Pay");
    By heading = By.xpath("//h1[starts-with(text(),'Pay')]");

    public void clickWaysToPay(){
        clickThis(waysToPay);
    }

    public void textAppears(){
        isElementDisplayed(heading);
    }

}
