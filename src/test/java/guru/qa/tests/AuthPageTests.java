package guru.qa.tests;

import guru.qa.data.FieldData;
import guru.qa.pages.AuthPage;
import guru.qa.pages.MainPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import static io.qameta.allure.Allure.step;


@DisplayName("Тесты к сервису главной страницы")
public class AuthPageTests extends BaseTest {
    MainPage mainPage = new MainPage();
    AuthPage authPage = new AuthPage();
    FieldData authData = new FieldData();
    @Epic("Разработка авторизации")
    @Feature("Валидация авторизации")
    @Story("Я как пользователь хочу получать сообщение о невалидных данных при авторизации чтобы понимать, где я ошибся")
    @Test
    @Tags({@Tag("SMOKE"), @Tag("WEB")})
    @DisplayName("Авторизация с пустым полем в личном кабинете")
    protected void authorizationWithAnEmptyFieldInThePersonalAccountTest() {
        step("Авторизация с пусым полем \"Телефон\"", () -> {
            mainPage.openWebForm("https://www.tinkoff.ru/")
                    .openingTheDropDownListForChoosingAPersonalAccount()
                    .openingTheAuthorizationOfTheInternetBank();
            authPage.clickingOnTheAuthorizationButton();
        });
        step("Проверка сообщения об ошибке", () -> authPage.checkingTheErrorMessageOrTheNameOfYourPersonalAccount("Введите номер телефона"));
    }

    @Epic("Разработка авторизации")
    @Feature("Валидация авторизации")
    @Story("Я как пользователь хочу получать сообщение о невалидных данных при авторизации чтобы понимать, где я ошибся")
    @Test
    @Tags({@Tag("SMOKE"), @Tag("WEB")})
    @DisplayName("Авторизация с несуществующем номером телефона")
    protected void authorizationWithANonExistentPhoneNumber() {
        step("Авторизация с несуществующем номером телефона в поле \"Телефон\"", () -> {
            mainPage.openWebForm("https://www.tinkoff.ru/")
                    .openingTheDropDownListForChoosingAPersonalAccount()
                    .openingTheAuthorizationOfTheInternetBank();
            authPage.fillingInThePhoneField(authData.getINVALID_PHONE_NUMBER())
                    .clickingOnTheAuthorizationButton();
        });
        step("Проверка сообщения об ошибке", () -> authPage.checkingTheErrorMessageOrTheNameOfYourPersonalAccount("Введен неверный номер телефона"));
    }

    @Epic("Разработка авторизации")
    @Feature("Закрытие авторизации")
    @Story("Я как пользователь хочу получать сообщение о невалидных данных при авторизации чтобы понимать, где я ошибся")
    @Test
    @Tags({@Tag("SMOKE"), @Tag("WEB")})
    @DisplayName("Закрытие авторизации")
    protected void closingAuthorization() {
        step("Авторизация с несуществующем номером телефона в поле \"Телефон\"", () -> {
            mainPage.openWebForm("https://www.tinkoff.ru/")
                    .openingTheDropDownListForChoosingAPersonalAccount()
                    .openingTheAuthorizationOfTheInternetBank();
            authPage.closedAuthorizationWebForm();
        });
        step("Проверка сообщения об ошибке", () -> mainPage.checkingTheDisplayOfThePersonalAccountButton("Личный кабинет"));
    }

    @Epic("Разработка авторизации")
    @Feature("Уникальное название у личного кабинета \"Тинькофф Мобайл\"")
    @Story("Я как пользователь хочу чтобы при авторизации в личном кабинете \"Тинькофф Мобайл\" отображалось уникальное название личного кабинета")
    @Test
    @Tag("WEB")
    @DisplayName("Отображение уникального названия личного кабинета")
    protected void displayingTheUniqueNameOfThePersonalAccount() {
        step("Авторизация с несуществующем номером телефона в поле \"Телефон\"", () -> mainPage.openWebForm("https://www.tinkoff.ru/")
                    .openingTheDropDownListForChoosingAPersonalAccount()
                    .openingAuthorizationInTinkoffMobile());
        step("Проверка сообщения об ошибке", () -> authPage.checkingTheErrorMessageOrTheNameOfYourPersonalAccount("Вход в Мобайл"));
    }
}
