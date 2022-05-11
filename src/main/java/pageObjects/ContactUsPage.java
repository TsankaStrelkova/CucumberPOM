package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.GlobalVars;

public class ContactUsPage extends BasePage {

    // default access modifier private
    By firstNameField = By.cssSelector("input[name='first_name'");
    By lastNameField = By.cssSelector("input[name='last_name']");
    By emailField = By.cssSelector("input[name='email']");
    By commentField = By.cssSelector("textarea[name='message']");
    By submitButton = By.cssSelector("input[type='submit']");
    By contactSubmitMessage = By.cssSelector("[id='contact_reply'] h1");


    public ContactUsPage() {

        super();
    }

    public void navigateToWebdriverUniversity_ContactUs_Page() {
        navigateTo_URL(GlobalVars.WEBDRIVER_UNIVERSITY_HOME_PAGE_URL + "/Contact-Us/contactus.html");
    }

    public void enterUniqueFirstName() {
        sendKeys(firstNameField, "AutoGenFN"+generateRandomString(5));
    }

    public void enterUniqueLastName() {
        sendKeys(lastNameField, "AutoGenLN"+generateRandomString(6));
    }

    public void enterUniqueEmail() {
        sendKeys(emailField, "auto_gen_"+generateRandomNumber(4)+"@mail.com");
    }

    public void enterUniqueComment() {
        sendKeys(commentField, generateRandomString(55));
    }

    public void populateFirstName(String firstName) {
        sendKeys(firstNameField, firstName);
    }

    public void populateLastName(String lastName) {
        sendKeys(lastNameField, lastName);
    }

    public void populateEmail(String email) {
        sendKeys(emailField, email);
    }

    public void populateComment(String comment) {
        sendKeys(commentField, comment);
    }

    public void clickOnSubmit() {
        waitForWebElementAndClick(submitButton);
    }

    public void validateSuccsessfulLoginMessage() {
        waitForAlertAndValidateMessageFromAlert("validation succeeded");
    }

    public void validateUnsuccsessfulLoginMessage() {
        waitForAlertAndValidateMessageFromAlert("validation failed");
    }

    public void successfullSubmitContactMessage()
    {
        waitFor(contactSubmitMessage);
        String actualMessage = getDriver().findElement(contactSubmitMessage).getText();
        Assert.assertEquals(actualMessage,"Thank You for your Message!");
    }
}
