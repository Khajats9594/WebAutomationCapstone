package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NavigateToProductDetailPageTest extends BaseTest{

    @Test
    public void navigateToProductDetailPageTest(){
        String productName = driver.findElement(By.xpath("//a[contains(.,'12 Ti Xelium Skis')]")).getText();
        driver.findElement(By.xpath("//a[contains(.,'12 Ti Xelium Skis')]")).click();
        String productTitle = driver.findElement(By.xpath("//h1")).getText();
        assertEquals(productName,productTitle);

    }
}
