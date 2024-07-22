package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.MobileDriverProvider;
import helpers.Attach;
import helpers.Environment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    Environment env = new Environment();

    @BeforeAll
    static void beforeAll() {
        MobileDriverProvider mobileDriverProvider = new MobileDriverProvider();
        mobileDriverProvider.setMobileConfig();
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        Attach.pageSource();
        if (env.isBrowserstack()) {
            String sessionId = Selenide.sessionId().toString();
            Attach.addVideo(sessionId);
        }
        closeWebDriver();
    }
}
