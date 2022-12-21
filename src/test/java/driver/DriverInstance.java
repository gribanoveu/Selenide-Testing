package driver;

import com.codeborne.selenide.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
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

        if(Boolean.parseBoolean(getDriverConfig().runSeleniumGrid())) {
            log.info("Запуск Selenium Grid");
            runSeleniumGrid();
        }
    }

    private static void runSelenoid() {
        Configuration.remote = getDriverConfig().selenoidRemoteUrl();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    private static void runSeleniumGrid() {
        Configuration.remote = getDriverConfig().selenoidRemoteUrl();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--incognito");
        capabilities.setBrowserName("chrome");
        Configuration.browserCapabilities = capabilities;
    }
}
