package PayloadBuilder;

import org.json.simple.JSONObject;

// Payload builder for ReqRes API requests
public class ReqResPayLoadBuilder {

    // Method to create a user payload
    @SuppressWarnings("unchecked")
    public static JSONObject CreateUserBody(){
        JSONObject user = new JSONObject();
        user.put("name", "morpheus");
        user.put("job", "leader");
        return user;
    }

    // Method to create an updated user payload
    @SuppressWarnings("unchecked")
    public static JSONObject updateeUserBody(){
        JSONObject user = new JSONObject();
        user.put("name", "updatemorpheus");
        user.put("job", "updateleader");
        return user;
    }

    // Method to create a login payload
    @SuppressWarnings("unchecked")
    public static JSONObject loginBody(){
        JSONObject body = new JSONObject();
        body.put("email", "eve.holt@reqres.in");
        body.put("password", "cityslicka");
        return body;
    }

    // Method to create a registration payload
    @SuppressWarnings("unchecked")
    public static JSONObject registerBody(){
        JSONObject body = new JSONObject();
        body.put("email", "eve.holt@reqres.in");
        body.put("password", "cityslicka");
        return body;
    }




}
