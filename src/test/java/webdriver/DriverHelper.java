package webdriver;

import com.codeborne.selenide.Configuration;
import common.DriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

@Slf4j
public class DriverHelper {

    private static DriverConfig getDriverConfig() {
        return ConfigFactory.newInstance().create(DriverConfig.class, System.getProperties());
    }

    public static void configureDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = getDriverConfig().webBrowser();
        Configuration.driverManagerEnabled = true;
        Configuration.reportsFolder = getDriverConfig().allureScreenshotsFolder();
        Configuration.browserSize = getDriverConfig().browserSize();
        Configuration.headless = Boolean.parseBoolean(getDriverConfig().headlessMode());
        log.info("Start browser: " + getDriverConfig().webBrowser());
    }
}
