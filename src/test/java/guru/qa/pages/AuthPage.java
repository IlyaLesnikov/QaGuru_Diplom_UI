package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class AuthPage {
    private final SelenideElement theTinkoffEntryElement = $("[automation-id='form-title']");

    public void checkingTheOpeningOfTheAuthorizationForm(String value) {
        switchTo().window(1);
        theTinkoffEntryElement.shouldHave(text(value));
        switchTo().window(0);
    }
}
