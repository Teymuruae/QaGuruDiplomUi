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
    protected final String authCookieName = "ssr_token";

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
        AuthResponse response =
                RestAssured
                        .given()
                        .body(body)
                        .when()
                        .post()
                        .then().log().all()
                        .extract().as(AuthResponse.class);
        return response.getData().getToken().replace(" ", "%20");
    }

    @Test
    void test(){
//        String s = authWithApi(config.getLogin(),config.getPassword());
        String a = "Basic%MTA";
        String s = a.replace("%","%20");
        System.out.println(s);
    }
}
