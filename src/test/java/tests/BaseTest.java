package tests;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterClass;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import webdriver.DriverHelper;


@Slf4j
abstract public class BaseTest {


    @BeforeClass
    public void setUp() {
        DriverHelper.configureDriver();
    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
        log.info("Browser stop");
    }
}
