package webdriver;

import com.codeborne.selenide.Configuration;
import common.DriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

@Slf4j
public class DriverHelper  {

    // получение свойств из класса DriverConfig
    private static DriverConfig getDriverConfig() {
        return ConfigFactory.newInstance().create(DriverConfig.class, System.getProperties());
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
    }

}
