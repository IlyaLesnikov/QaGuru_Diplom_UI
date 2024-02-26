package guru.qa.tests;

import guru.qa.pages.TinkoffAppPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
@DisplayName("Тесты к сервису скачивания приложения")
public class TinkoffAppTests extends BaseTest{
    TinkoffAppPage tinkoffAppPage = new TinkoffAppPage();
    @Epic("Разработка авторизации")
    @Feature("Авторизация")
    @Story("Я как пользователь хочу иметь авторизоваться в личнокм кабинете чтобы работать с моими продуктами банка")
    @Test
    @Tags({@Tag("SMOKE"), @Tag("WEB")})
    @DisplayName("Открытие авторизации в личном кабинете \"Тинькофф бизнес\"")
    protected void openingAuthorizationInTheTinkoffBusinessPersonalAccountTest() {
        step("Открытие сайта для установки приложения", () -> tinkoffAppPage.openWebForm()
                .openUserIos()
                .appGalleryButtonClick());
        step("Проверка отображения кнопки \"Установить\"", () -> tinkoffAppPage.assertURL("https://appgallery.huawei.com/#/app/C101291451"));
    }
}
