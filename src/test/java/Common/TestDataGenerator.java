package Common;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDataGenerator {

    private static final Faker faker = new Faker(new Locale("en-US"));

    public static final String firstName = faker.name().firstName();
    public static final String lastName = faker.name().lastName();
    public static final String email = generateEmail(firstName, lastName);
    public static final String password = faker.internet().password(8, 16, true, true);
    public static final String confirmPassword = password;

    private static String generateEmail(String first, String last) {
        String local = (first + "." + last).toLowerCase().replaceAll("\\s+", "");
        String domain = faker.internet().domainName();
        return local + "@" + domain;
    }

    public static String randomEmail() {
        return faker.internet().emailAddress();
    }

    public static String randomPassword() {
        return faker.internet().password(8, 16, true, true);
    }

    // utility class - prevent instantiation
    private TestDataGenerator() { }

}
