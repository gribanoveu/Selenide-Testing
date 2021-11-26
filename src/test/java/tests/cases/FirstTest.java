package tests.cases;

import com.codeborne.selenide.CollectionCondition;
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

    @Test(dataProvider = "test-data-users", dataProviderClass = TestDataClass.class)
    public void addTshirtToShoppingCard(String userName, String userPassword) {
        SwagLabsLoginPage.login(userName, userPassword);
        SwagLabsCatalogPage.addTshirtAndBackpackToShoppingCard();
        SwagLabsCatalogPage.openShoppingCard();
        SwagLabsShoppingCardPage.cardItems.shouldHave(CollectionCondition.size(2));
    }
}
