package RequestBuilder;

import PayloadBuilder.NdosiAPIPayLoadBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static Common.BasePaths.*;

public class NdosiAPIRequestBuilder {

    static String useID;

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


}
