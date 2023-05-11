package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class BasePage {
    protected static WebDriver webDriver;
    protected static WebDriverWait wait;

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    }
    protected static void clickOnElement(String xpath){
        findElementByXpath(xpath).click();
    }



    protected static boolean elementExists(String xpath){
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            webDriver.findElement(By.xpath(xpath));
            return true;
        }
        catch (Exception err) {
            return false;
        }
    }

    protected static boolean Compare_URL(String Expected_url) {
        if (Objects.equals(Expected_url, webDriver.getCurrentUrl())){
            return true;
        }
        else {
            return false;
        }

    }

    protected static WebElement findElementByXpath(String xpath) {
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element = webDriver.findElement(By.xpath(xpath));
        return element;
    }

    protected static void sendKeys(String xpath, String keys){
        WebElement element = findElementByXpath(xpath);
        clickOnElement(xpath);
        element.sendKeys(keys);

    }
    protected static void pause(){
        try {
            Thread.sleep(3000);
        } catch (Exception err) {
            System.out.println("Something went wrong");
        }
    }
}
