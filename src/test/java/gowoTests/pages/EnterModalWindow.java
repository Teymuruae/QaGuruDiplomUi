package gowoTests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class EnterModalWindow extends MainPage {
    private SelenideElement
            loginFieldLocator = $(".frnd-login__input[type = 'text']"),
            passwordFieldLocator = $(".frnd-login__input[type = 'password']"),
            enterButtonLocator = $("div.frnd-login__form_row button[type='submit']");

    public void fillUiLoginForm(String login, String password) {
        helpMethods
                .setValueByLocator(loginFieldLocator, login)
                .setValueByLocator(passwordFieldLocator, password)
                .clickButtonByLocator(enterButtonLocator);
    }
}