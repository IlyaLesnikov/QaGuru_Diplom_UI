package guru.qa.tests;

import guru.qa.pages.WorkingInItPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;

public class WorkingInItTests extends BaseTest {
    WorkingInItPage workingInItPage = new WorkingInItPage();
    @Epic("Разработка сервиса \"Работа в ИТ\"")
    @Feature("Поиска работы по направлению")
    @Story("Я как пользователь хочу искать работу по направлению")
    @Test
    @Tags({@Tag("SMOKE"), @Tag("WEB")})
    @DisplayName("Поиск работы по направлению")
    protected void jobSearchByDirection() {
        step("Фильтрация вакансий по направлению", () -> workingInItPage.openWebForm()
                .clickingTheViewVacanciesButton()
                .openingTheDirectionDropDownList("Направление")
                .selectingAValueInTheDirectionDropDownList("Backend")
                .checkingTheSelectedDirection("Backend"));
    }

    @Epic("Разработка сервиса \"Работа в ИТ\"")
    @Feature("Поиска работы по направлению")
    @Story("Я как пользователь хочу искать работу по направлению")
    @Test
    @Tags({@Tag("SMOKE"), @Tag("WEB")})
    @DisplayName("Поиск работы по направлению и уровню")
    protected void jobSearchByDirectionAndLevel() {
        step("Фильтрация вакансий по направлению и уровню", () -> workingInItPage.openWebForm()
                .clickingTheViewVacanciesButton()
                .openingTheDirectionDropDownList("Направление")
                .selectingAValueInTheDirectionDropDownList("Frontend")
                .checkingTheSelectedDirection("Frontend")
                .openingTheDirectionDropDownListLevel()
                .selectingAValueInTheDirectionDropDownList("Middle"));
    }
    @Epic("Разработка сервиса \"Работа в ИТ\"")
    @Feature("Карточка вакансии")
    @Story("Я как пользователь хочу открывать карточку вакансии с подробной информацией")
    @Test
    @Tags({@Tag("SMOKE"), @Tag("WEB")
    })
    @DisplayName("Отображение кнопки \"Откликнуться\" в карточке вакансии")
    protected void peningAJobCard() {
        step("Открытие карточки вакансии", () -> workingInItPage.openWebForm()
                .clickingTheViewVacanciesButton()
                .openingAVacancy());
        step("Проверка отображения кнопки \"Откликнуться\"", () -> workingInItPage.checkingForThePresenceOfAButton("Откликнуться"));
    }
}
