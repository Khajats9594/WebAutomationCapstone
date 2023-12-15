package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;

public class ProductRemovableTest extends BaseTest{

    private static final Logger logger = LogManager.getLogger(ProductRemovableTest.class);

    @Test
    public void productRemovableTest(){
        //Arrange
        String productName = "15mm Combo Wrench";
        logger.info("Product detail page is testing using productName is {}",productName);

        //Act
        boolean verifiedProductRemovable = LandingPage.getInstance()
                .navigateToProductPage(productName)
                .addToCart()
                .clickViewCartPageBtn()
                .removeProduct(productName)
                .isProductRemoved(productName);
        logger.info("Product is removed? {}",verifiedProductRemovable);

        //Assert
        Assert.assertTrue(verifiedProductRemovable, "Given product is not removed");
    }
}
