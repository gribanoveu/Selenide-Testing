package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.webdriver.DriverFactory;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@Slf4j
abstract public class BaseTest {

    String env = System.getProperty("browser", "chrome").toLowerCase();

    @BeforeClass
    public void setUp() {
        WebDriverRunner.setWebDriver(DriverFactory.getDriver(env));
        log.info("start");
    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
        log.info("stop");
    }

}
