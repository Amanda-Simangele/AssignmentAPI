package Tests;

import RequestBuilder.ResReqRequestBuilder;
import org.testng.annotations.Test;

public class ResReqTest {

    @Test
    public void getReqResUersList(){
        ResReqRequestBuilder.getReqResUersList()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }
    @Test
    public void getReqResUser() {
        ResReqRequestBuilder.getReqResUser()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }
    @Test (dependsOnMethods = "getReqResUser")
    public void createReqResUser() {
        ResReqRequestBuilder.createReqResUser()
                .then()
                .log().all()
                .assertThat()
                .statusCode(201)
                .contentType("application/json; charset=utf-8");
    }
    @Test (dependsOnMethods = "createReqResUser")
    public void getSingleReqResUser() {
        ResReqRequestBuilder.getSingleReqResUser()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");

    }
    @Test (dependsOnMethods = "getSingleReqResUser")
    public void updateReqResUser() {
        ResReqRequestBuilder.updateSingleReqResUser()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }
    @Test (dependsOnMethods = "updateReqResUser")
    public void deleteReqResUser() {
        ResReqRequestBuilder.deleteSingleReqResUser()
                .then()
                .log().all()
                .assertThat()
                .statusCode(204);
    }
    @Test (dependsOnMethods = "deleteReqResUser")
    public void registerReqResUser() {
        ResReqRequestBuilder.registerReqResUser()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }


    @Test (dependsOnMethods = "registerReqResUser")
    public void login() {
        ResReqRequestBuilder.loginReqResUser()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }
    @Test (dependsOnMethods = "login")
    public void deleteUser() {
        ResReqRequestBuilder.deleteSingleReqResUser()
                .then()
                .log().all()
                .assertThat()
                .statusCode(204);
    }
    @Test (dependsOnMethods = "deleteUser")
    public void logout() {
        ResReqRequestBuilder.logoutReqResUser()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }
    @Test (dependsOnMethods = "logout")
    public void getResourcesReqResUserResponse() {
        ResReqRequestBuilder.getResourcesReqResUserResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }

    // --- New tests for /unknown/3 ---

    @Test
    public void putUnknownResourceTest() {
        ResReqRequestBuilder.putUnknownResource()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }

    @Test
    public void patchUnknownResourceTest() {
        ResReqRequestBuilder.patchUnknownResource()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }

    @Test
    public void deleteUnknownResourceTest() {
        ResReqRequestBuilder.deleteUnknownResource()
                .then()
                .log().all()
                .assertThat()
                .statusCode(204);
    }
    @Test //inhansed delay test
    public void getReqResUersListDelay3secondsTest() {
        ResReqRequestBuilder.getReqResUersListDelay3seconds()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");

    }
    @Test //inhansed delay test
    public void getReqResUsersPage2Test() {
        ResReqRequestBuilder.getReqResUsersPage2()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");

    }

}
