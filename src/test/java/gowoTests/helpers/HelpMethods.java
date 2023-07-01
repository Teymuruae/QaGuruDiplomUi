package gowoTests.helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class HelpMethods {

    /**
     * метод клика по кнопке по локатору
     * @param element
     */
    public HelpMethods clickButtonByLocator(SelenideElement element){
        element.shouldBe(Condition.visible).click();
        return this;
    }

    public HelpMethods setValueByLocator(SelenideElement element, String valueToSet){
        element.clear();
        element.setValue(valueToSet);
        return this;
    }
}
