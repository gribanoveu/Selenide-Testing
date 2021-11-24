package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import webdriver.DriverFactory;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;

@Slf4j
abstract public class BaseTest {

    // браузер указывается из тестового набора testng.xml
    // тестовые наборы по умолчанию прописаны в pom
    @Parameters({"browser"})
    @BeforeClass
    public void setUp(String browser) {
        WebDriverRunner.setWebDriver(DriverFactory.getDriver(browser.toLowerCase()));
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        log.info("Start browser: " + browser);
    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
        log.info("Browser stop");
    }

}
