package Pages;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BasePage {

    private static final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(LoginPage.class);
    private static final String LOGIN_PAGE = "https://kidkiddos.com/account/login";

    public static void NavigateToLogin_Page() {
        BasePage.clickOnElement("//a[@href='/account/login']");
        Assertions.assertTrue(BasePage.Compare_URL(LOGIN_PAGE));

        Logger.info("Login_Page was opened");
    }

    public static void ErrorMessage_EmptyField() {
        BasePage.clickOnElement("//input[@value='Sign In']");

        assertTrue(BasePage.elementExists("//*[contains(text(), \"To continue, let us know you're not a robot\")]")
                || BasePage.elementExists("//*[contains(text(), 'Incorrect email or password')]"));
        Logger.info("The error was displayed");
    }

    public static void ErrorMessage_IncorrectData(String email, String password) {
        BasePage.sendKeys("//input[@id='CustomerEmail']", email);
        BasePage.sendKeys("//input[@id='CustomerPassword']", password);
        BasePage.clickOnElement("//input[@value='Sign In']");
        assertTrue(BasePage.elementExists("//*[contains(text(), \"To continue, let us know you're not a robot\")]")
                || BasePage.elementExists("//*[contains(text(), 'Incorrect email or password')]")
                || BasePage.elementExists("//*[contains(text(), 'отсутствует символ')]"));
        Logger.info("The error or warning was displayed");




    }


}



