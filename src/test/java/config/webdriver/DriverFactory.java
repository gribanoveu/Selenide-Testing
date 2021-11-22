package config.webdriver;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Browsers.*;

@Slf4j
public class DriverFactory {

    public static WebDriver getDriver(String browser) {
        switch (browser) {
            case CHROME:
                log.info("Драйвер для браузера Google Chrome");
                return ChromeDriverCustom.getChromeDriver();
            case FIREFOX:
                log.info("Драйвер для браузера Mozilla Firefox");
                return FirefoxDriverCustom.getFirefoxDriver();
            case EDGE:
                log.info("Драйвер для браузера Microsoft Edge");
                return EdgeDriverCustom.getEdgeDriver();
            default:
                throw new RuntimeException("Некорректное имя браузера");
        }

    }
}
