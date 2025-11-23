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


public class WeatherAPIRequestBuilder {

    static String weatherStationId;

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
