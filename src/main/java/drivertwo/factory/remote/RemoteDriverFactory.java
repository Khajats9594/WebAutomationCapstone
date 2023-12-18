package drivertwo.factory.remote;

import enums.BrowserRemoteModeType;
import enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class RemoteDriverFactory {

    private RemoteDriverFactory(){}

    public static WebDriver getDriver(BrowserRemoteModeType browserRemoteModeType, BrowserType browserType){

      return  browserRemoteModeType == BrowserRemoteModeType.SELENIUM
                ? SeleniumGridFactory.getDriver(browserType)
                : BrowserstackFactory.getDriver(browserType);
    }
}
