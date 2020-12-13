package StepDefinition.Facebook;

import DriverWrapper.Web;
import Pages.FacebookPay;
import Pages.LandingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class FacebookPaySD {
    LandingPage lpage = new LandingPage();
    FacebookPay fpay = new FacebookPay();

    @Given("^I am on facebook landing page$")
    public void verifyHomePage() {
        Assert.assertEquals(Web.getDriver().getTitle(), "Facebook - Log In or Sign Up", "Presently on different page!");
    }

    @When("^I click on 'Facebook Pay'$")
    public void clickOnFacebookPay() {
        lpage.clickFacebookPay();
    }

    @When("^I click on 'Oculus'$")
    public void clickOnOculus() {
        lpage.clickOculus();
    }

    @When("^I close Facebook Landing Page$")
    public void closeLandingPage() {
        String givenHandle = Web.getDriver().getWindowHandle();
        lpage.closeLPage(givenHandle);
        }

    @When("^I close Oculus page$")
    public void closeOculusPage(){
        if(Web.getDriver().getTitle().contains("Oculus")){
            lpage.closePage();
        }
    }

    @When("^I click on 'Ways to Pay'$")
    public void clickOnWaysToPay(){
        fpay.clickWaysToPay();
    }

    @When("^I verify heading 'Pay Directly from you favorite apps' appears$")
    public void verifyHeading(){
        fpay.textAppears();
    }


}