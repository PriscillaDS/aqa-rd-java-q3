package com.epam.marina_nosadchuk;

import org.openqa.selenium.WebDriver;

public enum SupportedBrowsers {

    REMOTE_CHROME(new RemoteChromeInvoker()),
    REMOTE_FIREFOX(new RemoteFirefoxInvoker()),
    LOCAL_CHROME(new LocalChromeInvoker());

    WebDriverInvoker webDriverInvoker;

    SupportedBrowsers(WebDriverInvoker webDriverInvoker) {
        this.webDriverInvoker = webDriverInvoker;
    }

    public WebDriver getWebDriver() {
        return webDriverInvoker.invokeWebDriver();
    }


}