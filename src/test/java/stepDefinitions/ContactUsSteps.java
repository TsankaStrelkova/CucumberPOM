package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePage;
import pageObjects.ContactUsPage;


public class ContactUsSteps extends BasePage {


    private ContactUsPage contactUsPage;

    public  ContactUsSteps(ContactUsPage contactUsPage)
    {
        this.contactUsPage = contactUsPage;
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page()
    {
        //driver.get("http://webdriveruniversity.com/Contact-Us/contactus.html");
        contactUsPage.navigateToWebdriverUniversity_ContactUs_Page();
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        //driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("AutoGenFN"+generateRandomString(5));
        contactUsPage.enterUniqueFirstName();
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        //driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys("AutoGenLN"+generateRandomString(6));
        contactUsPage.enterUniqueLastName();
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        //driver.findElement(By.cssSelector("input[name='email']")).sendKeys("auto_gen_"+generateRandomNumber(4)+"@mail.com");
        contactUsPage.enterUniqueEmail();
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        //driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys(generateRandomString(55));
        contactUsPage.enterUniqueComment();
    }


    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        //driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys(firstName);
        contactUsPage.populateFirstName(firstName);
    }

    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        //driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys(lastName);
        contactUsPage.populateLastName(lastName);
    }

    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        //driver.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
        contactUsPage.populateEmail(email);
    }

    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        //driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys(comment);
        contactUsPage.populateComment(comment);
    }

    @And("I click on the Submit button")
    public void i_click_on_the_submit_button() {

        //driver.findElement(By.cssSelector("input[type='submit']")).click();
        contactUsPage.clickOnSubmit();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
//       WebElement message = driver.findElement(By.cssSelector("[id='contact_reply'] h1"));
//       Assert.assertEquals(message.getText(),"Thank You for your Message!", "The message doesn't appear or is not the expected one");
        contactUsPage.successfullSubmitContactMessage();
    }

}
