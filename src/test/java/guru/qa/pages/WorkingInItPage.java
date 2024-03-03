package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class WorkingInItPage {
    private final SelenideElement theViewVacanciesButton = $("[class='fbnF4iwm8'] [data-qa-type='uikit/button.content']");
    private final SelenideElement dropDownListOfDirections = $("[class='aNLd3w']");
    private final SelenideElement openDropDownList = $("[data-qa-type='uikit/scroll.content']");
    private final SelenideElement theChosenDirection = $("[data-qa-type='vacancy-list-section-0-title']");
    private final SelenideElement dropDownListOfLevel = $("[class='capr4f aapr4f wapr4f iapr4f'] [class='g3nym-+']");
    private final SelenideElement vacancy = $("[class='bOQH4s']");
    private final SelenideElement theRespondButton = $("[data-qa-type='uikit/button']");
    public WorkingInItPage openCareerWebForm() {
        step("Открытие страницы", () -> open("/career/it/about/"));

        return this;
    }
    public WorkingInItPage clickingViewVacanciesButton() {
        theViewVacanciesButton.click();

        return this;
    }
    public WorkingInItPage openingDirectionDropDownList (String value) {
        dropDownListOfDirections.$(byText(value)).click();

        return this;
    }
    public WorkingInItPage openingDirectionDropDownListLevel () {
        dropDownListOfLevel.click();

        return this;
    }
    public WorkingInItPage selectingValueInDirectionDropDownList(String value) {
        openDropDownList.$(byText(value)).click();

        return this;
    }
    public WorkingInItPage checkingSelectedDirection(String direction) {
        theChosenDirection.shouldHave(text(direction));

        return this;
    }
    public WorkingInItPage openingVacancy() {
        vacancy.click();

        return this;
    }
    public void checkingForPresenceButton(String value) {
        theRespondButton.$(byText(value))
                .shouldHave(text(value));
    }
}
