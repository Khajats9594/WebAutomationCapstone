package drivertwo.imp;

import drivertwo.IWebDriver;
import drivertwo.entity.WebDriverData;
import drivertwo.factory.remote.RemoteDriverFactory;
import org.openqa.selenium.WebDriver;

public class RemoteWebDriverImp implements IWebDriver {

    @Override
    public WebDriver getDriver(WebDriverData webDriverData) {
        return RemoteDriverFactory.getDriver(webDriverData.getBrowserRemoteModeType()
                ,webDriverData.getBrowserType());
    }
}
