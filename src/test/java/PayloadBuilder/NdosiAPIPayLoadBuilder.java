package PayloadBuilder;

import Common.TestDataGenerator;
import org.json.simple.JSONObject;

// Payload builders for Ndosi API (registration, login, profile, testimonials)
public class NdosiAPIPayLoadBuilder {

    // Registration payload
    public static JSONObject SuccessfulRegistrationBody() {
        JSONObject User = new JSONObject();
        User.put("firstName", TestDataGenerator.firstName);
        User.put("lastName", TestDataGenerator.lastName);
        // stable email for reuse
        User.put("email", TestDataGenerator.email);
        User.put("password", TestDataGenerator.password);
        User.put("confirmPassword", TestDataGenerator.password);
        return User;
    }

    // Existing user payload (negative test)
    public static JSONObject ExistingUserBody() {
        JSONObject User = new JSONObject();
        User.put("firstName", "John");
        User.put("lastName", "Doe");
        User.put("email","john.doe@example.com");
        User.put("password", "SecurePass123!");
        User.put("confirmPassword", "SecurePass123!");
        return User;
    }

    // Empty payload to trigger validation errors
    public static JSONObject FieldsRequiredBody() {
        JSONObject User = new JSONObject();
        return User;
    }

    // Login payload (use email + password)
    public static JSONObject LoginUserSuccessfulBody() {
        JSONObject User = new JSONObject();
        User.put("email", TestDataGenerator.email);
        User.put("password", TestDataGenerator.password);
        return User;
    }

    // Update profile payload
    public static JSONObject UpdateUserProfileBody() {
        JSONObject User = new JSONObject();
        User.put("firstName", TestDataGenerator.firstName);
        User.put("lastName", TestDataGenerator.lastName);
        User.put("email", TestDataGenerator.email);
        return User;
    }

    // Change password payload
    public static JSONObject UpdateUserProfilepasswordBody() {
        JSONObject User = new JSONObject();
        User.put("current_password", TestDataGenerator.password);
        User.put("new_password", TestDataGenerator.updatedPassword);
        return User;
    }

    // Create testimonial payload
    public static JSONObject CreateTestimonialBody() {
        JSONObject User = new JSONObject();
        User.put("title", "Great Service!");
        User.put("content", "This is my testimonial content describing the excellent service I received.");
        User.put("rating", "5"); // rating as string
        User.put("isPublic", "true");
        return User;
    }

    // Update testimonial payload
    public static JSONObject UpdateTestimonialBody() {
        JSONObject User = new JSONObject();
        User.put("title", "Great Service!");
        User.put("content", "This is my updated testimonial content describing the excellent service I received.");
        User.put("rating", "5");
        User.put("isPublic", "true");
        return User;
    }

}
