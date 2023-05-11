package Pages;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Assertions;

public class CartPage extends BasePage {
    private static final org.apache.logging.log4j.Logger Logger = LogManager.getLogger(CartPage.class);
    private static final String CART_PAGE = "https://kidkiddos.com/cart";
    private static final String IMG_XPath = "//img[@src='//cdn.shopify.com/s/files/1/1788/1145/files/logo_kidkiddos_line_web6_600x_2x_1_1_600x.png?v=1623743080']";

    public static void NavigateToCart_Page() {
        BasePage.clickOnElement("//a[@href='/cart']");
        Assertions.assertTrue(BasePage.Compare_URL(CART_PAGE));
        Logger.info("Cart_Page was opened");
    }

    public static void ChangeQuantity() {
        String QuantityField = "//input[@name='updates[]']";
        String Quantity = "6";
        String expectedPrice = "203,94";
        BasePage.findElementByXpath(QuantityField).clear();
        BasePage.clickOnElement(QuantityField);
        BasePage.sendKeys(QuantityField, Quantity);
        BasePage.clickOnElement("//*[@class='grid__item text-right small--text-center']//descendant::*[@type='submit' and @value='Update']");
        BasePage.pause();
        BasePage.findElementByXpath(QuantityField);
        String actualValue = BasePage.findElementByXpath(QuantityField).getAttribute("value");
        Assertions.assertEquals(actualValue, Quantity);
        String actualPrice = BasePage.findElementByXpath("//span[@class='cart__subtotal']//descendant::span[@class='cbb-price-digits' and @style='padding: 0px 1px; color: inherit; float: none;']").getText();
        Assertions.assertEquals(expectedPrice, actualPrice);
        Logger.info("Quantity was successfully updated for 6 books price is - " + actualPrice);


    }

}



