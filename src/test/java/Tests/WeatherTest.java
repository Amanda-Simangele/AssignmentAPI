package Tests;

import RequestBuilder.WeatherAPIRequestBuilder;
import org.testng.annotations.Test;

public class WeatherTest {

    @Test
    public void createOpenWeather() {
        WeatherAPIRequestBuilder.CreateWeatherAPIResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(201)
                .contentType("application/json; charset=utf-8");

    }
    @Test (dependsOnMethods = "createOpenWeather")
    public void getCreatedWeather() {
        WeatherAPIRequestBuilder.GetWeatherAPIResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }
    @Test (dependsOnMethods = "getCreatedWeather")
    public void getAllStationsWeather() {
        WeatherAPIRequestBuilder.GetAllstationsWeatherAPIResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }
    @Test (dependsOnMethods = "getAllStationsWeather")
    public void updateWeather() {
        WeatherAPIRequestBuilder.UpdateWeatherAPIResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }
    @Test (dependsOnMethods = "updateWeather")
    public void deleteWeather() {
        WeatherAPIRequestBuilder.DeleteWeatherStationResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(204);
    }
    @Test (dependsOnMethods = "deleteWeather")
    public void deleteAlreadydeletedWeather() {
        WeatherAPIRequestBuilder.DeleteWeatherStationResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(404);
    }
    @Test(dependsOnMethods = "deleteAlreadydeletedWeather")
    public void createMissingRequiredOpenWeather() {
        WeatherAPIRequestBuilder.createMissingRequiredWeatherAPIResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(400)
                .contentType("application/json; charset=utf-8");

    }


}
