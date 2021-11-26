package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.io.Files;
import common.MainConfig;
import io.qameta.allure.Attachment;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import webdriver.DriverFactory;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;


@Slf4j
abstract public class BaseTest {

    protected static MainConfig config = ConfigFactory.create(MainConfig.class);
    static String screenshotsFolder = config.allure_screenshots_folder();

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        WebDriverRunner.setWebDriver(DriverFactory.getDriver(browser.toLowerCase()));
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.reportsFolder = screenshotsFolder;
        log.info("Start browser: " + browser);
    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
        log.info("Browser stop");
    }

    @Attachment(type = "image/png")
    private byte[] screenshot() {
        File file = Screenshots.takeScreenShotAsFile();
        try {
            BufferedImage image = ImageIO.read(file);
            ByteArrayOutputStream arrayOs = new ByteArrayOutputStream();
            BufferedOutputStream os = new BufferedOutputStream(arrayOs);
            image.flush();
            ImageIO.write(image, "png", os);
            return arrayOs.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
