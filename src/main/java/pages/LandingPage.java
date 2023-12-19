package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import utiles.DynamicXpath;

public class LandingPage extends BasePage{


    public static LandingPage getInstance(){
        return new LandingPage();
    }

    private final String product = "//a[contains(.,'%replaceable%')]";
    private final By loginLink = By.xpath("//a[@class='header__icon header__icon--account link focus-inset small-hide']");
    private final By account = By.xpath("//a[@class='header__icon header__icon--account link focus-inset small-hide']");
    private final By searchBtn = By.xpath("//summary[@aria-label='Search']");
    private final By searchBar = By.xpath("//input[@id='Search-In-Modal']");


    public ProductDetailsPage navigateToProductPage(String productName){
        click(By.xpath(DynamicXpath.getXpath(product,productName)), WaitStrategy.NONE);
        return new ProductDetailsPage();
    }
    public LoginPage navigateToLoginPage(){
        click(loginLink,WaitStrategy.CLICKABLE);
        return new LoginPage();
    }
    public AccountPage navigateRegisterAccountPage(){
        click(account,WaitStrategy.NONE);
        return new AccountPage();
    }
    public LandingPage clickSearchBtn(){
        click(searchBtn,WaitStrategy.CLICKABLE);
        return this;
    }
    public SearchPage searchProduct(String productName){
        sendKey(searchBar,productName,WaitStrategy.PRESENCE);
        return new SearchPage();
    }

}
