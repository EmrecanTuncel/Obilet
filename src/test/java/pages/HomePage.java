package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class HomePage extends BasePage{

    public SelenideElement mailText = $("input[type='email']");
    public SelenideElement passwordText = $("input[type='password']");
    public SelenideElement loginButton = $("a[class='login']");
    public SelenideElement popUpCheck = $(".header.user-sign-up.login-header");

    public SelenideElement signUpButton = $(".sign-up.login-to-register");

    public SelenideElement signUpButton2 = $(".register.register-button");

    public SelenideElement flightButton = $("a[data-event-label='Clicked Flight on Menu']");
    public SelenideElement profilePart = $("a[class='user-name']");

    public HomePage(String pageUrl) {
        super(pageUrl);
    }

    public void enterMailPassword(String mail, String password) {
        mailText.setValue(mail);
        passwordText.setValue(password);
    }
}
