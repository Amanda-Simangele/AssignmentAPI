package RequestBuilder;

import PayloadBuilder.ReqResPayLoadBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static Common.Authorisations.REQRES_API_KEY;
import static Common.BasePaths.*;


// Request helper for ReqRes API: small methods that build and send HTTP requests.
public class ResReqRequestBuilder {

    public static String useID;
    // store token returned by login/register
    public static String reqresToken;

    // GET /api/users  - returns list of users
    public static Response getReqResUersList() {

        return RestAssured.given()
                .baseUri(ReqResBaseUrl)
                .basePath(ReqResPath)
                .header("x-api-key", REQRES_API_KEY)
                .log().all()
                .get()
                .then()
                .extract().response();
    }

    // GET /api/users/1 - returns first user
    public static Response getReqResUser() {

        return RestAssured.given()
                .baseUri(ReqResBaseUrl)
                .basePath(ReqResPath + "/1")
                .header("x-api-key", REQRES_API_KEY)
                .log().all()
                .get()
                .then()
                .extract().response();
    }

    // POST /api/users - create user and save returned ID
    public static Response createReqResUser() {

    Response response = RestAssured.given()
            .baseUri(ReqResBaseUrl)
            .basePath(ReqResPath)
            .header("x-api-key", REQRES_API_KEY)
            .contentType(ContentType.JSON)
            .log().all()
            .body(ReqResPayLoadBuilder.CreateUserBody())
            .post()
            .then()
            .extract().response();

    useID = response.jsonPath().getString("ID");
    return response;

}
    // GET /api/users/{useID} - get user created earlier
    public static Response getSingleReqResUser() {

        return RestAssured.given()
                .baseUri(ReqResBaseUrl)
                .basePath(ReqResPath + useID)
                .header("x-api-key", REQRES_API_KEY)
                .log().all()
                .get()
                .then()
                .extract().response();
    }
    // PUT /api/users/{useID} - full update for the created user
    public static Response updateSingleReqResUser() {

        return RestAssured.given()
                .baseUri(ReqResBaseUrl)
                .basePath(ReqResPath + "/" + useID)
                .header("x-api-key", REQRES_API_KEY)
                .contentType(ContentType.JSON)
                .log().all()
                // ensure we send a JSON string body; payload builder should provide JSON or have toJSONString()
                .body(ReqResPayLoadBuilder.updateeUserBody().toString())
                .put()
                .then()
                .extract().response();

    }
    // DELETE /api/users/{useID} - delete the created user
    public static Response deleteSingleReqResUser() {

        return RestAssured.given()
                .baseUri(ReqResBaseUrl)
                .basePath(ReqResPath + "/" + useID)
                .header("x-api-key", REQRES_API_KEY)
                .log().all()
                .delete()
                .then()
                .extract().response();
    }

    // --- New methods: login, register, logout ---

    // POST /login - login and capture token if returned
    public static Response loginReqResUser() {
        Response response = RestAssured.given()
                .baseUri(ReqResBaseUrl)
                .basePath("/login")
                .header("x-api-key", REQRES_API_KEY)
                .contentType(ContentType.JSON)
                .log().all()
                .body(ReqResPayLoadBuilder.loginBody().toJSONString())
                .post()
                .then()
                .extract().response();

        Object token = response.path("token");
        if (token != null) reqresToken = token.toString();
        return response;
    }

    // POST /register - register and capture token + id if returned
    public static Response registerReqResUser() {
        Response response = RestAssured.given()
                .baseUri(ReqResBaseUrl)
                .basePath("/register")
                .header("x-api-key", REQRES_API_KEY)
                .contentType(ContentType.JSON)
                .log().all()
                .body(ReqResPayLoadBuilder.registerBody().toJSONString())
                .post()
                .then()
                .extract().response();

        Object token = response.path("token");
        if (token != null) reqresToken = token.toString();
        // also capture id if returned
        Object idObj = response.path("id");
        if (idObj != null && (useID == null || useID.trim().isEmpty())) {
            useID = idObj.toString();
        }

        return response;
    }




    // POST /logout - logout (no body expected)
    public static Response logoutReqResUser() {
        // Preferred: POST with no body and no Content-Type header (matches Postman/most servers)
        return RestAssured.given()
                .baseUri(ReqResBaseUrl)
                .basePath("/logout")
                .header("x-api-key", REQRES_API_KEY)
                .header("Content-Type", "application/json; charset=UTF-8")// Ask about this line because it is not required anywhere and there is no body on this request
                .log().all()
                .post()
                .then()
                .extract().response();


    }

    // GET /unknown/3 - returns a single resource
    public static Response getResourcesReqResUserResponse() {
        return RestAssured.given()
                .baseUri(ReqResBaseUrl)
                .basePath("/unknown/3")
                .header("x-api-key", REQRES_API_KEY)
                .contentType(ContentType.JSON)
                .log().all()
                .get()
                .then()
                .extract().response();

    }

    // PUT /unknown/3 - update resource
    public static Response putUnknownResource() {
        String payload = "{\"name\":\"morpheus\",\"year\":2024,\"color\":\"#17-2031\"}";
        return RestAssured.given()
                .baseUri(ReqResBaseUrl)
                .basePath("/unknown/3")
                .header("x-api-key", REQRES_API_KEY)
                .contentType(ContentType.JSON)
                .log().all()
                .body(payload)
                .put()
                .then()
                .extract().response();
    }

    // PATCH /unknown/3 - partial update
    public static Response patchUnknownResource() {
        String payload = "{\"name\":\"morpheus-updated\"}";
        return RestAssured.given()
                .baseUri(ReqResBaseUrl)
                .basePath("/unknown/3")
                .header("x-api-key", REQRES_API_KEY)
                .contentType(ContentType.JSON)
                .log().all()
                .body(payload)
                .patch()
                .then()
                .extract().response();
    }

    // DELETE /unknown/3 - delete resource
    public static Response deleteUnknownResource() {
        return RestAssured.given()
                .baseUri(ReqResBaseUrl)
                .basePath("/unknown/3")
                .header("x-api-key", REQRES_API_KEY)
                .log().all()
                .delete()
                .then()
                .extract().response();
    }

    // GET /api/users?delay=3 - delayed response
    public static Response getReqResUersListDelay3seconds() {

        return RestAssured.given()
                .baseUri(ReqResBaseUrl)
                .basePath(ReqResPath + "?delay=3")
                .header("x-api-key", REQRES_API_KEY)
                .log().all()
                .get()
                .then()
                .extract().response();
    }
    // GET /api/users?page=2 - users page 2
    public static Response getReqResUsersPage2() {
        return RestAssured.given()
                .baseUri(ReqResBaseUrl)
                .basePath(ReqResPath)
                .queryParam("page", 2)
                .header("x-api-key", REQRES_API_KEY)
                .log().all()
                .get()
                .then()
                .extract().response();
    }


}
