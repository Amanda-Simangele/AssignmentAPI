package RequestBuilder;

import Common.Authorisations;
import PayloadBuilder.NdosiAPIPayLoadBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static Common.BasePaths.*;

// Request builder for Ndosi API interactions
public class NdosiAPIRequestBuilder {

    static String useID;
    // mutable token stored after login
    private static String authToken = null;

    // Method to create a successful registration
    public static Response CreateSuccessfulRegistrationAPIResponse() {

        Response response = RestAssured.given()
                .baseUri(NdosiBaseURL)
                .basePath("/" + "register")
                .contentType(ContentType.JSON)
                .log().all()
                .body(NdosiAPIPayLoadBuilder.SuccessfulRegistrationBody())
                .post()
                .then()
                .extract().response();

        useID = response.jsonPath().getString("ID");
        return response;

    }

    // Method to create a registration with an existing user
    public static Response ExistingUserBodyAPIResponse() {

        return RestAssured.given()
                .baseUri(NdosiBaseURL)
                .basePath("/" + "register")
                .contentType(ContentType.JSON)
                .log().all()
                .body(NdosiAPIPayLoadBuilder.ExistingUserBody())
                .post()
                .then()
                .extract().response();
    }

    // Method to create a registration with missing required fields
    public static Response FieldsRequiredBodyAPIResponse() {

        return RestAssured.given()
                .baseUri(NdosiBaseURL)
                .basePath("/" + "register")
                .contentType(ContentType.JSON)
                .log().all()
                .body(NdosiAPIPayLoadBuilder.FieldsRequiredBody())
                .post()
                .then()
                .extract().response();
    }
    // Method to log in successfully
    public static Response LoginSuccessfulAPIResponse() {

        Response response = RestAssured.given()
                .baseUri(NdosiBaseURL)
                .basePath("/" + "login")
                .contentType(ContentType.JSON)
                .log().all()
                .body(NdosiAPIPayLoadBuilder.LoginUserSuccessfulBody())
                .post()
                .then()
                .extract().response();

        // extract token from common locations and store
        String token = response.jsonPath().getString("token");
        if (token == null) token = response.jsonPath().getString("access_token");
        if (token == null) token = response.jsonPath().getString("data.token");
        if (token != null && !token.isBlank()) {
            authToken = token;
            // also set the global Authorisations field so other builders/tests can read it
            Authorisations.NdosiAPI_Token = token;
        }

        return response;
    }

    // Method to retrieve public testimonials
    //User profile / public testimonials section
    public static Response GetPublicTestimononyAPIResponse() {

        RequestSpecification req = RestAssured.given()
                .baseUri(NdosiBaseURL)
                .basePath("/testimonials")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all();

        // attach Authorization only if we have a valid token; fall back to Authorisations constant if present
        String tokenToUse = authToken;
        if ((tokenToUse == null || tokenToUse.isBlank()) && Authorisations.NdosiAPI_Token != null && !Authorisations.NdosiAPI_Token.isBlank()) {
            tokenToUse = Authorisations.NdosiAPI_Token;
        }

        if (tokenToUse != null && !tokenToUse.isBlank()) {
            req.header("Authorization", "Bearer " + tokenToUse);
        }

        return req.get()
                .then()
                .extract().response();
    }

    // Method to retrieve the stored token
    // helper to read/clear the token programmatically from tests
    public static String getStoredToken() {
        if (authToken != null && !authToken.isBlank()) return authToken;
        return Authorisations.NdosiAPI_Token;
    }

    // Method to clear the stored token
    public static void clearStoredToken() {
        authToken = null;
        Authorisations.NdosiAPI_Token = null;
    }

    // Method to retrieve the extracted user ID
    // small helper so tests/other builders can read the extracted ID
    public static String getUseID() {
        return useID;
    }

    // Method to update the user profile
    public static Response UpdateUserProfileBodyResponse() {

        RequestSpecification req = RestAssured.given()
                .baseUri(NdosiBaseURL)
                .basePath("/profile")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all();

        String token = getStoredToken();
        if (token == null || token.isBlank()) {
            throw new IllegalStateException("No auth token available. Call LoginSuccessfulAPIResponse() and ensure it returned a valid token before calling UpdateUserProfileBodyResponse().");
        }

        req.header("Authorization", "Bearer " + token);

        return req
                .body(NdosiAPIPayLoadBuilder.UpdateUserProfileBody())
                .put()
                .then()
                .extract().response();
    }
    // Method to retrieve the user profile without authorization
    public static Response GetUserProfileUnauthorizedResponse() {

        return RestAssured.given()
                .baseUri(NdosiBaseURL)
                .basePath("/profile")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .get()
                .then()
                .extract().response();
    }
    // Method to update the user profile password
    public static Response UpdateUseProfilePasswordResponse() {

        RequestSpecification req = RestAssured.given()
                .baseUri(NdosiBaseURL)
                .basePath("/profile")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(NdosiAPIPayLoadBuilder.UpdateUserProfilepasswordBody())
                .log().all();

        String token = getStoredToken();
        if (token == null || token.isBlank()) {
            throw new IllegalStateException("No auth token available. Call LoginSuccessfulAPIResponse() and ensure it returned a valid token before calling GetUserProfileAuthorizedResponse().");
        }

        req.header("Authorization", "Bearer " + token);

        return req.get()
                .then()
                .extract().response();
    }
    // Method to retrieve public testimonials without authorization
    public static Response GetPublicTestimononyUnauthorizedAPIResponse() {

        return RestAssured.given()
                .baseUri(NdosiBaseURL)
                .basePath("/testimonials")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .get()
                .then()
                .extract().response();
    }

