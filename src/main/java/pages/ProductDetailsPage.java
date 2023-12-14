package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public class ProductDetailsPage extends BasePage {

    protected ProductDetailsPage(){}

    public ProductDetailsPage getInstance(){
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
    public ProductDetailsPage clickAddToCart(){
        click(addToCart,WaitStrategy.NONE);
        return this;
    }
    public String getSuccessMessageOfADDToCart(){
        return getText(toastMessage,WaitStrategy.VISIBLE);
    }
    public CartPage clickViewCartPageBtn(){
        click(viewCart,WaitStrategy.NONE);
        return new CartPage();
    }


}
