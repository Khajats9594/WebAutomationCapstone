package pages;

import enums.WaitStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ProductDetailsPage extends BasePage {

    protected ProductDetailsPage(){}
    private static final Logger logger = LogManager.getLogger(ProductDetailsPage.class);

    public static ProductDetailsPage getInstance(){
        return new ProductDetailsPage();
    }
    private final By productTitle = By.xpath("//h1");
    private final By addToCart = By.xpath("//button[@name='add']");
    private final By toastMessage = By.xpath("//div[@id='cart-notification']/div/h2");
    private final By viewCart = By.xpath("//a[@id='cart-notification-button']");

    public String getProductTitle(){
        return getText(productTitle, WaitStrategy.NONE);
    }
    public String getAddToCartText(){
        return getText(addToCart,WaitStrategy.NONE);
    }

    public boolean verifyProductAvailability(){
        String text = getText(addToCart, WaitStrategy.NONE);
        if(text.equalsIgnoreCase(" Sold out")){
            logger.error("Product is out of Stock");
            return false;
        }
        return true;
    }
    public boolean isAddToCartEnable(){
        return isEnable(addToCart);
    }
    public ProductDetailsPage addToCart(){
        click(addToCart,WaitStrategy.NONE);
        return this;
    }
    public String getSuccessMessageOfADDToCart(){
        return getText(toastMessage,WaitStrategy.VISIBLE);
    }
    public CartPage clickViewCartPageBtn(){
        click(viewCart,WaitStrategy.VISIBLE);
        return new CartPage();
    }


}
