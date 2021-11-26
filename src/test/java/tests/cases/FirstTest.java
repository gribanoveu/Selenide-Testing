package tests.cases;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.testng.annotations.Test;
import pages.SwagLabsCatalogPage;
import pages.SwagLabsLoginPage;
import pages.SwagLabsShoppingCardPage;
import tests.BaseTest;
import tests.data.TestDataClass;

public class FirstTest extends BaseTest {

    @Test(dataProvider = "test-data-users", dataProviderClass = TestDataClass.class)
    public void catalogHave6Product(String userName, String userPassword) {
        SwagLabsLoginPage.login(userName,userPassword);
        SwagLabsCatalogPage.inventoryItemLabel.shouldHave(CollectionCondition.sizeGreaterThanOrEqual(6));
    }

    @Attachment
    @Test(dataProvider = "test-data-users", dataProviderClass = TestDataClass.class)
    public void addTshirtToShoppingCard(String userName, String userPassword) {
        SwagLabsLoginPage.login(userName, userPassword);
        SwagLabsCatalogPage.addTshirtAndBackpackToShoppingCard();
        SwagLabsCatalogPage.openShoppingCard();
        Selenide.screenshot("card");
        SwagLabsShoppingCardPage.cardItems.shouldHave(CollectionCondition.size(2));

    }
}
