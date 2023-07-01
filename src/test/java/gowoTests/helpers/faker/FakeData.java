package gowoTests.helpers.faker;

import com.github.javafaker.Faker;

public class FakeData {
    private static Faker faker = new Faker();
    public static String
            fakeEmail = faker.internet().emailAddress(),
            fakePassword = faker.internet().password(6, 10);
}
