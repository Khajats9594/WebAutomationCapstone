package testcases;

import entity.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LandingPage;

public class ProductContentTest extends BaseTest{

    private static final Logger logger = LogManager.getLogger(ProductContentTest.class);

    @Test
    public void verifyProductContent(){
        //Arrange
        String productName = "15mm Combo Wrench";
        logger.info("Product detail page is testing using productName is {}",productName);

        //Act
        Product detailsOfProduct = LandingPage.getInstance()
                .getProduct(productName)
                .clickAddToCart()
                .clickViewCartPageBtn()
                .getDetailsOfProduct(productName);
        logger.info("Details of product which is selected is {}",detailsOfProduct);

        //Assert
        Assert.assertEquals(detailsOfProduct.getProductName(),productName,"product name is not matched");
        Assert.assertEquals(detailsOfProduct.getProductCount(),"1","product count did not matched");
        Assert.assertEquals(detailsOfProduct.getProductPrice(),"Rs. 10.99","product price did not mathced");
    }
}
