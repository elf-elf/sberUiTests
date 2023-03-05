package com.alexandrova.config;

import org.aeonbits.owner.Config;

public interface WebConfig extends Config {
    @Key("browser")
    @DefaultValue("CHROME")
    Browser browser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1200x800")
    String browserSize();

    @Key("baseUrl")
    @DefaultValue("https://sberprime.sber.ru/")
    String baseUrl();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("remoteUrl")
    @DefaultValue("http://localhost:4444")
    String remoteUrl();

    @Key("videoStorage")
    String videoStorage();
}
