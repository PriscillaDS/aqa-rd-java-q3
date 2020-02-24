package com.epam.marina_nosadchuk;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class RemoteChromeInvoker implements WebDriverInvoker {
    @SneakyThrows
    @Override
    public WebDriver invokeWebDriver() {
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new ChromeOptions());
    }

}
