package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class LoginPage extends BasePage {

    public static LoginPage getInstance(){
        return new LoginPage();
    }
    private final By createAccountLink = By.xpath("//a[normalize-space()='Create account']");

    public CreateAccountPage navigateToCreateAccountPage(){
        click(createAccountLink, WaitStrategy.VISIBLE);
        return new CreateAccountPage();
    }
}
