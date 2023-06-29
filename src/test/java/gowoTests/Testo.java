package gowoTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import gowoTests.api.ApiHelpMethods;
import gowoTests.api.pojo.AuthRequest;
import gowoTests.config.AuthConfings;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;

public class Testo {
    private ApiHelpMethods apiHelpMethods = new ApiHelpMethods();
    private AuthConfings config = ConfigFactory.create(AuthConfings.class, System.getProperties());
    @Test
    void test() {
        Configuration.pageLoadStrategy = "eager";
        Selenide.open("https://gowo.su/assets/images/burger.svg");
        String token = apiHelpMethods.authWithApi(config.getLogin(),config.getPassword());
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("token", token));
        Selenide.open("https://gowo.su/");
        $("img[alt=\"search_site\"]").click();
        $("input[id=\"search-input\"]").setValue("Акула").pressEnter();
        int a = 4;
    }

    @Test
    void t() {
//        String s = apiHelpMethods.authWithApi();
        System.out.println("vot token ==============================");
//        System.out.println(s);
    }

}
