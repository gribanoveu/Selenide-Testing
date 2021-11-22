package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import pages.SwagLabsCatalogPage;
import pages.SwagLabsLoginPage;
import pages.SwagLabsShoppingCardPage;

public class FirstTest extends BaseTest {

    private static final String userName = "standard_user";
    private static final String userPassword = "secret_sauce";


    @Test
    public void catalogHave6Product() {
        SwagLabsLoginPage.login(userName,userPassword);
        SwagLabsCatalogPage.inventoryItemLabel.shouldHave(CollectionCondition.sizeGreaterThanOrEqual(6));
    }

    @Test
    public void addTshirtToShoppingCard() {
        SwagLabsLoginPage.login(userName, userPassword);
        SwagLabsCatalogPage.addTshirtAndBackpackToShoppingCard();
        SwagLabsCatalogPage.openShoppingCard();
        SwagLabsShoppingCardPage.cardItems.shouldHave(CollectionCondition.size(2));

    }
}
