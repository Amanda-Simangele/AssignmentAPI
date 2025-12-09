package Tests;


import RequestBuilder.DogAPIRequestBuilder;
import org.testng.annotations.Test;

public class DogAPITest {

    // Test to verify the API response for retrieving a list of all dog breeds
    @Test
    public void GetListOfDogsAPITest() {
        DogAPIRequestBuilder.GetListOfDogsAPIResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .contentType(org.hamcrest.Matchers.containsString("application/json"));

    }

    // Test to verify the API response for retrieving a random dog image
    @Test
    public void GetRandomDogImageAPITest() {
        DogAPIRequestBuilder.GetRandomDogImageResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(org.hamcrest.Matchers.containsString("application/json"));
    }

    // Test to verify the API response for retrieving three random dog images
    @Test
    public void GetThreeRandomDogImagesAPITest() {
        DogAPIRequestBuilder.GetThreeRandomDogImagesResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(org.hamcrest.Matchers.containsString("application/json"));
    }

    // Test to verify the API response for retrieving images of hounds
    @Test //(dependsOnMethods = "GetThreeRandomDogImagesAPITest")
    public void GetHoundImagesAPITest() {
        DogAPIRequestBuilder.GetHoundImagesResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(org.hamcrest.Matchers.containsString("application/json"));
    }

    // Test to verify the API response for retrieving a random image of a hound
    @Test
    public void GetRandomHoundImageAPITest() {
        DogAPIRequestBuilder.GetRandomHoundImageResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(org.hamcrest.Matchers.containsString("application/json"));
    }

    // Test to verify the API response for retrieving three random images of hounds
    @Test
    public void GetThreeRandomHoundImagesAPITest() {
        DogAPIRequestBuilder.GetThreeRandomHoundImagesResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(org.hamcrest.Matchers.containsString("application/json"));
    }

    // Test to verify the API response for retrieving a list of hound breeds
    @Test
    public void GetHoundListAPITest() {
        DogAPIRequestBuilder.GetHoundListResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(org.hamcrest.Matchers.containsString("application/json"));
    }

    // Test to verify the API response for retrieving images of Afghan hounds
    @Test
    public void GetAfghanImagesAPITest() {
        DogAPIRequestBuilder.GetAfghanImagesResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(org.hamcrest.Matchers.containsString("application/json"));
    }

    // Test to verify the API response for retrieving a random image of an Afghan hound
    @Test
    public void GetRandomAfghanImageAPITest() {
        DogAPIRequestBuilder.GetRandomAfghanImageResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(org.hamcrest.Matchers.containsString("application/json"));
    }

    // Test to verify the API response for retrieving three random images of Afghan hounds
    @Test
    public void GetThreeRandomAfghanImagesAPITest() {
        DogAPIRequestBuilder.GetThreeRandomAfghanImagesResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(org.hamcrest.Matchers.containsString("application/json"));
    }

}
