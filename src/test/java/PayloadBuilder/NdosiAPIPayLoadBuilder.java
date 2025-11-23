package PayloadBuilder;

import Common.TestDataGenerator;
import org.json.simple.JSONObject;

public class NdosiAPIPayLoadBuilder {

    public static JSONObject SuccessfulRegistrationBody() {
        JSONObject User = new JSONObject();
        User.put("firstName", TestDataGenerator.firstName);
        User.put("lastName", TestDataGenerator.lastName);
        User.put("email",TestDataGenerator.randomEmail());
        User.put("password", TestDataGenerator.password);
        User.put("confirmPassword", TestDataGenerator.password);
        return User;


    }
    public static JSONObject ExistingUserBody() {
        JSONObject User = new JSONObject();
        User.put("firstName", "John");
        User.put("lastName", "Doe");
        User.put("email","john.doe@example.com");
        User.put("password", "SecurePass123!");
        User.put("confirmPassword", "SecurePass123!");
        return User;

    }
    public static JSONObject FieldsRequiredBody() {
        JSONObject User = new JSONObject();
        return User;

    }
    //Swagger has user name and password fields for login which is wrong
    public static JSONObject LoginUserSuccessfulBody() {
        JSONObject User = new JSONObject();
        User.put("email","Amaa.doe@example.com");
        User.put("password", "SecurePass123!");
        return User;
    }



}
