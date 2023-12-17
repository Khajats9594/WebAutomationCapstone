package testcases;

import entity.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.ProductDetailsPage;

public class ProductAddToCartContentTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(ProductAddToCartContentTest.class);

    @Test
    public void verifyProductAddToCartContentDetails() {
        //Arrange
        String productName = "15mm Combo Wrench";
        logger.info("Product detail page is testing using productName is {}", productName);

        //Act
        String addToCartText = LandingPage.getInstance()
                .navigateToProductPage(productName)
                .addToCart()
                .getAddToCartText();

        Product detailsOfProduct = null;
        if (addToCartText.equalsIgnoreCase("Sold out")) {
            logger.error("Product is out of stock");
        } else {
            detailsOfProduct = ProductDetailsPage.getInstance()
                    .clickViewCartPageBtn()
                    .getDetailsOfProduct(productName);
            logger.info("Details of product which is selected is {}", detailsOfProduct);
        }

        //Assert
        Assert.assertEquals(detailsOfProduct.getProductName(), productName, "product name is not matched");
        Assert.assertEquals(detailsOfProduct.getProductCount(), "1", "product count did not matched");
        Assert.assertEquals(detailsOfProduct.getProductPrice(), "Rs. 10.99", "product price did not mathced");
    }
}
