package PayloadBuilder;

import Common.TestDataGenerator;
import org.json.simple.JSONObject;

public class NdosiAPIPayLoadBuilder {

    public static JSONObject SuccessfulRegistrationBody() {
        JSONObject User = new JSONObject();
        User.put("firstName", TestDataGenerator.firstName);
        User.put("lastName", TestDataGenerator.lastName);
        // use the stable generated email so login can reuse it
        User.put("email", TestDataGenerator.email);
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
        // reuse the same generated credentials used during registration
        User.put("email", TestDataGenerator.email);
        User.put("password", TestDataGenerator.password);
        return User;
    }

    //User Profile section
    public static JSONObject UpdateUserProfileBody() {
        JSONObject User = new JSONObject();
        User.put("firstName", TestDataGenerator.firstName);
        User.put("lastName", TestDataGenerator.lastName);
        User.put("email", TestDataGenerator.email);
        return User;
    }
    public static JSONObject UpdateUserProfilepasswordBody() {
        JSONObject User = new JSONObject();
        User.put("current_password", TestDataGenerator.password);
        User.put("new_password", TestDataGenerator.updatedPassword);
        return User;
    }

    public static JSONObject CreateTestimonialBody() {
        JSONObject User = new JSONObject();
        User.put("title", "Great Service!");
        User.put("content", "This is my testimonial content describing the excellent service I received.");
        User.put("rating", "5"); // Mismatched password
        User.put("isPublic", "true");
        return User;
    }

    public static JSONObject UpdateTestimonialBody() {
        JSONObject User = new JSONObject();
        User.put("title", "Great Service!");
        User.put("content", "This is my updated testimonial content describing the excellent service I received.");
        User.put("rating", "5"); // Mismatched password
        User.put("isPublic", "true");
        return User;
    }






}
