package config.webdriver;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Browsers.CHROME;

@Slf4j
public class DriverFactory {

    public static WebDriver getDriver(String browser) {
        switch (browser) {
            case CHROME:
                log.info("Драйвер для браузера Google Chrome");
                return ChromeDriverCustom.getChromeDriver();
            default:
                throw new RuntimeException("Некорректное имя браузера");
        }

    }
}
