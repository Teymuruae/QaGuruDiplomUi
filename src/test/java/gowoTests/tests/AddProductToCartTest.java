package gowoTests.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import gowoTests.TestBase;
import gowoTests.pages.CartPage;
import gowoTests.pages.MainPage;
import gowoTests.pages.ProductPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class AddProductToCartTest extends TestBase {
    private static MainPage mainPage = new MainPage();
    private ProductPage productPage = new ProductPage();
    private CartPage cartPage = new CartPage();

    static Stream<Arguments> addProductToCartTest() {
        return Stream.of(
                Arguments.of(mainPage.getPhonesButtonLocator()),
                Arguments.of(mainPage.getNotebookButtonLocator()),
                Arguments.of(mainPage.getMonitorsButtonLocator())
        );
    }

    @DisplayName("Тест на добавление товара в корзину")
    @MethodSource()
    @ParameterizedTest()
    void addProductToCartTest(SelenideElement element) {
        Selenide.open("/");
        helpMethods
                .clickButton(mainPage.getHomeButtonLocator())
                .clickButton(element);
        Selenide.sleep(1000);
        String chosenProduct = mainPage.clickProduct();
        helpMethods
                .clickButton(productPage.getAddToCartButtonLocator());
        Selenide.confirm();
        helpMethods
                .clickButton(mainPage.getCartButtonLocator());
        Selenide.sleep(1000);
        List<String> productsList = cartPage.getProductsTitle().texts();
        System.out.println(chosenProduct);
        System.out.println(productsList);
        Assertions.assertTrue(productsList.contains(chosenProduct));
    }
}
