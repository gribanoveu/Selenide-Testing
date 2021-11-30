package common;

import org.aeonbits.owner.Config;

@Config.Sources({ "file:src/test/resources/configs/DriverConfig.properties" })
public interface DriverConfig extends Config {

    @Key("reportsFolder")
    String reportsFolder();

    @Key("browserSize")
    String browserSize();

    @Key("headless")
    String headlessMode();

    @Key("captureSuccessfulTests")
    String captureSuccessfulTests();

    @Key("remoteUrl")
    String selenoidRemoteUrl();

    @Key("runSelenoid")
    String runSelenoid();
}
