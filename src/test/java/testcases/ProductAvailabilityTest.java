package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductAvailabilityTest extends BaseTest {

    @Test
    public void verifyProductAvailability() {
        try {
            //Arrange
            String productName = "//a[contains(.,'12 Ti Xelium Skis')]";
            String addToCart = "//button[@name='add']";

            //Act
            driver.findElement(By.xpath(productName)).click();
            String addToCatText = driver.findElement(By.xpath(addToCart)).getText();

            //Assert
            if (addToCatText.equalsIgnoreCase("Sold out")) {
                System.out.println("product is out of stock");
                Assert.fail("product is out of stock");
            } else {
                driver.findElement(By.xpath(addToCart)).click();
                System.out.println("product is available");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element not found ");
            Assert.fail("Element not found ");
        }

    }
}
