package Pages;

import DriverWrapper.Web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HLandingPage extends BasePage {

    By searchButton = By.xpath("//button[@type='submit']");
    By autoSuggestLoc = By.id("qf-0q-destination");
    By numOfChild= By.name("q-room-0-children");
    By children1 = By.name("q-room-0-child-0-age");
    By children2 = By.name("q-room-0-child-1-age");


    public void clickSearch() {
        clickThis(searchButton);
    }

    public void selectFromDropdownSuggestions(String data) {
        List<WebElement> suggestions = Web.getDriver().findElements(autoSuggestLoc);
        for(WebElement s : suggestions){
            String sText = s.getText();
            if(data.equalsIgnoreCase(sText)){
                s.click();
                break;
            }
        }

    }
    public void enterText(String loc){
        type(autoSuggestLoc,"york");
    }

    public void numChildren(String data){
        clickThis(numOfChild);
        WebElement number = Web.getDriver().findElement(numOfChild);
        Select n = new Select(number);
        n.selectByVisibleText(data);
    }

    public void ageOfChild1(String data){
        clickThis(children1);
        WebElement child1 = Web.getDriver().findElement(children1);
        Select child = new Select(child1);
        child.selectByVisibleText(data);
    }

    public void ageOfChild2(String data){
        clickThis(children2);
        WebElement child2 = Web.getDriver().findElement(children2);
        Select child = new Select(child2);
        child.selectByVisibleText(data);
    }

}
