package gowoTests.api;

import gowoTests.api.pojo.requests.AuthRequest;
import gowoTests.api.pojo.responses.AuthResponse;
import gowoTests.config.AuthConfings;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class ApiHelpMethods {
    protected AuthConfings config = ConfigFactory.create(AuthConfings.class, System.getProperties());
    protected final String authCookieName = "tokenp_";

    /**
     * метод  получения токена авторизации через апи.
     * На вход передаются логин и пароль
     *
     * @param token
     * @return
     */
    public String authWithApi(String token) {
        Spec.install(config.getApiAuthUrl(), HttpStatus.SC_OK);
        AuthRequest body = new AuthRequest(token);
        AuthResponse response =
                RestAssured
                        .given()
                        .body(body)
                        .when()
                        .post()
                        .then().log().all()
                        .extract().as(AuthResponse.class);
        return response.getItem().getToken();
    }

    @Test
    void test() {
        String s = authWithApi(config.getToken());
        System.out.println(s);
    }
}
