package clients;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class DeleteUser {

    private final RequestSpecification requestSpecification;


    public DeleteUser() {
        this.requestSpecification = RestAssured.given()
                .baseUri("https://reqres.in/api")
                .basePath("/users");
    }

    public Response deleteUser(String userId) {
        Response deleteResponse = this.requestSpecification.delete("/" + userId + "");
        return deleteResponse;
    }

    public void validateDelete(Response deleteResponse) {
        Assert.assertEquals(deleteResponse.getStatusCode(), 204);
    }
}
