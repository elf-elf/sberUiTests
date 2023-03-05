package com.alexandrova.tests;

import com.alexandrova.attach.Attach;
import com.alexandrova.config.CredentialsConfig;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.BrowserPerTestStrategyExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    @ExtendWith({BrowserPerTestStrategyExtension.class})

        public static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

        @BeforeAll
        static void beforeAll() {

            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

            Configuration.baseUrl = "https://sberprime.sber.ru/";
            Configuration.browserSize = "1920x1080";
            Configuration.remote = config.server();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC",true);
            capabilities.setCapability("enableVideo",true);
            Configuration.browserCapabilities = capabilities;
        }

        @AfterEach
        void addAttachments () {
            Attach.screenshotAs("Screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        }
    }

