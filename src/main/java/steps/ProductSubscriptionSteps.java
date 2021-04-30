package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.HomePage;


public class ProductSubscriptionSteps extends HomePage {

    public HomePage homePage = new HomePage();

    @Before
    public void test() {
        System.out.println("Starting feature");
    }

    @After("@ProductSubscription")
    public void afterScenario() {
        homePage.closeBrowser();
    }

    @Given("^I open Chrome and launch the application$")
    public void openChromeAndLaunchApplication() {
        homePage.startBrowser();
    }

    @When("^I select type \"(.*)\"$")
    public void selectType(String type) {
        homePage.selectType(type);
    }

    @When("^I select support plan \"(.*)\"$")
    public void selectSupportPlan(String plan) {
        homePage.selectPlan(plan);
    }

    @When("^I write monthly duration of \"(.*)\"$")
    public void writeMonthlyDuration(String duration) {
        homePage.setDuration(duration);
    }

    @When("^I click in calculate price button")
    public void clickCalculatePriceButton() throws InterruptedException {
        WebElement button = homePage.calculateButton();
        button.click();
        Thread.sleep(5000);
    }

    @Then("^I validate price is \"(.*)\"$")
    public void validatePrice(String price) {
        WebElement priceElement = homePage.price();
        String priceFound = priceElement.getText();
        Assert.assertEquals(priceFound, price);
    }


    @When("^I attach file \"(.*)\"$")
    public void attachFile(String file) {
        homePage.uploadAttachment(file);
    }

    @When("^I send the comment \"(.*)\"$")
    public void sendMessage(String comment) {
        homePage.sendComment(comment);
    }


    @Then("^I must see an alert informing that the month is incorrect$")
    public void getMonthAlert() {
        homePage.validateMonthAlert();
    }

    @Then("^I validate the message sent$")
    public void validateComment() {
        homePage.validateCommentSent();
    }

    @Then("^I validate the file sent$")
    public void validateFile() {
//      Boolean fileSent = driver.findElement(By.id("selectedConfigurationFile")).isDisplayed();
//      Assert.assertEquals(fileSent, true);
    }
}
