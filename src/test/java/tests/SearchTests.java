package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    @DisplayName("Успешный поиск статей по тексту")
    void successfulSearchTest() {
        if (!env.isBrowserstack()) {back();}
        step("Ввести в поиске Appium", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Убедиться, что результаты не пустые", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisabledIfSystemProperty(named = "deviceHost", matches = "browserstack")
    @DisplayName("Успешное открытие статьи")
    void successfulOpenArticleTest() {
        if (!env.isBrowserstack()) {back();}
        step("Ввести в поиске Starbucks", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Starbucks");
        });
        step("Тап на статью с заголовком Starbucks", () ->
                $(xpath("//android.widget.TextView[@text='Starbucks']")).click());
        step("Убедиться, что открыта статья Starbucks", () -> {
            $(xpath("//android.widget.TextView[@text='Starbucks']"))
                    .shouldBe(visible);
            $(xpath("//android.widget.TextView[@text='American multinational coffeehouse chain']"))
                    .shouldBe(visible);
        });
    }
}