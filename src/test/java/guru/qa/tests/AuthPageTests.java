package guru.qa.tests;

import guru.qa.pages.AuthPage;
import guru.qa.pages.MainPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

@DisplayName("Тесты к сервису главной страницы")
public class AuthPageTests extends BaseTest {
    MainPage mainPage = new MainPage();
    AuthPage authPage = new AuthPage();
    private final String MAIN_WEB_FORM = "https://www.tinkoff.ru/";
    @Epic("Разработка авторизации")
    @Feature("Валидация авторизации")
    @Story("Я как пользователь хочу получать сообщение о невалидных данных при авторизации чтобы понимать, где я ошибся")
    @Test
    @Tag("SMOKE")
    @DisplayName("Авторизация с пустым полем в личном кабинете")
    protected void authorizationWithAnEmptyFieldInThePersonalAccountTest() {
        step("Авторизация с пусым полем \"Телефон\"", () -> {
            mainPage.openMainWebForm(MAIN_WEB_FORM)
                    .openingDropDownListForChoosingPersonalAccount()
                    .openingAuthorizationInternetBank();
            authPage.clickingOnAuthorizationButton();
        });
        step("Проверка сообщения об ошибке", () -> authPage.checkingErrorMessageOrNameYourPersonalAccount("Введите номер телефона"));
    }

    @Epic("Разработка авторизации")
    @Feature("Валидация авторизации")
    @Story("Я как пользователь хочу получать сообщение о невалидных данных при авторизации чтобы понимать, где я ошибся")
    @ParameterizedTest
    @ValueSource(strings = {"3333333333333333", "1234678901234523", "23792742748"})
    @Tag("SMOKE")
    @DisplayName("Авторизация с несуществующем номером телефона")
    protected void authorizationWithANonExistentPhoneNumber(String phone) {
        step("Авторизация с несуществующем номером телефона в поле \"Телефон\"", () -> {
            mainPage.openMainWebForm(MAIN_WEB_FORM)
                    .openingDropDownListForChoosingPersonalAccount()
                    .openingAuthorizationInternetBank();
            authPage.fillingInPhoneField(phone)
                    .clickingOnAuthorizationButton();
        });
        step("Проверка сообщения об ошибке", () -> authPage.checkingErrorMessageOrNameYourPersonalAccount("Введен неверный номер телефона"));
    }

    @Epic("Разработка авторизации")
    @Feature("Закрытие авторизации")
    @Story("Я как пользователь хочу получать сообщение о невалидных данных при авторизации чтобы понимать, где я ошибся")
    @Test
    @Tag("SMOKE")
    @DisplayName("Закрытие авторизации")
    protected void closingAuthorization() {
        step("Закрытие веб-формы авторизации", () -> {
            mainPage.openMainWebForm(MAIN_WEB_FORM)
                    .openingDropDownListForChoosingPersonalAccount()
                    .openingAuthorizationInternetBank();
            authPage.closedAuthorizationWebForm();
        });
        step("Проверка сообщения об ошибке", () -> mainPage.checkingDisplayOfPersonalAccountButton("Личный кабинет"));
    }

    @Epic("Разработка авторизации")
    @Feature("Уникальное название у личного кабинета \"Тинькофф Мобайл\"")
    @Story("Я как пользователь хочу чтобы при авторизации в личном кабинете \"Тинькофф Мобайл\" отображалось уникальное название личного кабинета")
    @Test
    @Tag("WEB")
    @DisplayName("Отображение уникального названия личного кабинета")
    protected void displayingTheUniqueNameOfThePersonalAccount() {
        step("Авторизация с несуществующем номером телефона в поле \"Телефон\"", () -> mainPage.openMainWebForm(MAIN_WEB_FORM)
                    .openingDropDownListForChoosingPersonalAccount()
                    .openingAuthorizationInTinkoffMobile());
        step("Проверка сообщения об ошибке", () -> authPage.checkingErrorMessageOrNameYourPersonalAccount("Вход в Мобайл"));
    }
}
