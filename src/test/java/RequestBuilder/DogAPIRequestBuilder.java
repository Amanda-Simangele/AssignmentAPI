package RequestBuilder;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static Common.BasePaths.*;

public class DogAPIRequestBuilder {

    public static Response GetListOfDogsAPIResponse() {

         return RestAssured.given()
                .baseUri(DogBaseURL)
                .basePath("/list/all")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                 .log().all()
                 .get()
                 .then()
                 .extract().response();

    }
    public static Response GetRandomDogImageResponse() {
        return RestAssured.given()
                .baseUri(DogBaseURL)
                .basePath("/image/random")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .get()
                .then()
                .extract().response();
    }

    public static Response GetThreeRandomDogImagesResponse() {
        return RestAssured.given()
                .baseUri(DogBaseURL)
                .basePath("/image/random/3")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .get()
                .then()
                .extract().response();
    }
    public static Response GetHoundImagesResponse() {
            return RestAssured.given()
                    .baseUri(DogBaseURL2)
                    .basePath("hound/images")
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .log().all()
                    .get()
                    .then()
                    .extract().response();
        }


        public static Response GetRandomHoundImageResponse() {
        return RestAssured.given()
                .baseUri(DogBaseURL2)
                .basePath("/hound/images/random")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .get()
                .then()
                .extract().response();
    }

    public static Response GetThreeRandomHoundImagesResponse() {
        return RestAssured.given()
                .baseUri(DogBaseURL2)
                .basePath("/hound/images/random/3")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .get()
                .then()
                .extract().response();
    }
    public static Response GetHoundListResponse() {
        return RestAssured.given()
                .baseUri(DogBaseURL2)
                .basePath("/hound/list")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .get()
                .then()
                .extract().response();
    }

    public static Response GetAfghanImagesResponse() {
        return RestAssured.given()
                .baseUri(DogBaseURL2)
                .basePath("/hound/afghan/images")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .get()
                .then()
                .extract().response();
    }

    public static Response GetRandomAfghanImageResponse() {
        return RestAssured.given()
                .baseUri(DogBaseURL2)
                .basePath("/hound/afghan/images/random")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .get()
                .then()
                .extract().response();
    }

    public static Response GetThreeRandomAfghanImagesResponse() {
        return RestAssured.given()
                .baseUri(DogBaseURL2)
                .basePath("/hound/afghan/images/random/3")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .get()
                .then()
                .extract().response();
    }


}
