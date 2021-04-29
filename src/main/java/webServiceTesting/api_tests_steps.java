package webServiceTesting;


import clients.CreateUser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.response.Response;

public class Steps {

    private String payload;
    private Response postResponse;
    CreateUser createUser;

    @Given("^I use user creation service$")
    public void useUserCreationWebService() {
        createUser = new CreateUser();
    }

    @When("^I set name \"([^\"]*)\"$")
    public void setName(String name) {
        createUser.setName(name);
    }

    @When("^I set job \"([^\"]*)\"$")
    public void setJob(String job) {
        createUser.setJob(job);
    }

    @When("^I build the payload$")
    public void buildPayload() {
        payload = createUser.buildPayload();
    }

    @When("^I send the post request$")
    public void sendPostRequest() {
       this.postResponse = createUser.postRequest(payload);
    }

    @Then("^I validate my response is correct$")
    public void validateMyResponseIsCorrect() {
        createUser.validatePostResponse(this.postResponse);
    }
}
