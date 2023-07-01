package gowoTests.tests.notauthorized;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import gowoTests.TestBase;
import gowoTests.pages.MainPage;
import org.junit.jupiter.api.Test;

public class AuthUiTest extends TestBase {

    private MainPage mainPage = new MainPage();
    @Test
    void positiveAuthUiTest(){
        Selenide.open();
        mainPage.doAuthUi(config.getLogin(), config.getPassword());
        mainPage.getAuthTabeTitle().shouldNotBe(Condition.exist);
        mainPage.getVipUsersTextLocator().shouldBe(Condition.visible);
    }

}
