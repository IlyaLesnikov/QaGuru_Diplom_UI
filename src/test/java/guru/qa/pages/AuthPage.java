package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AuthPage {
    private final SelenideElement authorizationButton = $("[automation-id='button-submit']");
    private final SelenideElement loginForm = $("[automation-id='login-form']");
    private final SelenideElement phoneField = $("[automation-id='phone-input']");
    private final SelenideElement closedAuthorizationButton = $("[automation-id='close-page']");
    public AuthPage clickingOnTheAuthorizationButton() {
        authorizationButton.click();

        return this;
    }
    public AuthPage fillingInThePhoneField(String phone) {
        phoneField.setValue(phone);

        return this;
    }
    public void closedAuthorizationWebForm() {
        closedAuthorizationButton.click();
    }
    public void checkingTheErrorMessageOrTheNameOfYourPersonalAccount(String value) {
        loginForm.$(byText(value))
                .shouldHave(text(value));
    }
}
