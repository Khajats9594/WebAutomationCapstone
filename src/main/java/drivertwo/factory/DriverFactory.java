package drivertwo.factory;


import drivertwo.imp.LocalWebDriverImp;
import drivertwo.imp.RemoteWebDriverImp;
import drivertwo.entity.WebDriverData;
import enums.BrowserRunModeType;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private DriverFactory(){}

    public static WebDriver getDriverForWeb(WebDriverData webDriverData){
       return webDriverData.getBrowserRunModeType() == BrowserRunModeType.LOCAL
                ? new LocalWebDriverImp().getDriver(webDriverData)
                : new RemoteWebDriverImp().getDriver(webDriverData);

    }
}
