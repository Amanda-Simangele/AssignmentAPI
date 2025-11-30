package PayloadBuilder;

import org.json.simple.JSONObject;

public class ReqResPayLoadBuilder {

    @SuppressWarnings("unchecked")
    public static JSONObject CreateUserBody(){
        JSONObject user = new JSONObject();
        user.put("name", "morpheus");
        user.put("job", "leader");
        return user;
    }

    @SuppressWarnings("unchecked")
    public static JSONObject updateeUserBody(){
        JSONObject user = new JSONObject();
        user.put("name", "updatemorpheus");
        user.put("job", "updateleader");
        return user;
    }

    // payload for /login
    @SuppressWarnings("unchecked")
    public static JSONObject loginBody(){
        JSONObject body = new JSONObject();
        body.put("email", "eve.holt@reqres.in");
        body.put("password", "cityslicka");
        return body;
    }

    // payload for /register
    // Ask why on swagger they also provided username field which is not used in reqres API(causes an error)
    @SuppressWarnings("unchecked")
    public static JSONObject registerBody(){
        JSONObject body = new JSONObject();
        body.put("email", "eve.holt@reqres.in");
        body.put("password", "cityslicka");
        return body;
    }




}
