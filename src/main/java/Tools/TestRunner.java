package Tools;

import Pages.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class TestRunner {
    private static WebDriver webDriver;
    private static BasePage page;

    @BeforeAll
    public static void setupMain() {
        page = new BasePage();
        webDriver = WebDriverFactory.getWebDriver();
        page.setWebDriver(webDriver);
    }

    @AfterAll
    public static void CloseDriver(){
        WebDriverFactory.closeDriver();
        webDriver = null;
    }

}
