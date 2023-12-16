package drivertwo.factory.remote;

import enums.BrowserRemoteModeType;
import enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class RemoteDriverFactory {

    private RemoteDriverFactory(){}

    public static WebDriver getDriver(BrowserRemoteModeType browserRemoteModeType, BrowserType browserType){

        if(browserRemoteModeType == BrowserRemoteModeType.SELENIUM){
            return SeleniumGridFactory.getDriver(browserType);
        } else if (browserRemoteModeType == BrowserRemoteModeType.BROWSERSTACK){
            return BrowserstackFactory.getDriver(browserType);
        }
        return null;
    }
}
