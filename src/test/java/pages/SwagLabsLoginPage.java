package pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Slf4j
public class SwagLabsLoginPage {

    private static final String URL = "https://www.saucedemo.com/";

    @Step("Логин")
    public static void login(String user, String password) {
        open(URL);
        log.info("Открыт URL: " + URL);

        $(By.id("user-name")).setValue(user);
        log.info("Введен логин в поле: " + user);

        $(By.id("password")).setValue(password);
        log.info("Введен пароль в поле: " + password);

        $(By.id("login-button")).click();
        log.info("Нажата клавиша Логин");
    }

}
