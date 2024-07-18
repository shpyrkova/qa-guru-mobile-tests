package tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class OnboardingTests extends TestBase {

    @Test
    @DisabledIfSystemProperty(named = "deviceHost", matches = "browserstack")
    @DisplayName("Успешный просмотр экранов онбординга")
    void successfulOnboardingViewTest() {
        step("После запуска на первом экране онбординга должна быть кнопка Add or edit languages", () -> {
            $(id("org.wikipedia.alpha:id/addLanguageButton")).shouldBe(visible);
        });
        step("Перейти на следующий экран онбординга по тапу Continue", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Проверить, что есть текст New ways to explore", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).
                    shouldHave(text("New ways to explore"));
        });
        step("Перейти на следующий экран онбординга по тапу Continue", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Проверить, что есть текст Reading lists with sync", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).
                    shouldHave(text("Reading lists with sync"));
        });
        step("Перейти на следующий экран онбординга по тапу Continue", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Проверить, что есть кнопка Get started", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).
                    shouldHave(text("Get started"));
        });
    }

}
