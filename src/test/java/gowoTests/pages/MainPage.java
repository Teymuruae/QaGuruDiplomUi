package gowoTests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private SelenideElement
            authTabeTitle = $("#login .mat-card-title.mb-2"),
            authEmailField = $("#mat-input-0"),
            authPasswordField = $("#mat-input-0"),
            authEnterButton = $("#login .mat-focus-indicator.mat-accent"),
            vipUsersTextLocator = $x("//h3[text() = 'VIP пользователи']");

    public void doAuthUi(String login, String password) {
        authEmailField.setValue(login);
        authPasswordField.setValue(password);
        authEnterButton.click();
    }

    public SelenideElement getAuthTabeTitle() {
        return authTabeTitle;
    }

    public SelenideElement getVipUsersTextLocator() {
        return vipUsersTextLocator;
    }
}
