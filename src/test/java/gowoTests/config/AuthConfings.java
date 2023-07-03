package gowoTests.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties"
})
public interface AuthConfings extends Config {
    @Key("token")
    String getToken();
    @Key("apiAuthUrl")
    String getApiAuthUrl();
    @Key("baseUrl")
    String getBaseUrl();

    @Key("username")
    String getUsername();

    @Key("password")
    String getPassword();
}
