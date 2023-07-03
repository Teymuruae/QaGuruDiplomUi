package gowoTests.helpers.faker;

import com.github.javafaker.Faker;

public class FakeData {
    private static Faker faker = new Faker();
    public static String
            fakeUser = faker.name().name() + "#%@&&%$#",
            fakePassword = faker.internet().password(10, 15);
}
