package gowoTests.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import gowoTests.TestBase;
import gowoTests.helpers.faker.FakeData;
import gowoTests.pages.LoginForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AuthUiNegativeTest extends TestBase {

    private static LoginForm loginForm = new LoginForm();

    static Stream<Arguments> authNegativeTest() {
        return Stream.of(
                Arguments.of(FakeData.fakeUser, FakeData.fakePassword, loginForm.getWrongUserALertText()),
                Arguments.of(config.getUsername(), FakeData.fakePassword, loginForm.getWrongPasswordAletText()),
                Arguments.of("", FakeData.fakePassword, loginForm.getEmptyFieldAlertText()),
                Arguments.of(config.getUsername(), "", loginForm.getEmptyFieldAlertText()),
                Arguments.of("", "", loginForm.getEmptyFieldAlertText())
        );
    }

    @DisplayName("Негативные тесты на авторизацию")
    @MethodSource()
    @ParameterizedTest(name = "name {0}, pass {1}, {2}")
    void authNegativeTest(String username, String password, String alertExpectedText) {
        Selenide.open("/");
        loginForm.doLogin(username, password);
        String alertActualText = Selenide.switchTo().alert().getText();
        Selenide.confirm();
        loginForm.getCloseModalButton();
        Assertions.assertEquals(alertExpectedText, alertActualText);
        loginForm.getLoginButtonLocator().shouldBe(Condition.visible);
        loginForm.getNameOfUserLink().shouldNotBe(Condition.visible);
    }
}