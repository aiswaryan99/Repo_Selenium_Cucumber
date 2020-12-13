
package Pages;

import DriverWrapper.Web;
import org.openqa.selenium.By;

import java.util.Set;

public class LandingPage extends BasePage {
    By loginEmail = By.id("email");
    By loginPassword = By.id("pass");
    By loginButton = By.tagName("button");
    By forgotPassword = By.linkText("Forgotten password?");
    By createNewAccount = By.linkText("Create New Account");
    By facebookPay = By.linkText("Facebook Pay");
    By oculus = By.linkText("Oculus");

    public void enterLoginEmail(String email) {
        type(loginEmail, email);
    }

    public void enterPasswordEmail(String password) {
        type(loginPassword, password);
    }

    public void clickLoginButton() {
        clickThis(loginButton);
    }

    public void clickForgotPassword() {
        clickThis(forgotPassword);
    }

    public void clickCreateNewAccount() {
        clickThis(createNewAccount);
    }

    public void clickFacebookPay(){
        scroll();
        clickThis(facebookPay);
    }

    public void clickOculus(){
        clickThis(oculus);
    }

    public void closeLPage(String givenHandle) {
        Set<String> allHandles = Web.getDriver().getWindowHandles();
        for (String handle : allHandles) {
            if (handle.equals(givenHandle))
                Web.getDriver().close();
        }
    }

    public void closePage(){
        Web.getDriver().close();


}








}