package common;

import org.aeonbits.owner.Config;
import org.testng.annotations.Parameters;

@Config.Sources({ "file:src/test/resources/configs/DriverConfig.properties" })
public interface DriverConfig extends Config {


    // TODO: не передается браузер из кейса testng
    @Parameters("browsers")
    @Key("browser")
    String webBrowser();

    @Key("reportsFolder")
    String allureScreenshotsFolder();

    @Key("browserSize")
    String browserSize();

    @Key("headless")
    String headlessMode();
}
