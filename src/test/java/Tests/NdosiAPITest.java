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
    @Test(dependsOnMethods = "CreateSuccessfulRegistrationAPITest")
    public static void ExistingUserBodyAPITest() {
        // Implementation for ExistingUserBodyAPI Test
        NdosiAPIRequestBuilder.ExistingUserBodyAPIResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(400)
                .contentType("application/json; charset=utf-8");
    }
    @Test(dependsOnMethods = "CreateSuccessfulRegistrationAPITest")
    public static void FieldsRequiredBodyAPITest() {
        // Implementation for FieldsRequiredBodyAPI Test
        NdosiAPIRequestBuilder.FieldsRequiredBodyAPIResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(400)
                .contentType("application/json; charset=utf-8");
    }


    @Test(dependsOnMethods = "FieldsRequiredBodyAPITest")
    public static void LoginSuccessfulAPITest() {
        // Implementation for LoginSuccessfulAPI Test
        NdosiAPIRequestBuilder.LoginSuccessfulAPIResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }
    @Test (dependsOnMethods = "LoginSuccessfulAPITest")
    public static void GetPublicTestimononyAPITest() {
        // Implementation for GetPublicTestimononyAPI Test
        NdosiAPIRequestBuilder.GetPublicTestimononyAPIResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }
    @Test(dependsOnMethods = "LoginSuccessfulAPITest")
    public static void UpdateUserProfileTest() {
        // Implementation for UpdateUserProfile Test
        NdosiAPIRequestBuilder.UpdateUserProfileBodyResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }
    @Test(dependsOnMethods = "LoginSuccessfulAPITest")
    public static void GetUserProfileUnauthorizedTest() {
        // Implementation for CreateTestimononyAPI Test
        NdosiAPIRequestBuilder.GetUserProfileUnauthorizedResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(401)
                .contentType("application/json; charset=utf-8");
    }
    @Test (dependsOnMethods = "LoginSuccessfulAPITest")
    public static void UpdateUseProfilePasswordAPITest() {
        // Implementation for CreateTestimononyAPI Test
        NdosiAPIRequestBuilder.UpdateUseProfilePasswordResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }

}
