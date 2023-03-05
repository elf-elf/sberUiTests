package com.alexandrova.tests.page;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPage {

    public MainPage openMainPage() {
        step("Открыть главную страницу сайта \"sberprime\"", () -> open(""));
        return this;
    }

    public MainPage chechLogoFontSize(){
        step("Проверить лого сайта 'параметры СSS'", () ->
                $(".header-new__logo").shouldHave(cssValue("width", "144px")));
        $(".header-new__logo").shouldHave(cssValue("height", "30px"));
        $(".header-new__logo").shouldHave(cssValue("background-size", "cover"));
        $(".header-new__logo").shouldHave(cssValue("color", "rgba(0, 0, 238, 1)"));
        $(".header-new__logo").shouldHave(cssValue("font", "13px / 16.003px SBSansDisplay, OpenSans, \"Helvetica Neue\", Helvetica, Arial, sans-serif"));
        return this;
    }
    public MainPage goToPage(String name) {
        step(String.format("Перейти на страницу раздела \"%s\"", name), () -> $(byText(name)).click());
        return this;
    }
    public MainPage checkPageTitle(String disc) {
        step(String.format("Проверить заголовок на странице раздела \"%s\"", disc), () ->
                $("#main").shouldHave(text(disc)));
        return this;
    }

}
