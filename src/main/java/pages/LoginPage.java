package pages;

import entity.User;
import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class LoginPage extends BasePage {

    public static LoginPage getInstance(){
        return new LoginPage();
    }
    private final By createAccountLink = By.xpath("//a[normalize-space()='Create account']");
    private final By emailTxt = By.xpath("//input[@id='CustomerEmail']");
    private final By passwordText = By.xpath("//input[@id='CustomerPassword']");
    private final By signBtn = By.xpath("//button[normalize-space()='Sign in']");
    private final By accountText = By.xpath("//h1");
    private final By errorMessage = By.xpath("//li[normalize-space()='Incorrect email or password.']");

    public CreateAccountPage navigateToCreateAccountPage(){
        click(createAccountLink, WaitStrategy.VISIBLE);
        return new CreateAccountPage();
    }
    public String verifyingLoginFunctionWithValidData(User validData){
        login(validData);
        return getText(accountText,WaitStrategy.VISIBLE);
    }

    public String verifyingLoginFunctionWithInvalidData(User invalidData){
        login(invalidData);
        return getText(errorMessage,WaitStrategy.VISIBLE);
    }

    private void login(User user) {
        sendKey(emailTxt, user.getEmail(),WaitStrategy.VISIBLE);
        sendKey(passwordText, user.getPassword(),WaitStrategy.VISIBLE);
        click(signBtn,WaitStrategy.CLICKABLE);
    }

}
