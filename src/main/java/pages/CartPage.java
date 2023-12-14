package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import utiles.DynamicXpath;

public class CartPage extends BasePage{

    protected CartPage(){}

    public static CartPage getInstance(){
        return new CartPage();
    }
    //15mm Combo Wrench
    String itemCount = "//input[@aria-label='Quantity for %replaceable%']";
    public String getCountOfProductInCart(String productName){
        return getText(By.xpath(DynamicXpath.getXpath(itemCount,productName)), WaitStrategy.NONE);
    }
}
