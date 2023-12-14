package pages;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected BasePage() {

    }

    protected void sendKey(By by, String value, WaitStrategy waitingStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitingStrategy, by);
        element.sendKeys(value);
    }

    protected void click(By by, WaitStrategy waitingStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitingStrategy, by);
        element.click();
    }

    protected String getText(By by,WaitStrategy waitStrategy) {
        return ExplicitWaitFactory.performExplicitWait(waitStrategy,by)
                .getText();
    }
}
