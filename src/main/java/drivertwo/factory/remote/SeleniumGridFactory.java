package drivertwo.factory.remote;

import drivertwo.manager.remote.selenium.SeleniumGridChromeManager;
import drivertwo.manager.remote.selenium.SeleniumGridFireFoxManager;
import enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class SeleniumGridFactory {

    private SeleniumGridFactory(){}

    public static WebDriver getDriver(BrowserType browserType){
       return browserType == BrowserType.CHROME
                ? SeleniumGridChromeManager.getDriver()
                : SeleniumGridFireFoxManager.getDriver();
    }
}
