package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$;

public class SwagLabsCatalogPage {

    public static ElementsCollection
            inventoryItemLabel = $$(By.className("inventory_item_label"));

    public static SelenideElement
            tShirt = $(By.id("add-to-cart-sauce-labs-bolt-t-shirt")),
            backpack = $(By.id("add-to-cart-sauce-labs-backpack")),
            shoppingCardButton = $(By.id("shopping_cart_container"));


    public static void addTshirtAndBackpackToShoppingCard() {
        tShirt.click();
        backpack.click();
    }

    public static void openShoppingCard() {
        shoppingCardButton.click();
    }

}



