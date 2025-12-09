package Tests;

import RequestBuilder.WeatherAPIRequestBuilder;
import org.testng.annotations.Test;

// Test class for verifying Weather API functionality
public class WeatherTest {

    // Test to create a new weather station
    @Test
    public void createOpenWeather() {
        WeatherAPIRequestBuilder.CreateWeatherAPIResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(201)
                .contentType("application/json; charset=utf-8");
    }

    // Test to retrieve the created weather station
    @Test (dependsOnMethods = "createOpenWeather")
    public void getCreatedWeather() {
        WeatherAPIRequestBuilder.GetWeatherAPIResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }

    // Test to retrieve all weather stations
    @Test (dependsOnMethods = "getCreatedWeather")
    public void getAllStationsWeather() {
        WeatherAPIRequestBuilder.GetAllstationsWeatherAPIResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }

    // Test to update the weather station
    @Test (dependsOnMethods = "getAllStationsWeather")
    public void updateWeather() {
        WeatherAPIRequestBuilder.UpdateWeatherAPIResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");
    }

    // Test to delete the weather station
    @Test (dependsOnMethods = "updateWeather")
    public void deleteWeather() {
        WeatherAPIRequestBuilder.DeleteWeatherStationResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(204);
    }

    // Test to delete an already deleted weather station
    @Test (dependsOnMethods = "deleteWeather")
    public void deleteAlreadydeletedWeather() {
        WeatherAPIRequestBuilder.DeleteWeatherStationResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(404);
    }

    // Test to create a weather station with missing required fields
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
