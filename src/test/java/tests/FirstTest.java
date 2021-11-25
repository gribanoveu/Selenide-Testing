package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.testng.annotations.Test;
import pages.SwagLabsCatalogPage;
import pages.SwagLabsLoginPage;
import pages.SwagLabsShoppingCardPage;

public class FirstTest extends BaseTest {

    @Test(dataProvider = "test-data-users", dataProviderClass = TestDataClass.class)
    public void catalogHave6Product(String userName, String userPassword) {
        SwagLabsLoginPage.login(userName,userPassword);
        SwagLabsCatalogPage.inventoryItemLabel.shouldHave(CollectionCondition.sizeGreaterThanOrEqual(6));
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    @Test(dataProvider = "test-data-users", dataProviderClass = TestDataClass.class)
    public void addTshirtToShoppingCard(String userName, String userPassword) {
        SwagLabsLoginPage.login(userName, userPassword);
        Selenide.screenshot("sda");
        SwagLabsCatalogPage.addTshirtAndBackpackToShoppingCard();
        SwagLabsCatalogPage.openShoppingCard();
        SwagLabsShoppingCardPage.cardItems.shouldHave(CollectionCondition.size(2));

    }
}
