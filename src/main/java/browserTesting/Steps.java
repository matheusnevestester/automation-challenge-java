package browserTesting;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.HomePage;


public class Steps extends HomePage {

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
    public void validatePrice(String price) throws InterruptedException {
        WebElement priceElement = homePage.price();
        String priceFound = priceElement.getText();
        Assert.assertEquals(priceFound, price);
    }


//    @Then("^I attach file \"(.*)\"$")
//    public void	attachFile(String file) throws  {
//        WebElement uploadElement = driver.findElement(By.id("attachment"));
//        uploadElement.sendKeys(file);
//    }

}
