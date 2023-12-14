package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NavigateToProductDetailPageTest extends BaseTest{

    @Test
    public void navigateToProductDetailPageTest(){
        //Arrange
        String productName = "//a[contains(.,'12 Ti Xelium Skis')]";
        //Act
        String foundProductName = driver.findElement(By.xpath(productName)).getText();
        driver.findElement(By.xpath(productName)).click();
        String productTitle = driver.findElement(By.xpath("//h1")).getText();
        //Assert
        assertEquals(foundProductName,productTitle);

    }
}
