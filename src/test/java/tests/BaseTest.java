package tests;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.ScreenShooter;
import com.google.common.io.Files;
import common.DriverConfig;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.*;
import webdriver.DriverHelper;
import java.io.File;
import java.io.IOException;


@Slf4j
@Listeners({ ScreenShooter.class})
abstract public class BaseTest {

    // получение свойств из класса DriverConfig
    private static DriverConfig getDriverConfig() {
        return ConfigFactory.newInstance().create(DriverConfig.class, System.getProperties());
    }

    @Parameters({"browserName"})
    @BeforeClass
    public void setUp(@Optional("chrome") String browserName) {
        DriverHelper.configureDriver(browserName);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        ScreenShooter.captureSuccessfulTests = Boolean.parseBoolean(getDriverConfig().captureSuccessfulTests());
    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
        SelenideLogger.removeListener("AllureSelenide");
        log.info("Browser stop");
    }

    // Для прикрепления скриншота к шагу в отчет allure
    @Attachment(type = "image/png")
    public byte[] takeScreenshot() throws IOException {
        File screenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }
}
