package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import guru.qa.helpes.Attach;
import guru.qa.pages.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

abstract public class BaseTest {
    @BeforeAll
    public static void setUp() {
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        //Configuration.remote = System.getProperty("remoteUrl", "https://{}");
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    public void addAllureListener() {
        //SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открытие главной страницы", () -> open("https://www.ebay.com/"));
    }

    @AfterEach
    public void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
