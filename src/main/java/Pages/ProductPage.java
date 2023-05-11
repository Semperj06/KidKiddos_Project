package Pages;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Assertions;

public class ProductPage extends BasePage{
    private static final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(ProductPage.class);
    private static final String PRODUCT_PAGE = "https://kidkiddos.com/collections/english-only/products/i-love-to-eat-fruits-and-vegetables-childrens-book-english-only";
    private static final String PRODUCT_PATH = "//img[@src='//cdn.shopify.com/s/files/1/1788/1145/products/I-Love-to-Eat-Fruits-and-Vegetables-kids-bedtime-story-english-cover_195x195@2x.jpg?v=1492987398']";
    public static void NavigateToProduct_Page(){
        BasePage.clickOnElement(PRODUCT_PATH);
        Assertions.assertEquals(webDriver.getCurrentUrl(), PRODUCT_PAGE);
        Logger.info("Page of Product was opened");
    }
    public static void SetupValueOnProduct_Page(){
        BasePage.clickOnElement("//div[@class='selector-wrapper js product-form__item']//descendant::*[@id='SingleOptionSelector-0']");
        BasePage.clickOnElement("//div[@class='selector-wrapper js product-form__item']//descendant::*[@id='SingleOptionSelector-0']//descendant::*[@value='Hardcover']");
        Logger.info("Changed on hardcover format");
        BasePage.findElementByXpath("//input[@id='Quantity']").clear();
        BasePage.sendKeys("//input[@id='Quantity']", "5");
        BasePage.clickOnElement("//span[@id='AddToCartText-product-template']");
        Logger.info("Quantity was chosen and we navigate to Cart");




    }
}
