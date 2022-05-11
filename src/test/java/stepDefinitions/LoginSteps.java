package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.LoginPage;


public class LoginSteps extends BasePage {


    //to inject PageObject into Step definitions
    // we need to add some dependencies into POM.xml
    // <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-picocontainer -->
    //        <dependency>
    //            <groupId>io.cucumber</groupId>
    //            <artifactId>cucumber-picocontainer</artifactId>
    //            <version>7.0.0</version>
    //            <scope>test</scope>
    //        </dependency>

    // private variable of type page needed for the constructor
    private LoginPage loginPage;

    // constructor to embed PageObject
    public LoginSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    // from lectures
    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        //driver.get("https://www.webdriveruniversity.com/Login-Portal/index.html?");
        loginPage.navigateToWebdriverUniversity_Login_Page();
    }

    @When("I enter a username {}")
    public void i_enter_a_username(String username) {

        //driver.findElement(By.id("text")).sendKeys(username);
        loginPage.populateUserName(username);
    }

    @And("I enter a password {}")
    public void i_enter_a_password(String password) {

        //driver.findElement(By.id("password")).sendKeys(password);
        loginPage.populatePassword(password);

    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {

        //driver.findElement(By.id("login-button")).click();
        loginPage.clickOnLogin();

    }

    @Then("I should be presented with the successful login message")
    public void i_should_be_presented_with_the_successful_login_message() {
        //String login_Message = driver.switchTo().alert().getText();

        //Assert.assertEquals(login_Message, "validation succeeded");
        loginPage.validateSuccsessfulLoginMessage();
    }

    @Then("I should be presented with the unsuccessful login message")
    public void i_should_be_presented_with_the_unsuccessful_login_message() {
        //String login_Message = driver.switchTo().alert().getText();
        //Assert.assertEquals(login_Message, "validation failed");
        loginPage.validateUnsuccsessfulLoginMessage();
    }

    @Then("I should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message(String expectedMessage) {
        //String login_Message = driver.switchTo().alert().getText();
        //Assert.assertEquals(login_Message, expectedMessage);

        // !!!Important - here we use method directly from BasePage (waitForAlertAndValidateMessageFromAlert)
        // it is possible to use methods directly from BasePage (not from LoginPage), because step definition file LoginSteps extends BasePage
        waitForAlertAndValidateMessageFromAlert(expectedMessage);
    }
}
