package com.epam.marina_nosadchuk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocalChromeInvoker implements WebDriverInvoker{

    @Override
    public WebDriver invokeWebDriver() {
        return new ChromeDriver();
    }
}
