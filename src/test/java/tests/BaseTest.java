package tests;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import webdriver.DriverHelper;

import java.io.File;
import java.io.IOException;


@Slf4j
abstract public class BaseTest {

    @Parameters({"browserName"})
    @Description("ЗАПУСК БРАУЗЕРА")
    @BeforeClass
    public void setUp(@Optional("chrome") String browserName) {
        DriverHelper.configureDriver(browserName);
    }

    @Description("ЗАКРЫТИЕ БРАУЗЕРА")
    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
        log.info("Browser stop");
    }

    @Attachment(type = "image/png")
    public byte[] takeScreenshot() throws IOException {
        File screenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }
}
