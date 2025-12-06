package Tests;


import RequestBuilder.DogAPIRequestBuilder;
import org.testng.annotations.Test;

public class DogAPITest {

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
    @Test
    public void GetRandomDogImageAPITest() {
        DogAPIRequestBuilder.GetRandomDogImageResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(org.hamcrest.Matchers.containsString("application/json"));
    }
    @Test
    public void GetThreeRandomDogImagesAPITest() {
        DogAPIRequestBuilder.GetThreeRandomDogImagesResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(org.hamcrest.Matchers.containsString("application/json"));
    }

    @Test //(dependsOnMethods = "GetThreeRandomDogImagesAPITest")
    public void GetHoundImagesAPITest() {
        DogAPIRequestBuilder.GetHoundImagesResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(org.hamcrest.Matchers.containsString("application/json"));
    }

   @Test
    public void GetRandomHoundImageAPITest() {
        DogAPIRequestBuilder.GetRandomHoundImageResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(org.hamcrest.Matchers.containsString("application/json"));
    }

    @Test
    public void GetThreeRandomHoundImagesAPITest() {
        DogAPIRequestBuilder.GetThreeRandomHoundImagesResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(org.hamcrest.Matchers.containsString("application/json"));
    }
    @Test
    public void GetHoundListAPITest() {
        DogAPIRequestBuilder.GetHoundListResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(org.hamcrest.Matchers.containsString("application/json"));
    }

    @Test
    public void GetAfghanImagesAPITest() {
        DogAPIRequestBuilder.GetAfghanImagesResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(org.hamcrest.Matchers.containsString("application/json"));
    }

    @Test
    public void GetRandomAfghanImageAPITest() {
        DogAPIRequestBuilder.GetRandomAfghanImageResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(org.hamcrest.Matchers.containsString("application/json"));
    }
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
