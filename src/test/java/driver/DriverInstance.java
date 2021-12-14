package driver;

import com.codeborne.selenide.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import util.DriverConfig;

@Slf4j
public class DriverInstance {

    // получение свойств из класса DriverConfig
    private static DriverConfig getDriverConfig() {
        return ConfigFactory.newInstance().create(DriverConfig.class, System.getProperties());
    }

    // настройка драйвера
    public static void configureDriver(String browserName) {
        Configuration.browser = browserName;
        Configuration.browserSize = getDriverConfig().browserSize();
        Configuration.driverManagerEnabled = true;
        Configuration.reportsFolder = getDriverConfig().reportsFolder();
        Configuration.headless = Boolean.parseBoolean(getDriverConfig().headlessMode());
        log.info("Запуск браузера: " + browserName);

        // запустить селеноид в докер контейнере если в конфигурации указано true
        if(Boolean.parseBoolean(getDriverConfig().runSelenoid())) {
            log.info("Запуск Selenoid");
            runSelenoid();
        }
    }

    private static void runSelenoid() {
        Configuration.remote = getDriverConfig().selenoidRemoteUrl();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }
}
