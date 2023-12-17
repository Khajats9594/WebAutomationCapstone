package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;

public class ProductSearchTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(ProductSearchTest.class);

    @Test
    public void productSearchTest() throws InterruptedException {

        String productName = "15mm Combo Wrench";
        logger.info("Searching the product using the value {}", productName);

        //Act
        String searchResultText = LandingPage.getInstance()
                .clickSearchBtn()
                .searchProduct(productName)
                .getSearchResultText();
        logger.info("The Result for search is {}", searchResultText);

        //Assert
        Assert.assertTrue(searchResultText.contains(productName), "search result is not matched with search");
    }

}
