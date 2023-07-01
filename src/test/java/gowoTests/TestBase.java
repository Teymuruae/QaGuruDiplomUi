package gowoTests;

import com.codeborne.selenide.Configuration;
import gowoTests.config.AuthConfings;
import gowoTests.helpers.forAuth.Login;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    protected static AuthConfings config = ConfigFactory.create(AuthConfings.class, System.getProperties());
    protected Login login = new Login();
    protected void login(){
        login.doLoginInUiUsingApi(config.getLogin(), config.getPassword());
    }
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = config.getBaseUrl();
    }

    @BeforeEach
    public void setUp(){

    }

}
