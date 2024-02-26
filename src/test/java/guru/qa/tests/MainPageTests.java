package guru.qa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.pages.AuthPage;
import guru.qa.pages.MainPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


@DisplayName("Тесты к функционалу главной страницы")
public class MainPageTests extends BaseTest {
    MainPage mainPage = new MainPage();
    AuthPage authPage = new AuthPage();

    @BeforeEach
    public void addAllureListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открытие главной страницы", () -> open("https://www.tinkoff.ru/"));
    }
    @Epic("Разработка авторизации")
    @Feature("Авторизация")
    @Story("Я как пользователь хочу иметь авторизоваться в личнокм кабинете чтобы работать с моими продуктами банка")
    @Test
    @Tags({@Tag("SMOKE"), @Tag("WEB")})
    @DisplayName("Открытие авторизации в личном кабинете \"Интернет банк\"")
    protected void openingOfAuthorizationInThePersonalAccountOfTheInternetBankTest() {
        step("Открытие авторизации", () -> mainPage.openingTheDropDownListForChoosingAPersonalAccount()
                .openingTheAuthorizationOfTheInternetBank());
        step("Проверка открытия веб-формы авторизации", () -> authPage.checkingTheOpeningOfTheAuthorizationForm("Вход в Тинькофф"));
    }
    @Epic("Разработка авторизации")
    @Feature("Авторизация")
    @Story("Я как пользователь хочу иметь авторизоваться в личнокм кабинете чтобы работать с моими продуктами банка")
    @Test
    @Tags({@Tag("SMOKE"), @Tag("WEB")
    })
    @DisplayName("Открытие авторизации в личном кабинете \"Тинькофф бизнес\"")
    protected void openingAuthorizationInTheTinkoffBusinessPersonalAccountTest() {
        step("Открытие авторизации", () -> mainPage.openingTheDropDownListForChoosingAPersonalAccount()
                .openingAuthorizationTinkoffBusiness());
        step("Проверка открытия веб-формы авторизации", () -> authPage.checkingTheOpeningOfTheAuthorizationForm("Вход в Тинькофф"));
    }
    @Epic("Разработка авторизации")
    @Feature("Авторизация")
    @Story("Я как пользователь хочу иметь авторизоваться в личнокм кабинете чтобы работать с моими продуктами банка")
    @Test
    @Tags({@Tag("SMOKE"), @Tag("WEB")
    })
    @DisplayName("Открытие авторизации в личном кабинете \"Инвестиции\"")
    protected void openingAuthorizationInThePersonalAccountInvestmentsTest() {
        step("Открытие авторизации", () -> mainPage.openingTheDropDownListForChoosingAPersonalAccount()
                .openingAnInvestmentAuthorization());
        step("Проверка открытия веб-формы авторизации", () -> authPage.checkingTheOpeningOfTheAuthorizationForm("Вход в Тинькофф"));
    }
    @Epic("Разработка авторизации")
    @Feature("Авторизация")
    @Story("Я как пользователь хочу иметь авторизоваться в личнокм кабинете чтобы работать с моими продуктами банка")
    @Test
    @Tags({@Tag("SMOKE"), @Tag("WEB")
    })
    @DisplayName("Открытие авторизации в личном кабинете \"Тинькофф мобайл\"")
    protected void openingAuthorizationInThePersonalAccountOfTinkoffMobileTest() {
        step("Открытие авторизации", () -> mainPage.openingTheDropDownListForChoosingAPersonalAccount()
                .openingAuthorizationInTinkoffMobile());

        step("Проверка открытия веб-формы авторизации", () -> authPage.checkingTheOpeningOfTheAuthorizationForm("Вход в Мобайл"));
    }
}
