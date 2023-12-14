package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartForAvailableProductTest extends BaseTest{

    private static final Logger logger = LogManager.getLogger(AddToCartForAvailableProductTest.class);

    @Test(description = "verify the add to cart for availability product")
    public void verifyAddToCartForAvailableProduct() throws InterruptedException {

        //Arrange
        String productName = "//a[contains(.,'15mm Combo Wrench')]";
        String addToCart = "//button[@name='add']";
        String cartMessageText = "//div[@id='cart-notification']/div/h2";
        String viewCartPage = "//a[@id='cart-notification-button']";
        String itemOnCartCount = "//input[@aria-label='Quantity for 15mm Combo Wrench']";

        //Act
        driver.findElement(By.xpath(productName)).click();
        driver.findElement(By.xpath(addToCart)).click();
        String addToCartMessage = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cartMessageText)))
                .getText();
        System.out.println(addToCartMessage+": message");

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(viewCartPage)))
                .click();

        String itemCount = driver.findElement(By.xpath(itemOnCartCount)).getAttribute("value");

        //Assert
        Assert.assertEquals(addToCartMessage,"Item added to your cart","Item added message not found or incorrect.");
        Assert.assertTrue(Integer.valueOf(itemCount) > 0, "Cart item count was not incremented.");
    }
}
