package gowoTests.api;

import gowoTests.api.pojo.AuthRequest;
import gowoTests.config.AuthConfings;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigFactory;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class ApiHelpMethods {
    private AuthConfings config = ConfigFactory.create(AuthConfings.class, System.getProperties());

    /**
     * метод  получения токена авторизации через апи.
     * На вход передаются логин и пароль
     *
     * @param login
     * @param password
     * @return
     */
    public String authWithApi(String login, String password) {
        Spec.install(config.getApiAuthPath(), HttpStatus.SC_OK);
        AuthRequest body = new AuthRequest(login, password);
        return
                RestAssured
                        .given()
                        .body(body)
                        .when()
                        .post()
                        .then().log().all()
                        .extract().path("data.token");
    }
}
