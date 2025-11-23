package RequestBuilder;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static Common.Authorisations.REQRES_API_KEY;
import static Common.BasePaths.*;


public class ResReqRequestBuilder {

    public static Response getReqResUersList(){

        return RestAssured.given()
                .baseUri(ReqResBaseUrl)
                .basePath(ReqResPath)
                .header("x-api-key", REQRES_API_KEY)
                .log().all()
                .get()
                .then()
                .extract().response();
    }
    public static Response getReqResUser(){

        return RestAssured.given()
                .baseUri(ReqResBaseUrl)
                .basePath(ReqResPath + "/1")
                .header("x-api-key", REQRES_API_KEY)
                .log().all()
                .get()
                .then()
                .extract().response();
    }




}
