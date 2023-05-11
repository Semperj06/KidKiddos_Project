import Pages.*;
import Tools.TestRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BooksTests extends TestRunner {
    private static HomePage homePage;

    @BeforeAll
    public static void classSetup() {
        homePage = new HomePage();
        HomePage.NavigateToHome_Page();
    }

    @BeforeEach
    public void Each() {BooksResultsPage.NavigateToBooksResults_Page();}
    @AfterAll
    public static void classCancel(){
        CloseDriver();
    }

    @Test
    public void BooksResultsTesting() {
        BooksResultsPage.NavigateToBooksResults_Page();
        ProductPage.NavigateToProduct_Page();
        ProductPage.SetupValueOnProduct_Page();
        CartPage.NavigateToCart_Page();
        CartPage.ChangeQuantity();
    }






}
