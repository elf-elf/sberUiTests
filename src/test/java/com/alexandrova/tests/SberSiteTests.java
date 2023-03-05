package com.alexandrova.tests;

import com.alexandrova.tests.page.MainPage;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SberSiteTests extends TestBase {

    private MainPage mainPage = new MainPage();
    @Test
    @Tag("logo")
    @AllureId("14666")
    @DisplayName("Проверка лого сайта на 'параметры CSS'")
    void sberLogoTest() {
        mainPage.openMainPage();
        mainPage.chechLogoFontSize();
    }
    @Tag("page")
    @AllureId("14671")
    @DisplayName("Проверка перехода в разделы сайта.")
    @ParameterizedTest(name = "Выполняется переход в раздел \"{0}\"")
    @CsvSource(value = {
            "Обзор, Выбрать подписку",
            "СберПрайм, Выгода каждый день с подпиской СберПрайм",
            "Для молодёжи, 12 сервисов для тебя",})

    void testWithCsvSource(String name, String disc) {
        mainPage.openMainPage();
        mainPage.goToPage(name);
        mainPage.checkPageTitle(String.valueOf(disc));
    }

}
