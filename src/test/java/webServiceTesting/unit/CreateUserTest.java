package webServiceTesting.unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import clients.CreateUser;

public class CreateUserTest {

  CreateUser createUser = new CreateUser();
  String jsonWithUserAndJob = "{\n" +
      "    \"name\": \"testName\",\n" +
      "    \"job\": \"testJob\"\n" +
      "}";

  String jsonWithUserNameSurnameAndJob = "{\n" +
      "    \"name\": \"testName autoSurname\",\n" +
      "    \"job\": \"testJob\"\n" +
      "}";

  @Before
  public void setup() {
    createUser.setName("testName");
    createUser.setJob("testJob");
  }

  @Test
  public void buildBody_validUserAndJob_shouldReturnJsonWithUserAndJob() {
    Assert.assertEquals(jsonWithUserAndJob, createUser.buildUserPayload());
  }

  @Test
  public void buildBodyWithSurname_validUserAndJob_shouldReturnJsonWithUserNameSurnameAndJob() {
    Assert.assertEquals(jsonWithUserNameSurnameAndJob, createUser.buildBodyWithSurname());
  }

}