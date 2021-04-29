package clients;

import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class CreateUser {

    private String name;
    private String job;
    private final RequestSpecification requestSpecification;

    public CreateUser() {
        this.requestSpecification = RestAssured.given()
                .baseUri("https://reqres.in/api")
                .basePath("/users");
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String buildUserPayload() {
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("name",this.name);
        requestBody.addProperty("job",this.job);
        return requestBody.toString();
    }

    public String buildBodyWithSurname() {
        return null;
    }

    public Response postRequest(String requestBody) {
        Response postResponse = this.requestSpecification.given().header("Content-type","application/json").body(requestBody).post();
        return postResponse;
    }

    public void validateUserResponse(Response postResponse){
        String name = postResponse.jsonPath().get("name");
        String job = postResponse.jsonPath().get("job");
        Assert.assertEquals(postResponse.getStatusCode(), 201);
        Assert.assertEquals(name,"Toy");
        Assert.assertEquals(job,"singer");

    }

}
