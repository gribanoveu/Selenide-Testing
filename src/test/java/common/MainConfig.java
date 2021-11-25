package common;
import org.aeonbits.owner.Config;

@Config.Sources({ "file:src/test/resources/MainConfig.properties" })
public interface MainConfig extends Config {
    String allure_screenshots_folder();
}
