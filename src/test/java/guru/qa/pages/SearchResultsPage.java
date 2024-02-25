package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage {
    private final SelenideElement searchValue = $("#mainContent .srp-controls__count-heading");

    public void checkingSearchResults(String value) {
        searchValue.shouldHave(text(value));
    }

}
