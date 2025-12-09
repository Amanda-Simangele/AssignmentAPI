package RequestBuilder;

import Common.Authorisations;
import Common.BasePaths;
import PayloadBuilder.WeatherAPIPayLoadBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static Common.Authorisations.OPEN_WEATHER_API_KEY;
import static Common.BasePaths.openWeatherBaseUrl;
import static Common.BasePaths.openWeatherPath;


// Simple request builder for OpenWeather station endpoints.
@SuppressWarnings("unused") // some helper methods are kept for tests (may not be referenced directly)
public class WeatherAPIRequestBuilder {

    // stored ID for created weather station
    static String weatherStationId;

    // POST to create a weather station and capture its ID
    public static Response CreateWeatherAPIResponse(){

        Response response = RestAssured.given()
                .baseUri(openWeatherBaseUrl)
                .basePath(openWeatherPath)
                .queryParam("appid", OPEN_WEATHER_API_KEY)
                .contentType(ContentType.JSON)
                .log().all()
                .body(WeatherAPIPayLoadBuilder.createOpenWeatherBody())
                .post()
                .then()
                .extract().response();

        weatherStationId = response.jsonPath().getString("ID");
        return response;

    }
    // GET a single station by stored ID
    public static Response GetWeatherAPIResponse(){
        return RestAssured.given()
                .baseUri(openWeatherBaseUrl)
                .basePath(openWeatherPath +"/"+ weatherStationId)
                .queryParam("appid", OPEN_WEATHER_API_KEY)
                .log().all()
                .get()
                .then()
                .extract().response();

    }
    // GET all weather stations
    public static Response GetAllstationsWeatherAPIResponse(){
        return RestAssured.given()
                .baseUri(openWeatherBaseUrl)
                .basePath(openWeatherPath)
                .queryParam("appid", OPEN_WEATHER_API_KEY)
                .log().all()
                .get()
                .then()
                .extract().response();

    }
    // PUT to update the stored weather station
    public static Response UpdateWeatherAPIResponse(){

      return  RestAssured.given()
                .baseUri(openWeatherBaseUrl)
                .basePath(openWeatherPath +"/"+ weatherStationId)
                .queryParam("appid", OPEN_WEATHER_API_KEY)
                .contentType(ContentType.JSON)
                .log().all()
                .body(WeatherAPIPayLoadBuilder.updateOpenWeatherBody())
                .put()
                .then()
                .extract().response();

    }
    // DELETE the stored weather station
    public static Response DeleteWeatherStationResponse(){

        return RestAssured.given()
                .baseUri(openWeatherBaseUrl)
                .basePath(openWeatherPath +"/"+ weatherStationId)
                .queryParam("appid", OPEN_WEATHER_API_KEY)
                .log().all()
                .delete()
                .then()
                .extract().response();

    }
    // DELETE the station again (simulate already-deleted)
    @SuppressWarnings("unused") // kept for idempotency testing
    public static Response DeleteAlreadyDeletedWeatherStationResponse(){

        return RestAssured.given()
                .baseUri(openWeatherBaseUrl)
                .basePath(openWeatherPath +"/"+ weatherStationId)
                .queryParam("appid", OPEN_WEATHER_API_KEY)
                .log().all()
                .delete()
                .then()
                .extract().response();

    }
    // POST with missing required fields to trigger validation
    public static Response createMissingRequiredWeatherAPIResponse(){

        Response response = RestAssured.given()
                .baseUri(openWeatherBaseUrl)
                .basePath(openWeatherPath)
                .queryParam("appid", OPEN_WEATHER_API_KEY)
                .contentType(ContentType.JSON)
                .log().all()
                .body(WeatherAPIPayLoadBuilder.createMissingRequiredOpenWeatherBody())
                .post()
                .then()
                .extract().response();

        weatherStationId = response.jsonPath().getString("ID");
        return response;

    }
   /* public static Response createWeatherWithExistingExternalIdResponse(){

        Response response = RestAssured.given()
                .baseUri(openWeatherBaseUrl)
                .basePath(openWeatherPath)
                .queryParam("appid", OPEN_WEATHER_API_KEY)
                .contentType(ContentType.JSON)
                .log().all()
                .body(WeatherAPIPayLoadBuilder.createWeatherWithExistingExternalIdBody())
                .post()
                .then()
                .extract().response();

        weatherStationId = response.jsonPath().getString("ID");
        return response;

    }*/





}
