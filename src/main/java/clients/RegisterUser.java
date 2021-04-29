package clients;

import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class RegisterUser {

    private String email;
    private String password;

    private final RequestSpecification requestSpecification;

    public RegisterUser() {
        this.requestSpecification = RestAssured.given()
                .baseUri("https://reqres.in/api")
                .basePath("/register");
    }

    public void setEmail(String userEmail) {
        this.email = userEmail;
    }

    public void setPassword(String userPassword) {
        this.password = userPassword;
    }

    public String buildRegisterPayload() {
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("email", this.email);
        requestBody.addProperty("password", this.password);
        return requestBody.toString();
    }

    public Response postRequest(String requestBody) {
        Response postResponse = this.requestSpecification.given().header("Content-type", "application/json").body(requestBody).post();
        return postResponse;
    }

    public void validateRegisterResponse(String status, Response postResponse) {
        int statusNumber = Integer.parseInt(status);
        String errorMessage = postResponse.jsonPath().get("error");
        Assert.assertEquals(postResponse.getStatusCode(), statusNumber);
        Assert.assertEquals(errorMessage,"Missing password");
    }
}