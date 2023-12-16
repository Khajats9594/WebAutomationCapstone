package drivertwo.imp;

import drivertwo.IWebDriver;
import drivertwo.entity.WebDriverData;
import drivertwo.factory.local.LocalDriverFactory;
import org.openqa.selenium.WebDriver;

public  class LocalWebDriverImp implements IWebDriver {

    @Override
    public WebDriver getDriver(WebDriverData driverData) {
        return LocalDriverFactory.getDriver(driverData.getBrowserType());
    }
}
