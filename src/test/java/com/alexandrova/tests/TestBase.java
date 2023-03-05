package com.alexandrova.tests;

import com.alexandrova.attach.Attach;
import com.alexandrova.config.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.Browser;

public class TestBase {
    private static final WebConfig webConfig = ConfigReader.Instance.read();
    private static final ProjectConfiguration projectConfiguration = new ProjectConfiguration(webConfig);

    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        projectConfiguration.webConfig();
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        if (Configuration.browser.equals(Browser.CHROME.browserName())) {
            Attach.browserConsoleLogs();
        }
        if (projectConfiguration.isRemote()) {
            Attach.addVideo(projectConfiguration.getVideoStorageUrl());
        }
    }
    }

