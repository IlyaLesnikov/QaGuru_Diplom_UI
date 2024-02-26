package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class TinkoffAppPage {
    private final SelenideElement userIos = $("[data-guid='ca8efef8-8069-409c-add5-3200bf1efc28'] [data-test='clickableArea slideLink']");
    private final SelenideElement appGalleryButton = $("[data-guid='e6902d52-7ddc-47c7-bec2-8f5eda1e2982'] [class='cb30mZcTA']");
    private final SelenideElement installTheApplication = $("[class='detailheadcard']");

    public TinkoffAppPage openWebForm() {
        open("/apps/");

        return this;
    }

    public TinkoffAppPage openUserIos() {
        userIos.click();

        return this;
    }

    public TinkoffAppPage appGalleryButtonClick() {
        appGalleryButton.click();

        return this;
    }
    public void assertURL(String url) {
        switchTo().window(1);
        webdriver().shouldHave(url(url));
        switchTo().window(0);
    }
}
