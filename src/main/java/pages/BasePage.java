package pages;

import drivertwo.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected BasePage() {

    }
    private static final Logger logger = LogManager.getLogger(BasePage.class);
    protected void sendKey(By by, String value, WaitStrategy waitingStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitingStrategy, by);
        element.sendKeys(value, Keys.ENTER);
        logger.info("{} value enter into the element : {}",value,element);
    }

    protected void click(By by, WaitStrategy waitingStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitingStrategy, by);
        element.click();
        logger.info("{} is clicked ",element);
    }

    protected String getText(By by,WaitStrategy waitStrategy) {
        String textOfElement = ExplicitWaitFactory.performExplicitWait(waitStrategy, by).getText();
        logger.info("{} is fetched",textOfElement);
        return textOfElement;
    }

    protected String getValueAttribute(By by, WaitStrategy waitStrategy){
        String value = ExplicitWaitFactory.performExplicitWait(waitStrategy, by).getAttribute("value");
        logger.info("value fetch from value attribute is {}",value);
        return value;
    }

    protected boolean isPresent(By by, WaitStrategy waitStrategy){
        return ExplicitWaitFactory.performExplicitWait(waitStrategy,by).isDisplayed();
    }

    protected String getTitle(){
        return DriverManager.getDriver().getTitle();
    }
    protected boolean isEnable(By by){
        return DriverManager.getDriver().findElement(by).isEnabled();
    }
}
