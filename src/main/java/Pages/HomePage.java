package Pages;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Assertions;

public class HomePage extends BasePage{
    private static final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(HomePage.class);
    private static final String HOME_PAGE = "https://kidkiddos.com/";
    public static void NavigateToHome_Page() {
        webDriver.get(HOME_PAGE);
        Logger.info("Main page was opened");


    }


}
