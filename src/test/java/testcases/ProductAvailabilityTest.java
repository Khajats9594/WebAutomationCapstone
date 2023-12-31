package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.ProductDetailsPage;

public class ProductAvailabilityTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(ProductAvailabilityTest.class);

    @Test
    public void verifyProductAvailability() {
        //Arrange
        String productName = "12 Ti Xelium Skis";
        logger.info("Product detail page is testing using productName {}", productName);

        //Act
        String addToCartText = LandingPage.getInstance()
                .navigateToProductPage(productName)
                .getAddToCartText();
        logger.info("Add to cart message is {}", addToCartText);

        //Assert
        if (addToCartText.equalsIgnoreCase("Sold out")) {
            logger.error("Product is out of stock");
            Assert.fail("Product is out of stock, ending test.");
        } else {
            logger.info("Product is available, proceeding with the test.");
            ProductDetailsPage.getInstance()
                    .addToCart();
        }
    }
}
