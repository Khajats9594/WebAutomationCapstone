package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.ProductDetailsPage;

import java.time.Duration;

public class AddToCartForAvailableProductTest extends BaseTest{

    private static final Logger logger = LogManager.getLogger(AddToCartForAvailableProductTest.class);

   // @Test(description = "verify the add to cart for availability product")
    public void verifyAddToCartForAvailableProduct() throws InterruptedException {

        //Arrange
        String productName = "//a[contains(.,'15mm Combo Wrench')]";
        String addToCart = "//button[@name='add']";
        String cartMessageText = "//div[@id='cart-notification']/div/h2";
        String viewCartPage = "//a[@id='cart-notification-button']";
        String itemOnCartCount = "//input[@aria-label='Quantity for 15mm Combo Wrench']";

        //Act
       /* driver.findElement(By.xpath(productName)).click();
        driver.findElement(By.xpath(addToCart)).click();
        String addToCartMessage = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cartMessageText)))
                .getText();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(viewCartPage)))
                .click();

        String itemCount = driver.findElement(By.xpath(itemOnCartCount)).getAttribute("value");*/

        //Assert
  /*      Assert.assertEquals(addToCartMessage,"Item added to your cart","Item added message not found or incorrect.");
        Assert.assertTrue(Integer.parseInt(itemCount) > 0, "Cart item count was not incremented.");*/
    }
   // @Test(description = "verify the add to cart for availability product")
    public void verifyAddToCartForAvailableProduct1(){
        //Arrange
        String productName = "15mm Combo Wrench";
        logger.info("Product detail page is testing using productName is {}",productName);

        //Act
        String countOfProductInCart = LandingPage.getInstance()
                .navigateToProductPage(productName)
                .addToCart()
                .clickViewCartPageBtn()
                .getCountOfProductInCart(productName);
        int countOfProduct = Integer.parseInt(countOfProductInCart);
        logger.info("Count of product for product name {} is {} ",productName,countOfProduct);

        //Assert
        Assert.assertTrue(countOfProduct > 0, "Cart item count was not incremented.");
    }

    //@Test
    public void verifyAddToCartMessage(){
        //Arrange
        String productName = "15mm Combo Wrench";
        logger.info("Product detail page is testing using productName is {}",productName);

        //Act
        String messageOfADDToCart = LandingPage.getInstance()
                .navigateToProductPage(productName)
                .addToCart()
                .getSuccessMessageOfADDToCart();
        logger.info("Message is display when the product is add to cart is {}",messageOfADDToCart);

        String countOfProductInCart = ProductDetailsPage.getInstance()
                .clickViewCartPageBtn()
                .getCountOfProductInCart(productName);
        int countOfProduct = Integer.parseInt(countOfProductInCart);
        logger.info("Count of product for product name {} is {} ",productName,countOfProduct);

        //Assert
        Assert.assertEquals(messageOfADDToCart,"Item added to your cart","Item added message not found or incorrect.");
        Assert.assertTrue(countOfProduct > 0, "Cart item count was not incremented.");
    }
    @Test

    public void addCart(){
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://web-playground.ultralesson.com/");

        String productNameToSelect = "15mm Combo Wrench";
        String productNavigationURL = "/products/";
        WebElement product = driver.findElement(By.xpath("//a[normalize-space()='15mm Combo Wrench']"));
        product.click();

        //get the initial cart item count
        WebElement cartItemCount = driver.findElement(By.xpath("//*[contains(@class, 'icon-cart')]"));
        String initialItemCount=cartItemCount.getAttribute("class").contains("empty")?"0":driver.findElement(By.className("cart-count-bubble")).getText();
        // System.out.println(items);

        WebElement addToCart = driver.findElement(By.xpath("//button[@name='add']"));
        addToCart.click();

        //wait for the message to be appear
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Item added to your cart']")));
        assert message.getText().contains("Item added to your cart");

        //verify that the cart item count is incremented
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.className("cart-count-bubble"), initialItemCount)));
        // WebElement updatedCount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='cart-icon-bubble']//*[name()='svg']")));
        String finalItemCount = driver.findElement(By.className("cart-count-bubble")).getText();

        assert !initialItemCount.equals(finalItemCount) : "Assertion failed: Cart item count not incremented.";

        System.out.println("Test passed: Product added to the cart and cart item count incremented successfully.");

    }
}
