package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import utiles.DynamicXpath;

public class LandingPage extends BasePage{

    private LandingPage(){}

    public static LandingPage getInstance(){
        return new LandingPage();
    }

    private final String product = "//a[contains(.,'%replaceable%')]";

    public ProductDetailsPage getProduct(String productName){
        click(By.xpath(DynamicXpath.getXpath(product,productName)), WaitStrategy.VISIBLE);
        return new ProductDetailsPage();
    }

}
