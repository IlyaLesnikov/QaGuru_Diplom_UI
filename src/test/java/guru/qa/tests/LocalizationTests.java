package guru.qa.tests;

import guru.qa.pages.MainPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты к функционалу смены языка локализации")
public class LocalizationTests extends BaseTest{
    MainPage mainPage = new MainPage();
    @Epic("Разработка локализации")
    @Feature("Локализация")
    @Story("Я как покупатель хочу иметь возможность выбрать другой язык локализации")
    @Test
    @Tags({
            @Tag("SMOKE"),
            @Tag("WEB")
    })
    @DisplayName("Добавление товара в избранное")
    protected void addingAnItemToFavoritesTest() {
        mainPage.localizationСhange("Current language English", "Русский")
                .checkingLocalizationLanguageChange("English");

    }
}
