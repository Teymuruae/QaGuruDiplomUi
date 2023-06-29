package gowoTests.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:data.properties"
})
public interface AuthConfings extends Config {
    @Key("login")
    String getLogin();
    @Key("password")
    String getPassword();
    @Key("apiAuthPath")
    String getApiAuthPath();

    @Key("baseUrl")
    String getBaseUrl();
}
