package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        if(addToCatText.equalsIgnoreCase("Sold out")){
            Assert.assertEquals(addToCatText,"Buy it now","product is out of stock");
            System.out.println("product is out of stock");
        }else {
            driver.findElement(By.xpath(addToChat)).click();
            System.out.println("product is available");
        }

    }
}
