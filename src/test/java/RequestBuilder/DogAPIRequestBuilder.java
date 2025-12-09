package RequestBuilder;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static Common.BasePaths.*;

// Request builder for Dog API endpoints (dog.ceo)
// Each method returns a RestAssured Response for a specific endpoint
public class DogAPIRequestBuilder {

    // GET /breeds/list/all - returns a list of all breeds
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

    // GET /breeds/image/random - returns a random dog image
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

    // GET /breeds/image/random/3 - returns three random images
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

    // GET /breed/hound/images - returns all hound images
    public static Response GetHoundImagesResponse() {
            return RestAssured.given()
                    .baseUri(DogBaseURL2)
                    .basePath("/hound/images")
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .log().all()
                    .get()
                    .then()
                    .extract().response();
        }


        // GET /breed/hound/images/random - random hound image
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

    // GET /breed/hound/images/random/3 - three random hound images
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

    // GET /breed/hound/list - list of hound sub-breeds
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

    // GET /breed/hound/afghan/images - images for Afghan hound
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

    // GET /breed/hound/afghan/images/random - random Afghan hound image
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

    // GET /breed/hound/afghan/images/random/3 - three random Afghan hound images
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
