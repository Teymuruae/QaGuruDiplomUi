package gowoTests.config;

import org.aeonbits.owner.Config;
@Config.Sources({
        "classpath:remote.properties"
})
public interface RemoteConfig extends Config {

    @Key("remoteUser")
    String getUser();

    @Key("remotePass")
    String getPass();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("browser")
    String getBrowser();
}
