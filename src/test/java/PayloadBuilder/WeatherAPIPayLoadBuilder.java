package PayloadBuilder;

import org.json.simple.JSONObject;

// Simple payload builder for OpenWeather station tests
// Provides JSON bodies for create, update, and invalid payload scenarios
public class WeatherAPIPayLoadBuilder {

    // Build payload to create a new weather station
    public static JSONObject createOpenWeatherBody(){
        JSONObject station = new JSONObject();
        station.put("external_id", "SF_TEST001");
        station.put("name", "Fourways Station");
        station.put("latitude", 37.76);
        station.put("longitude", -122.43);
        station.put("altitude", 150);
        return station;
    }

    // Build payload to update an existing weather station
    public static JSONObject updateOpenWeatherBody(){
        JSONObject station = new JSONObject();
        station.put("external_id", "SF_UPD001");
        station.put("name", "Fourways Updated Station");
        station.put("latitude", 37.80);
        station.put("longitude", -122.47);
        station.put("altitude", 143);
        return station;
    }

    // Build payload missing required fields to test validation errors
    public static JSONObject createMissingRequiredOpenWeatherBody(){
        JSONObject station = new JSONObject();
        station.put("external_id","ext station id");
        station.put("name","Fourways Updated Station");
        station.put("latitude",37.76);
        station.put("longitude",-122.43);
        station.put("altitude","");

        return station;
    }


}
