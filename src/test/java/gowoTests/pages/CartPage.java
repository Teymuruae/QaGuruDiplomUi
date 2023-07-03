package gowoTests.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class CartPage {

    private ElementsCollection
            productsTitle = $$x("//tbody//td[2]");

    public ElementsCollection getProductsTitle() {
        return productsTitle;
    }
}
