package drivertwo.factory.remote;

import drivertwo.manager.remote.browserstack.BrowserStackChromeManager;
import drivertwo.manager.remote.browserstack.BrowserStackFireFoxManager;
import enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class BrowserstackFactory {

    private BrowserstackFactory(){}

    public static WebDriver getDriver(BrowserType browserType){
       return browserType == BrowserType.CHROME
                ? BrowserStackChromeManager.getDriver()
                : BrowserStackFireFoxManager.getDriver();
    }
}
