package PayloadBuilder;

import org.json.simple.JSONObject;

public class WeatherAPIPayLoadBuilder {

    public static JSONObject createOpenWeatherBody(){
        JSONObject station = new JSONObject();
        station.put("external_id", "SF_TEST001");
        station.put("name", "Fourways Station");
        station.put("latitude", 37.76);
        station.put("longitude", -122.43);
        station.put("altitude", 150);
        return station;
    }

    public static JSONObject updateOpenWeatherBody(){
        JSONObject station = new JSONObject();
        station.put("external_id", "SF_UPD001");
        station.put("name", "Fourways Updated Station");
        station.put("latitude", 37.80);
        station.put("longitude", -122.47);
        station.put("altitude", 143);
        return station;
    }
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
