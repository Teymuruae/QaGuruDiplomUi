package gowoTests.tests.notApiAuthorized;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import gowoTests.TestBase;
import gowoTests.pages.EnterModalWindow;
import gowoTests.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class AuthUiTest extends TestBase {

    private EnterModalWindow enterModalWindow = new EnterModalWindow();
    private MainPage mainPage = new MainPage();

    @DisplayName("Позитивный тест на авторизацию через ui")
    @Test
    void positiveAuthUiTest() {
        Selenide.open("/");
        $(".frnd-header__auth_user").shouldNotBe(Condition.visible);
        mainPage
                .clickEnterLink()
                .fillUiLoginForm(config.getLogin(), config.getPassword());
        $(".frnd-header__auth_user").shouldBe(Condition.visible);
mainPage.getEnterLinkLocator().shouldNotBe(Condition.exist);
    }

}
