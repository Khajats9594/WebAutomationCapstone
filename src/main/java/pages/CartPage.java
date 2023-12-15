package pages;

import entity.Product;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import utiles.DynamicXpath;

public class CartPage extends BasePage{

    protected CartPage(){}

    public static CartPage getInstance(){
        return new CartPage();
    }
    String productCount = "//input[@aria-label='Quantity for %replaceable%']";
    String product = "//input[@aria-label='Quantity for %replaceable%']/ancestor::tr//td[@class='cart-item__details']//a";
    String productPrice = "//input[@aria-label='Quantity for %replaceable%']/ancestor::tr//td[@class='cart-item__totals right small-hide']//span";
    String remove = "//a[@aria-label='Remove %replaceable% - %replaceable%']";

    ////input[@aria-label="Quantity for 15mm Combo Wrench"]/ancestor::tr//td[@class='cart-item__details']//a
    //input[@aria-label="Quantity for 15mm Combo Wrench"]/ancestor::tr//td[@class='cart-item__totals right small-hide']//span
    public String getCountOfProductInCart(String productName){
        return getValueAttribute(By.xpath(DynamicXpath.getXpath(productCount,productName)), WaitStrategy.NONE);
    }
    public Product getDetailsOfProduct(String productName){
        String prod = getText(By.xpath(DynamicXpath.getXpath(product, productName)), WaitStrategy.PRESENCE);
        String count = getValueAttribute(By.xpath(DynamicXpath.getXpath(productCount, productName)), WaitStrategy.NONE);
        String price = getText(By.xpath(DynamicXpath.getXpath(productPrice, productName)), WaitStrategy.NONE);
        System.out.println(prod+" : "+count+" : "+price);

        return Product.builder()
                .setProductName(prod)
                .setProductCount(count)
                .setProductPrice(price)
                .build();
    }

    public boolean verifyProductRemovable(String productName){
        click(By.xpath(DynamicXpath.getXpath(remove,productName)),WaitStrategy.VISIBLE);
        try {
            Thread.sleep(2000);
            boolean present = isPresent(By.xpath(DynamicXpath.getXpath(product, productName)), WaitStrategy.REFRESH);
        }catch (Exception e){
            return true;
        }
        return false;
    }
}
