package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SwagLabsLoginPage {

    private static final String URL = "https://www.saucedemo.com/";

    public static SelenideElement
            userNameField = $(By.id("user-name")),
            passwordField = $(By.id("password")),
            loginButton = $(By.id("login-button"));

    public static void login(String userName, String password) {
        open(URL);
        userNameField.setValue(userName);
        passwordField.setValue(password);
        loginButton.click();
    }

    public static void otherLogin(String user, String password) {
        open(URL);
        $(By.id("user-name")).setValue(user);
        $(By.id("password")).setValue(password);
        $(By.id("login-button")).click();
    }

}
