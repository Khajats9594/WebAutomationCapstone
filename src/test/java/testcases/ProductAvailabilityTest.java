package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class ProductAvailabilityTest extends BaseTest {

    @Test
    public void verifyProductAvailability() {
        //Arrange
        String productName = "//a[contains(.,'12 Ti Xelium Skis')]";
        String productTitle = "//h1";
        String addToChat = "//button[@name='add']";

        //Act
        driver.findElement(By.xpath(productName)).click();
        boolean availability = !driver.findElements(By.xpath(productTitle)).isEmpty();
        if (availability) {
            String addToCatText = driver.findElement(By.xpath(addToChat)).getText();
            System.out.println("product is available" +addToCatText);
        }else{
            String addToCatText = driver.findElement(By.xpath(addToChat)).getText();
            System.out.println("product is out of stock"+addToCatText);
        }
    }
}
