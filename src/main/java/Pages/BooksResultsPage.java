package Pages;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Assertions;

public class BooksResultsPage extends BasePage{
    private static final String COLLECTIONS_PAGE = "https://kidkiddos.com/collections/english-only";
    private static final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(BooksResultsPage.class);
    public static void NavigateToBooksResults_Page() {
        BasePage.clickOnElement("//a[@href='/collections' and @aria-controls]");
        BasePage.clickOnElement("//a[@href='/collections/english-only' and @class = 'site-nav__link site-nav__child-link']");
        Assertions.assertTrue(BasePage.Compare_URL(COLLECTIONS_PAGE));
        Logger.info("Books Results was opened");
    }
}

