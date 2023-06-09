package Tools;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    private static WebDriver WebDriver;
    protected static WebDriver getWebDriver(){
        if (WebDriver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            WebDriver = new ChromeDriver(options);
            WebDriver.manage().window().maximize();

        }
        return WebDriver;
    }

    public static void closeDriver() {
        if (WebDriver != null) {
            WebDriver.quit();
        }
    }

}
