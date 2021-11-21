package tests;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void Test1() throws InterruptedException {
        Selenide.open("https://www.google.ru/");
        Thread.sleep(2000);
    }
}
