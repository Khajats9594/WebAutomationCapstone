package drivertwo.manager.remote.selenium;


import config.factory.ConfigFactory;
import enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class SeleniumGridFireFoxManager {

    private SeleniumGridFireFoxManager(){}

    public static WebDriver getDriver(){
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName(String.valueOf(BrowserType.FIREFOX));
        return new RemoteWebDriver(ConfigFactory.getConfig().seleniumGridUrl(), cap);
    }
}
