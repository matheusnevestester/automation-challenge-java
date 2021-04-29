package webServiceTesting;

import clients.CreateUser;
import clients.DeleteUser;
import clients.RegisterUser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class api_tests_steps {

    private String payload;
    private Response postResponse;
    CreateUser createUser;
    DeleteUser deleteUser;
    RegisterUser registerUser;

    @Given("^I use the user creation service$")
    public void useUserCreationWebService() {
        createUser = new CreateUser();
    }
    @Given("^I use the user deletion service$")
    public void useUserDeletionWebService() {
        deleteUser = new DeleteUser();
    }
    @Given("^I use the user registering service$")
    public void useUserRegisteringWebService() {
        registerUser = new RegisterUser();
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
    public void buildUserPayload() {
        payload = createUser.buildUserPayload();
    }

    @When("^I send the post request$")
    public void sendPostRequest() {
        this.postResponse = createUser.postRequest(payload);
    }

    @Then("^I validate the user creation response is correct$")
    public void validateUserResponse() {
        createUser.validateUserResponse(this.postResponse);
    }

    @When("^I try to delete the user \"([^\"]*)\"$")
    public void deleteUser(String userId) {
       this.postResponse = deleteUser.deleteUser(userId);
    }

    @When("^I set email as \"([^\"]*)\"$")
    public void setEmail(String email) {
        registerUser.setEmail(email);
    }

    @When("^I set the password as \"([^\"]*)\"$")
    public void setPassword(String password) {
        registerUser.setPassword(password);
    }

    @When("^I build the register payload$")
    public void buildRegisterPayload() {
        payload = registerUser.buildRegisterPayload();
    }

    @Then("^I validate the delete response is correct$")
    public void validateDelete() {
        deleteUser.validateDelete(this.postResponse);
    }

    @When("^I validate the register response is correct with status \"([^\"]*)\"$")
    public void validateRegisterResponse(String status) {
        registerUser.validateRegisterResponse(status, this.postResponse);
    }
    @When("^I send the register post request$")
    public void sendRegisterPostRequest() {
        this.postResponse = registerUser.postRequest(payload);
    }

}
