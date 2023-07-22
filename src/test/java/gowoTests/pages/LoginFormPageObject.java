package gowoTests.pages;

import com.codeborne.selenide.SelenideElement;
import gowoTests.helpers.HelpMethods;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginFormPageObject extends MainPage {
    private HelpMethods helpMethods = new HelpMethods();
    private String
            wrongUserALertText = "User does not exist.",
            emptyFieldAlertText = "Please fill out Username and Password.",
            wrongPasswordAletText = "Wrong password.";

    SelenideElement
            usernameLocator = $("#loginusername"),
            passwordLocator = $("#loginpassword"),
            logInModalButton = $("[onclick = 'logIn()']"),
            closeModalButton = $x("//button[@onclick= 'logIn()']//..//button[text() = 'Close']");

    public String getWrongUserALertText() {
        return wrongUserALertText;
    }

    public String getEmptyFieldAlertText() {
        return emptyFieldAlertText;
    }

    public String getWrongPasswordAletText() {
        return wrongPasswordAletText;
    }

    public SelenideElement getCloseModalButton() {
        return closeModalButton;
    }

    /**
     * метод вход в аккаунт через ui
     *
     * @param userName
     * @param password
     */
    public void doLogin(String userName, String password) {
        helpMethods
                .clickButton(getLoginButtonLocator())
                .fillForm(usernameLocator, userName)
                .fillForm(passwordLocator, password)
                .clickButton(logInModalButton);
    }
}