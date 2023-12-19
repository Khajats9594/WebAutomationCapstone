package pages;

import entity.Registration;
import entity.RegistrationData;
import enums.WaitStrategy;
import org.openqa.selenium.By;

import java.util.Map;

public final class CreateAccountPage extends BasePage {

    public static CreateAccountPage getInstance() {
        return new CreateAccountPage();
    }

    private final By firstName = By.xpath("//input[@id='RegisterForm-FirstName']");
    private final By lastName = By.xpath("//input[@id='RegisterForm-LastName']");
    private final By email = By.xpath("//input[@id='RegisterForm-email']");
    private final By password = By.xpath("//input[@id='RegisterForm-password']");
    private final By clickBtn = By.xpath("//button[contains(text(),'Create')]");

    private final By passwordErrorMessage = By.xpath("//a[contains(text(),'is too short (minimum is ')]");
    private final By emailErrorMessage = By.xpath("//a[contains(text(),'is invalid')]");

    public LandingPage createAccountForValidData(Registration validRegistrationDetail) {
        createAccount(validRegistrationDetail);
        return new LandingPage();
    }

    private void createAccount(Registration registrationDetail) {
        sendKey(firstName, registrationDetail.getFirstName(), WaitStrategy.VISIBLE);
        sendKey(lastName, registrationDetail.getLastName(), WaitStrategy.VISIBLE);
        sendKey(email, registrationDetail.getEmail(), WaitStrategy.VISIBLE);
        sendKey(password, registrationDetail.getPassword(), WaitStrategy.VISIBLE);
        click(clickBtn, WaitStrategy.VISIBLE);
    }

    public CreateAccountPage createAccountForInvalidData(Registration InvalidUserDetail) {
        createAccount(InvalidUserDetail);
        return this;
    }

    public Map<String, String> getErrorMessagesOfRegistrationForm() {
        String pwderrorMessage = getErrorMessage(passwordErrorMessage);
        String emailerrorMessage = getErrorMessage(emailErrorMessage);
        return Map.of("passwordErrorMessage", pwderrorMessage,
                "emailErrorMessage", emailerrorMessage);
    }
    private String getErrorMessage(By by){
        try {
            return getText(by,WaitStrategy.VISIBLE);
        }catch (Exception e){
            return null;
        }
    }
}
