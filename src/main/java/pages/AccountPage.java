package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class AccountPage extends BasePage {

    public static AccountPage getInstance(){
        return new AccountPage();
    }

    private final By accountDetails = By.xpath("//h2[normalize-space()='Account details']");

    public String verifyLoginFunction(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return getText(accountDetails, WaitStrategy.VISIBLE);
    }
}
