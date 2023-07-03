package gowoTests.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import gowoTests.TestBase;
import gowoTests.pages.LoginForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthUiPositiveTest extends TestBase {

    private LoginForm loginForm = new LoginForm();

    @DisplayName("Позитивный тест на авторизацию ui")
    @Test
    void authPositiveTest() {
        Selenide.open("/");
        loginForm.doLogin(config.getUsername(), config.getPassword());
        loginForm.getNameOfUserLink().shouldBe(Condition.visible);
        loginForm.getLoginButtonLocator().shouldNotBe(Condition.visible);
    }
}
