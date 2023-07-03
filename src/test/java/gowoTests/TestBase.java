package gowoTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import gowoTests.config.AuthConfings;
import gowoTests.helpers.HelpMethods;
import gowoTests.helpers.forAuth.Login;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    protected static AuthConfings config = ConfigFactory.create(AuthConfings.class, System.getProperties());
    protected Login login = new Login();
    protected HelpMethods helpMethods = new HelpMethods();

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = config.getBaseUrl();
    }

    @BeforeEach
    public void setUp(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
