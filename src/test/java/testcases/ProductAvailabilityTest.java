package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductAvailabilityTest extends BaseTest {

    @Test
    public void verifyProductAvailability(){
        //Arrange
        String productName = "//a[contains(.,'12 Ti Xelium Skis')]";
        String addToChat = "//button[@name='add']";

        //Act
        driver.findElement(By.xpath(productName)).click();
        String addToCatText = driver.findElement(By.xpath(addToChat)).getText();

        //Assert
        assertEquals(addToCatText,"Sold out","product is out of stock");

    }
}
