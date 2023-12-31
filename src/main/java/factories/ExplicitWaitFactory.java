package factories;

import constants.FrameworkConstants;
import drivertwo.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ExplicitWaitFactory {

    private ExplicitWaitFactory() {
    }


    public static WebElement performExplicitWait(WaitStrategy waitstrategy, By by) {
        WebElement element = null;
        if (waitstrategy == WaitStrategy.CLICKABLE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitstrategy == WaitStrategy.PRESENCE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } else if (waitstrategy == WaitStrategy.VISIBLE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitstrategy == WaitStrategy.REFRESH) {
            new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
                    .until(d->{
                        d.navigate().refresh();
                        return d.findElement(by);
                    });
        } else if (waitstrategy == WaitStrategy.NONE) {
            element = DriverManager.getDriver().findElement(by);
        }
        return element;
    }
}
