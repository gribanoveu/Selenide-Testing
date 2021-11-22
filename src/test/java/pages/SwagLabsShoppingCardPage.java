package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class SwagLabsShoppingCardPage {

    public static ElementsCollection
            cardItems = $$(By.className("cart_item"));
}
