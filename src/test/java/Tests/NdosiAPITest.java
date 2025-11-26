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
    @Test(dependsOnMethods = "UpdateUseProfilePasswordAPITest")
    public static void GetPublicTestimononyUnauthorizedAPITest() {
        // Implementation for CreateTestimononyAPI Test
        NdosiAPIRequestBuilder.GetPublicTestimononyUnauthorizedAPIResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }
   @Test(dependsOnMethods = "GetPublicTestimononyUnauthorizedAPITest")
    public static void CreateTestimononyAPITest() {
        // Implementation for CreateTestimononyAPI Test
        NdosiAPIRequestBuilder.CreateTestimononyAPIResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201)
                .contentType("application/json; charset=utf-8");
    }
    @Test(dependsOnMethods = "CreateTestimononyAPITest")
    public static void GetMyTestimononyAPITest() {
        // Implementation for GetMyTestimononyAPI Test
        NdosiAPIRequestBuilder.GetMyTestimononyAPIResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }

    @Test (dependsOnMethods = "GetMyTestimononyAPITest")
    public static void UpdateTestimononyAPITest() {
        // Implementation for DeleteTestimononyAPI Test
        NdosiAPIRequestBuilder.UpdateTestimononyAPIResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200);
    }
    @Test (dependsOnMethods = "UpdateTestimononyAPITest")
    public static void DeleteTestimononyAPITest() {
        // Implementation for DeleteTestimononyAPI Test
        NdosiAPIRequestBuilder.DeleteMyTestimononyAPIResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200);
    }

    @Test (dependsOnMethods = "DeleteTestimononyAPITest")
    public static void GetStatsTestimonyAPITest() {
        // Implementation for GetStatsTestimonyAPI Test
        NdosiAPIRequestBuilder.GetStatsTestimononyAPIResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }
}
