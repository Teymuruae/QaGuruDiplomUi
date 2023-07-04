package gowoTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import gowoTests.attaches.Attaches;
import gowoTests.config.AuthConfings;
import gowoTests.config.RemoteConfig;
import gowoTests.helpers.HelpMethods;
import gowoTests.helpers.forAuth.Login;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {
    protected static AuthConfings authConfings = ConfigFactory.create(AuthConfings.class, System.getProperties());
    protected static RemoteConfig remoteConfigs = ConfigFactory.create(RemoteConfig.class, System.getProperties());
    protected Login login = new Login();
    protected HelpMethods helpMethods = new HelpMethods();

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = authConfings.getBaseUrl();

        Configuration.remote = String.format("https://%s:%s@%s/wd/hub", remoteConfigs.getUser(),remoteConfigs.getPass(),
                remoteConfigs.getRemoteUrl());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    public void setUp(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void tearDown(){
        Attaches.attachScreenshot();
        Attaches.browserConsoleLogs();
        Attaches.addVideo();
        Selenide.closeWebDriver();
    }
}
