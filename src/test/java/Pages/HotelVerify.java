package Pages;

import DriverWrapper.Web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HotelVerify extends BasePage{

    By inputBox = By.name("q-destination");
    By elementHov = By.xpath("//a[@data-menu='sort-submenu-price']");
    By lowToHigh = By.xpath("//a[@data-option-id='opt_PRICE']");
    By firstHotel = By.xpath("//a[@class='property-name-link'][1]");
    By hotelPrice= By.xpath("//div[@class='strike-tooltip-block']//following-sibling::ins[1]");

    public String  obtainText(){
       return text(inputBox);
    }

    public void selectRange(){
        WebElement priceRange = Web.getDriver().findElement(elementHov);
        Actions act = new Actions(Web.getDriver());
        act.moveToElement(priceRange).build().perform();
        clickThis(lowToHigh);
    }

    public void printLowInfo(){
        System.out.println("The name of the hotel with the lowest price is : ");
        System.out.println(text(firstHotel));
        System.out.println("The Price for the hotel is : ");
        System.out.println(text(hotelPrice));

    }

    public boolean verifyLowPrice() {
        WebElement hotelp = Web.getDriver().findElement(hotelPrice);
        String hp = text(hotelPrice);
        String[] split = hp.split("\\$");
        int lowPrice = Integer.parseInt(split[0]);
        return lowPrice < 100;
    }

}
