package StepDefinition.Hotels;

import DriverWrapper.Web;
import Pages.BasePage;
import Pages.HLandingPage;
import Pages.HotelVerify;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class HotelSearchSD extends BasePage {
    HLandingPage lpage = new HLandingPage();
    HotelVerify hpage = new HotelVerify();
    HLandingPage hlpage = new HLandingPage();

    String select = "Lake George, New York, United States of America";

    @Given("^I am on hotels landing page$")
    public void verifyHotelHomePage() {
        Assert.assertEquals(Web.getDriver().getTitle(), "Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations", "Wrong Page!");
    }

    @When("^I enter (.+) in search$")
    public void enterLoc(String loc) {
        lpage.enterText(loc);
    }

    @When("^I select (.+) from autosuggestion$")
    public void selectLoc(String select) {
        lpage.selectFromDropdownSuggestions(select);
    }

    @When("^I click on Search button$")
        public void ClickSearchButton(){
            lpage.clickSearch();
        }

    @When("^I verify search header contains text selected from auto suggestion$")
        public void verifyContainsText(){
        String heading = Web.getDriver().getTitle();
        Assert.assertTrue(heading.contains(select));
    }

    @When("^I verify text under 'Destination, property, or landmark' is same as text selected from auto suggestion$")
        public void verifySelectedTextDisplayed(){
        String actual = hpage.obtainText();
        Assert.assertEquals(actual,select,"They are not the same text");
    }

    @When("^I select (.+) in children dropdown$")
        public void selectNumOfChild(String num){
        hlpage.numChildren(num);
    }

    @When("^I enter Child 1 age as (.+)$")
        public void selectAgeOfChild1(String age) {
        hlpage.ageOfChild1(age);
    }
    @When("^I enter Child 2 age as (.+)$")
        public void selectAgeOfChild2(String age){
        hlpage.ageOfChild2(age);
    }

    @When("^I sort the result by \"([^\"]*)\"$")
        public void selectPriceRanging(){
        hpage.selectRange();
    }

    @When("^I print the lowest price and hotel name in the console$")
        public void printHotelNameAndPrice(){
        hpage.printLowInfo();
    }

    @When("^I verify the lowest price is less than \\$(\\d+)$")
        public void verifyLowestPrice100(){
        Assert.assertTrue(hpage.verifyLowPrice(),"The price is greater than $100");
    }

}