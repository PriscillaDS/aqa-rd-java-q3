import com.epam.marina_nosadchuk.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Open_link {

    @Test
    public void test() {
        WebDriver webDriver = WebDriverFactory.newWebDriver();

        webDriver.get("https://www.google.com.ua/");
        webDriver.quit();
    }
}
