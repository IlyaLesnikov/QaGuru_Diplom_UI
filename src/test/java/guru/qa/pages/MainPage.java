package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement personalAccountButton = $("[data-test='loginButton']");
    private final SelenideElement internetBankingButton = $("[data-test='clickableArea login-first']");
    private final SelenideElement tinkoffBusinessButton = $("[data-test='clickableArea login-second']");
    private final SelenideElement investmentsButton = $("[data-test='clickableArea login-third']");
    private final SelenideElement tinkoffMobileButton = $("[data-test='clickableArea login-fourth']");
    private final SelenideElement theMoreButton = $("[data-test='menu-item-3-title']");
    private final SelenideElement buttonStillWorks = $("[class*='abzbdL5Rm bbzbdL5Rm'] [data-test='clickableArea text-item-3-0']");
    public MainPage openWebForm(String url) {
        open(url);

        return this;
    }

    public MainPage openingTheDropDownListForChoosingAPersonalAccount() {
        personalAccountButton.hover();

        return this;
    }
    public MainPage openingTheAuthorizationOfTheInternetBank() {
        internetBankingButton.click();
        switchTo().window(1);

        return this;
    }
    public MainPage openingAuthorizationTinkoffBusiness() {
        tinkoffBusinessButton.click();

        return this;
    }
    public MainPage openingAnInvestmentAuthorization() {
        investmentsButton.click();

        return this;
    }
    public MainPage openingAuthorizationInTinkoffMobile() {
        tinkoffMobileButton.click();
        switchTo().window(1);

        return this;
    }

    public MainPage openingTheMoreDropDownList() {
        theMoreButton.click();

        return this;
    }
    public MainPage clickingTheWorkInItButton() {
        buttonStillWorks.click();

        return this;
    }

    public void checkingTheDisplayOfThePersonalAccountButton(String nameButton) {
        personalAccountButton.shouldHave(text(nameButton));
    }
}