    // Method to create a testimonial
    public static Response CreateTestimononyAPIResponse() {

        RequestSpecification req = RestAssured.given()
                .baseUri(NdosiBaseURL)
                .basePath("/testimonials")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all();

        String token = getStoredToken();
        if (token == null || token.isBlank()) {
            throw new IllegalStateException("No auth token available. Call LoginSuccessfulAPIResponse() and ensure it returned a valid token before calling CreateTestimononyAPIResponse().");
        }

        req.header("Authorization", "Bearer " + token);

        Response response = req
                .body(NdosiAPIPayLoadBuilder.CreateTestimonialBody())
                .post()
                .then()
                .extract().response();

        useID = response.jsonPath().getString("ID");

        return response;
    }



    // Method to retrieve the user's testimonials
    public static Response GetMyTestimononyAPIResponse() {

        RequestSpecification req = RestAssured.given()
                .baseUri(NdosiBaseURL)
                .basePath("/my-testimonials")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all();

        String token = getStoredToken();
        if (token == null || token.isBlank()) {
            throw new IllegalStateException("No auth token available. Call LoginSuccessfulAPIResponse() and ensure it returned a valid token before calling GetMyTestimononyAPIResponse().");
        }

        req.header("Authorization", "Bearer " + token);


        Response response = req.get()
                .then()
                .extract().response();

        useID = response.jsonPath().getString("ID");

        return response;
    }

    // Method to update a testimonial
    public static Response UpdateTestimononyAPIResponse() {

        RequestSpecification req = RestAssured.given()
                .baseUri(NdosiBaseURL)
                .basePath("/testimonials/" + useID )
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all();

        String token = getStoredToken();
        if (token == null || token.isBlank()) {
            throw new IllegalStateException("No auth token available. Call LoginSuccessfulAPIResponse() and ensure it returned a valid token before calling CreateTestimononyAPIResponse().");
        }

        req.header("Authorization", "Bearer " + token);

        Response response = req
                .body(NdosiAPIPayLoadBuilder.UpdateTestimonialBody())
                .put()
                .then()
                .extract().response();

        useID = response.jsonPath().getString("ID");

        return response;
    }
    // Method to delete the user's testimonial
    public static Response DeleteMyTestimononyAPIResponse() {

        RequestSpecification req = RestAssured.given()
                .baseUri(NdosiBaseURL)
                .basePath("/testimonials/" + useID)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all();

        String token = getStoredToken();
        if (token == null || token.isBlank()) {
            throw new IllegalStateException("No auth token available. Call LoginSuccessfulAPIResponse() and ensure it returned a valid token before calling GetMyTestimononyAPIResponse().");
        }

        req.header("Authorization", "Bearer " + token);


        Response response = req.delete()
                .then()
                .extract().response();

        return response;
    }

    // Method to retrieve testimonial statistics
    public static Response GetStatsTestimononyAPIResponse() {

        RequestSpecification req = RestAssured.given()
                .baseUri(NdosiBaseURL)
                .basePath("/testimonials/stats" )
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all();

        String token = getStoredToken();
        if (token == null || token.isBlank()) {
            throw new IllegalStateException("No auth token available. Call LoginSuccessfulAPIResponse() and ensure it returned a valid token before calling GetMyTestimononyAPIResponse().");
        }

        req.header("Authorization", "Bearer " + token);


        Response response = req.get()
                .then()
                .extract().response();

        return response;
    }
    // Method to retrieve API information
    public static Response GetAPIInfoUtilityAPIResponse() {

        RequestSpecification req = RestAssured.given()
                .baseUri(NdosiBaseURL)
                .basePath("/" )
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all();

        String token = getStoredToken();
        if (token == null || token.isBlank()) {
            throw new IllegalStateException("No auth token available. Call LoginSuccessfulAPIResponse() and ensure it returned a valid token before calling GetMyTestimononyAPIResponse().");
        }

        req.header("Authorization", "Bearer " + token);


        Response response = req.get()
                .then()
                .extract().response();

        return response;
    }
    // Method to perform a health check
    public static Response GetHealthChechUtilityAPIResponse() {

        RequestSpecification req = RestAssured.given()
                .baseUri(NdosiBaseURL)
                .basePath("/health" )
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all();

        String token = getStoredToken();
        if (token == null || token.isBlank()) {
            throw new IllegalStateException("No auth token available. Call LoginSuccessfulAPIResponse() and ensure it returned a valid token before calling GetMyTestimononyAPIResponse().");
        }

        req.header("Authorization", "Bearer " + token);


        Response response = req.get()
                .then()
                .extract().response();

        return response;
    }






}
