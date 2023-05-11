import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import Tools.TestRunner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

public class LoginTests extends TestRunner {
    private static HomePage homePage;


    @BeforeAll
    public static void classSetup() {
        homePage = new HomePage();
        HomePage.NavigateToHome_Page();
    }
    @BeforeEach
    public void Each() {
        LoginPage.NavigateToLogin_Page();
    }
    @AfterAll
    public static void classCancel(){
        CloseDriver();
    }

    @Test
    public void LoginScreenOpened() {
        LoginPage.NavigateToLogin_Page();
    }
    @Test
    public void ErrorMessageTesting(){
        LoginPage.NavigateToLogin_Page();
        LoginPage.ErrorMessage_EmptyField();
    }

    @ParameterizedTest
    @MethodSource("provideEmailAndPassword")
    public void testErrorMessage(String email, String password) {
        LoginPage.ErrorMessage_IncorrectData(email, password);
    }

    private static Stream<Arguments> provideEmailAndPassword() {
        return Stream.of(
                Arguments.of("true", "true"),
                Arguments.of("", "true"),
                Arguments.of("email@qwe.com", ""),
                Arguments.of("email@qwe.com", "123456"),
                Arguments.of("><?>?<><>?", "><?<>?<>"),
                Arguments.of("email@qwe.com", ""),
                Arguments.of("semper@gmail.com", "asdzxc74@@@"),
                Arguments.of("email@qwe.com", "ujsdfahkfuydsvgbjkcnhkasdhckajhsbfkabencbasjhcbjhsabejhcbasebcjhasbfdjeancjknqaecbfhehjkasbfjhdkbasjfbneascjnbeascjbheasbfbasjbcbncbaskj"),
                Arguments.of("ujsdfahkfuydsvgbjkcnhkasdhckajhsbfkabencbasjhcbjhsabejhcbasebcjhasbfdjeancjknqaecbfhehjkasbfjhdkbasjfbneascjnbeascjbheasbfbasjbcbncbaskj", "asdzxc74@")
        );
    }


}