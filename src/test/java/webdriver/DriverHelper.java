package webdriver;

import com.codeborne.selenide.Configuration;
import common.DriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

@Slf4j
public class DriverHelper  {

    // получение свойств из класса DriverConfig
    private static DriverConfig getDriverConfig() {
        return ConfigFactory.newInstance().create(DriverConfig.class, System.getProperties());
    }

    private static void runSelenoid() {
        Configuration.remote = getDriverConfig().selenoidRemoteUrl();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    // настройка драйвера
    public static void configureDriver(String browserName) {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
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

}
