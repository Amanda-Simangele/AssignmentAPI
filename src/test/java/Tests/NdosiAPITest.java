package Tests;

import RequestBuilder.NdosiAPIRequestBuilder;
import org.testng.annotations.Test;

public class NdosiAPITest {

    @Test
    public static void CreateSuccessfulRegistrationAPITest() {
        // Implementation for CreateSuccessfulRegistrationAPI Test
        NdosiAPIRequestBuilder.CreateSuccessfulRegistrationAPIResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201)
                .contentType("application/json; charset=utf-8");
    }
    @Test(dependsOnMethods = "CreateSuccessfulRegistrationAPITest")
    public static void CreateUnsuccessfulRegistrationAPITest() {
        // Implementation for CreateUnsuccessfulRegistrationAPI Test
        NdosiAPIRequestBuilder.ExistingUserBodyAPIResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(400)
                .contentType("application/json; charset=utf-8");
    }

}
