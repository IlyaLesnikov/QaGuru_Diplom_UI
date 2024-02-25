package guru.qa.tests;

import guru.qa.data.EbayData;
import guru.qa.pages.MainPage;
import guru.qa.pages.SearchResultsPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Тесты к функционалу поиска")
public class MainPageTest extends BaseTest {
    MainPage mainPage = new MainPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    EbayData ebayData = new EbayData();
    @Epic("Разработка поиска")
    @Feature("Поиск")
    @Story("Я как покупатель хочу иметь возможность искать товар через строку поиска для экономии своего времени")
    @ParameterizedTest
    @ValueSource(strings = {"New Balance", "Apple"})
    @Tags({
            @Tag("SMOKE"),
            @Tag("WEB")
    })
    @DisplayName("Поиск товара через строку поиска в нескольких категориях")
    protected void productSearchViaTheSearchBarTest(String value) {
        mainPage.enteringAValueInTheSearch(value)
                .clickingTheFindButton();
        searchResultsPage.checkingSearchResults(value);

    }
    @Epic("Разработка поиска")
    @Feature("Поиск")
    @Story("Я как покупатель хочу иметь возможность искать товар через строку поиска для экономии своего времени")
    @Test
    @Tag("WEB")
    @DisplayName("Поиск несуществующего товара")
    protected void searchForANonExistentProductTest() {
        mainPage.enteringAValueInTheSearch(ebayData.getINVALID_VALUE())
                .clickingTheFindButton();
        searchResultsPage.checkingSearchResults("0");
    }
}
