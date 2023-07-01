package gowoTests.helpers.forAuth;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import gowoTests.api.ApiHelpMethods;
import org.openqa.selenium.Cookie;

public class Login extends ApiHelpMethods {
    private static String
            simplePath = "/ssrdist/assets/icons/favicon-32x32.png";

    public  void doLoginInUiUsingApi(String login, String password){
        String tokenValue = authWithApi(login,password);
        Selenide.open("/");
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie(authCookieName, tokenValue));
        Selenide.open("/");
    }
}
