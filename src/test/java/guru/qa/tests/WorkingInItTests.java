package guru.qa.tests;

import guru.qa.pages.WorkingInItPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import static io.qameta.allure.Allure.step;

@DisplayName("Тесты к функционалу сервиса \"Работа в ИТ\"")
public class WorkingInItTests extends BaseTest {
    WorkingInItPage workingInItPage = new WorkingInItPage();
    @Epic("Разработка сервиса \"Работа в ИТ\"")
    @Feature("Поиска работы по направлению")
    @Story("Я как пользователь хочу искать работу по направлению")
    @Test
    @Tag("SMOKE")
    @DisplayName("Поиск работы по направлению")
    protected void jobSearchByDirection() {
        step("Фильтрация вакансий по направлению", () -> workingInItPage.openCareerWebForm()
                .clickingViewVacanciesButton()
                .openingDirectionDropDownList("Направление")
                .selectingValueInDirectionDropDownList("Backend")
                .checkingSelectedDirection("Backend"));
    }
    @Epic("Разработка сервиса \"Работа в ИТ\"")
    @Feature("Поиска работы по направлению")
    @Story("Я как пользователь хочу искать работу по направлению")
    @Test
    @Tag("SMOKE")
    @DisplayName("Поиск работы по направлению и уровню")
    protected void jobSearchByDirectionAndLevel() {
        step("Фильтрация вакансий по направлению и уровню", () -> workingInItPage.openCareerWebForm()
                .clickingViewVacanciesButton()
                .openingDirectionDropDownList("Направление")
                .selectingValueInDirectionDropDownList("Frontend")
                .checkingSelectedDirection("Frontend")
                .openingDirectionDropDownListLevel()
                .selectingValueInDirectionDropDownList("Middle"));
    }
    @Epic("Разработка сервиса \"Работа в ИТ\"")
    @Feature("Карточка вакансии")
    @Story("Я как пользователь хочу открывать карточку вакансии с подробной информацией")
    @Test
    @Tag("SMOKE")
    @DisplayName("Отображение кнопки \"Откликнуться\" в карточке вакансии")
    protected void peningAJobCard() {
        step("Открытие карточки вакансии", () -> workingInItPage.openCareerWebForm()
                .clickingViewVacanciesButton()
                .openingVacancy());
        step("Проверка отображения кнопки \"Откликнуться\"", () -> workingInItPage.checkingForPresenceButton("Откликнуться"));
    }
}
