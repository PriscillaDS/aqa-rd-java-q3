package com.epam.marina_nosadchuk;

import org.aeonbits.owner.Config;


@Config.Sources("classpath:browser.properties")
public interface Browser extends Config {

    @Key("browser")
    @ConverterClass(SupportedBrowsersConverter.class)
    SupportedBrowsers getBrowser();
}
