package tests;

import org.testng.annotations.DataProvider;

public class TestDataClass {

    // логин:пароль для тестов
    @DataProvider(name = "test-data-users")
    public static Object[][] dataProvFunc(){
        return new Object[][]{
                {"standard_user","secret_sauce"}
        };
    }
}
