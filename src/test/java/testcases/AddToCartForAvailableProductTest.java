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
    public void verifyAddToCartForAvailableProduct(){

        //Arrange
        String productName = "//a[contains(.,'15mm Combo Wrench')]";
        String addToCart = "//button[@name='add']";
        String cartMessageText = "//div[@class='cart-notification__header']";
        String viewCartPage = "//a[@id='cart-notification-button']";
        String itemOnCartCount = "//input[@aria-label='Quantity for 15mm Combo Wrench']";

        //Act
        driver.findElement(By.xpath(productName)).click();
        driver.findElement(By.xpath(addToCart)).click();
        String element = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(cartMessageText)))
                .getText();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(viewCartPage)))
                .click();

        String value = driver.findElement(By.xpath(itemOnCartCount)).getAttribute("value");

        //Assert
        Assert.assertEquals(value,"1","Product is not added properly");
    }
}
