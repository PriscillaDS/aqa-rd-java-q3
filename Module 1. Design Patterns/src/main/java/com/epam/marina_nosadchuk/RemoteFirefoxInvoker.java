package com.epam.marina_nosadchuk;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class RemoteFirefoxInvoker implements WebDriverInvoker{
    @SneakyThrows
    @Override
    public WebDriver invokeWebDriver() {
        return new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"), new FirefoxOptions());
    }

}
