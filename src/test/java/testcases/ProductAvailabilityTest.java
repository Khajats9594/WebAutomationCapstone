package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductAvailabilityTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(ProductAvailabilityTest.class);

    @Test
    public void verifyProductAvailability() {
        try {
            //Arrange
            logger.info("Execution started");
            String productName = "//a[contains(.,'12 Ti Xelium Skis')]";
            String addToCart = "//button[@name='add']";

            //Act
            driver.findElement(By.xpath(productName)).click();
            String addToCatText = driver.findElement(By.xpath(addToCart)).getText();

            //Assert
            if (addToCatText.equalsIgnoreCase("Sold out")) {
                logger.error("Product is out of stock");
                Assert.fail("Product is out of stock, ending test.");
            } else {
                logger.info("Product is available, proceeding with the test.");
                driver.findElement(By.xpath(addToCart)).click();
            }
        } catch (NoSuchElementException e) {
            logger.error("Element not found: " + e.getMessage());
            Assert.fail("Element not found, ending test.");
        }

    }
}
