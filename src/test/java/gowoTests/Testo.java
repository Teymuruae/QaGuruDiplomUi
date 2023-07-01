package gowoTests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import gowoTests.api.ApiHelpMethods;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;

public class Testo extends TestBase {
    private ApiHelpMethods apiHelpMethods = new ApiHelpMethods();

    @Test
    void test() {



//        String token = apiHelpMethods.authWithApi(config.getLogin(),config.getPassword());
//        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("token", token));
//        Selenide.open("https://gowo.su/");
//        $("img[alt=\"search_site\"]").click();
//        $("input[id=\"search-input\"]").setValue("Акула").pressEnter();
//        int a = 4;
    }

    @Test
    void t() {
login.doLoginInUiUsingApi(config.getLogin(),config.getPassword());
int a = 5;

    }

}
