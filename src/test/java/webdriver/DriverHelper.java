package webdriver;

import com.codeborne.selenide.Configuration;
import common.DriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;



@Slf4j
public class DriverHelper {

    // получение свойств из класса DriverConfig
    private static DriverConfig getDriverConfig() {
        return ConfigFactory.newInstance().create(DriverConfig.class, System.getProperties());
    }

    // вызов драйвера
    private static void getDriver(String browserName) {
        Configuration.browser = browserName;
    }

    // настройка драйвера
    public static void configureDriver(String browserName) {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        getDriver(browserName.toLowerCase());
        Configuration.driverManagerEnabled = true;
        Configuration.reportsFolder = getDriverConfig().reportsFolder();
        Configuration.browserSize = getDriverConfig().browserSize();
        Configuration.headless = Boolean.parseBoolean(getDriverConfig().headlessMode());
        log.info("Start browser: " + browserName);
    }

}
