package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pages.LandingPage;

import static org.testng.Assert.assertEquals;

public class NavigateToProductDetailPageTest extends BaseTest{

    private static final Logger logger = LogManager.getLogger(NavigateToProductDetailPageTest.class);

    @Test
    public void navigateToProductDetailPageTest(){
        //Arrange
        String productName = "12 Ti Xelium Skis";
        logger.info("Product detail page is testing using productName {}",productName);

        //Act
        String productTitle = LandingPage.getInstance()
                .navigateToProductPage(productName)
                .getProductTitle();
        logger.info("In product Details page the productName is {}", productTitle);

        //Assert
        assertEquals(productTitle,productName,"The product name does not match in the product Detail page");

    }
}
