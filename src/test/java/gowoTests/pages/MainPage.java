package gowoTests.pages;

import com.codeborne.selenide.SelenideElement;
import gowoTests.helpers.HelpMethods;
import groovyjarjarpicocli.CommandLine;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    protected HelpMethods helpMethods = new HelpMethods();
    private SelenideElement
            enterLinkLocator = $x("//a[text() = 'Вход']");

    public SelenideElement getEnterLinkLocator() {
        return enterLinkLocator;
    }

    /**
     * метод клика на кнопку входа
     * @return
     */
    public EnterModalWindow clickEnterLink() {
        helpMethods.clickButtonByLocator(enterLinkLocator);
        return new EnterModalWindow();
    }
}
