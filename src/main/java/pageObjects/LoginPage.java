package pageObjects;

import org.openqa.selenium.By;
import utils.GlobalVars;

public class LoginPage extends BasePage {

    // default access modifier private
    By userNameField  = By.id("text");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");

 public LoginPage()
   {
        super();
    }

    public void navigateToWebdriverUniversity_Login_Page()
    {
      navigateTo_URL(GlobalVars.WEBDRIVER_UNIVERSITY_HOME_PAGE_URL + "/Login-Portal/index.html?");
    }

    public void populateUserName (String username)
    {
        sendKeys(userNameField,  username);
    }

    public void populatePassword (String password)
    {
        sendKeys(passwordField,  password);
    }

    public void clickOnLogin()
    {
        waitForWebElementAndClick(loginButton);
    }

    public void validateSuccsessfulLoginMessage() {
        waitForAlertAndValidateMessageFromAlert("validation succeeded");
    }

    public void validateUnsuccsessfulLoginMessage() {
        waitForAlertAndValidateMessageFromAlert("validation failed");
    }

}
