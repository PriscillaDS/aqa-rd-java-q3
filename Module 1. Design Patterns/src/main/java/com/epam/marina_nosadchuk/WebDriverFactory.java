package com.epam.marina_nosadchuk;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public static WebDriver newWebDriver() {
        return ConfigFactory.create(Browser.class).getBrowser().getWebDriver();
    }
}
