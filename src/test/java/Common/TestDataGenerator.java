package Common;

import com.github.javafaker.Faker;

import java.util.Locale;

// Test data generator: names, email, and passwords for tests
public class TestDataGenerator {

    // Faker (Locale.US)
    private static final Faker faker = new Faker(Locale.US);

    // Generated names
    public static final String firstName = faker.name().firstName();
    public static final String lastName = faker.name().lastName();

    // Email from names
    public static final String email = generateEmail(firstName, lastName);

    // Passwords
    public static final String updatedPassword = faker.internet().password(10, 20, true, true);
    public static final String password = faker.internet().password(8, 16, true, true);

    // Confirmation password (same as password)
    public static final String confirmPassword = password;

    // Build email local@domain
    private static String generateEmail(String first, String last) {
        String local = (first + "." + last).toLowerCase().replaceAll("\\s+", "");
        String domain = faker.internet().domainName();
        return local + "@" + domain;
    }

}
