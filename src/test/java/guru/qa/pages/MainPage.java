package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement theFindButton = $("[class='gh-tbl2'] [class='btn btn-prim gh-spr']");
    private final SelenideElement theSearchBar = $("[class='gh-tbl2'] [class='gh-tb ui-autocomplete-input']");
    private final SelenideElement localizationButton = $("#gh-top");
    public MainPage enteringAValueInTheSearch(String value) {
        theSearchBar.setValue(value);

        return this;
    }
    public MainPage clickingTheFindButton() {
        theFindButton.click();

        return this;
    }
    public MainPage localizationСhange(String language, String languageTwo) {
        localizationButton.$(byText(language)).click();
        localizationButton.$(byText(languageTwo)).click();

        return this;
    }
    public void checkingLocalizationLanguageChange(String language) {
        localizationButton.shouldHave(text(language));
    }

}
