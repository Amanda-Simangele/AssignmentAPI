package Tests;

import RequestBuilder.ResReqRequestBuilder;
import org.testng.annotations.Test;

// Tests for ReqRes API endpoints (basic status + content-type checks)
public class ResReqTest {

    // GET /api/users - expect 200 and JSON
    @Test
    public void getReqResUersList(){
        ResReqRequestBuilder.getReqResUersList()
                .then()
                .log().all()
                .assertThat()
               .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }
    // GET /api/users/1 - expect 200 and JSON
    @Test (dependsOnMethods = "getReqResUersList")
    public void getReqResUser() {
        ResReqRequestBuilder.getReqResUser()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }
    // POST /api/users - create user, expect 201 and JSON
    @Test (dependsOnMethods = "getReqResUser")
    public void createReqResUser() {
        ResReqRequestBuilder.createReqResUser()
                .then()
                .log().all()
                .assertThat()
                .statusCode(201)
                .contentType("application/json; charset=utf-8");
    }
    // GET created user by ID - expect 200 and JSON
    @Test (dependsOnMethods = "createReqResUser")
    public void getSingleReqResUser() {
        ResReqRequestBuilder.getSingleReqResUser()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");

    }
    // PUT update user - expect 200 and JSON
    @Test (dependsOnMethods = "getSingleReqResUser")
    public void updateReqResUser() {
        ResReqRequestBuilder.updateSingleReqResUser()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }
    // DELETE user - expect 204 No Content
    @Test (dependsOnMethods = "updateReqResUser")
    public void deleteReqResUser() {
        ResReqRequestBuilder.deleteSingleReqResUser()
                .then()
                .log().all()
                .assertThat()
                .statusCode(204);
    }
    // POST /register - expect 200 and JSON (defined users only)
    @Test (dependsOnMethods = "deleteReqResUser")
    public void registerReqResUser() {
        ResReqRequestBuilder.registerReqResUser()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }


    // POST /login - expect 200 and JSON (captures token)
    @Test (dependsOnMethods = "registerReqResUser")
    public void login() {
        ResReqRequestBuilder.loginReqResUser()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }
    // DELETE previously created user - expect 204
    @Test (dependsOnMethods = "login")
    public void deleteUser() {
        ResReqRequestBuilder.deleteSingleReqResUser()
                .then()
                .log().all()
                .assertThat()
                .statusCode(204);
    }
    // POST /logout - expect 200
    @Test (dependsOnMethods = "deleteUser")
    public void logout() {
        ResReqRequestBuilder.logoutReqResUser()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }
    // GET /unknown/3 - expect 200 and JSON
    @Test (dependsOnMethods = "logout")
    public void getResourcesReqResUserResponse() {
        ResReqRequestBuilder.getResourcesReqResUserResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }

    // --- Tests for /unknown/3 operations ---

    // PUT /unknown/3 - expect 200 and JSON
    @Test (dependsOnMethods = "getResourcesReqResUserResponse")
    public void putUnknownResourceTest() {
        ResReqRequestBuilder.putUnknownResource()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }

    // PATCH /unknown/3 - expect 200 and JSON
    @Test (dependsOnMethods = "putUnknownResourceTest")
    public void patchUnknownResourceTest() {
        ResReqRequestBuilder.patchUnknownResource()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }

    // DELETE /unknown/3 - expect 204
    @Test (dependsOnMethods = "patchUnknownResourceTest")
    public void deleteUnknownResourceTest() {
        ResReqRequestBuilder.deleteUnknownResource()
                .then()
                .log().all()
                .assertThat()
                .statusCode(204);
    }
    // GET /api/users?delay=3 - expect 200 and JSON
    @Test (dependsOnMethods = "deleteUnknownResourceTest")//inhansed delay test
    public void getReqResUersListDelay3secondsTest() {
        ResReqRequestBuilder.getReqResUersListDelay3seconds()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");

    }
    // GET /api/users?page=2 - expect 200 and JSON
    @Test (dependsOnMethods = "getReqResUersListDelay3secondsTest") //inhansed delay test
    public void getReqResUsersPage2Test() {
        ResReqRequestBuilder.getReqResUsersPage2()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");

    }

}
