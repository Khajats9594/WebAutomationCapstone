package drivertwo.factory.local;

import config.factory.ConfigFactory;
import drivertwo.manager.local.ChromeManager;
import drivertwo.manager.local.FireFoxManager;
import enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class LocalDriverFactory {

    private LocalDriverFactory(){}

    public static WebDriver getDriver(BrowserType browserType){
        return isBrowserChrome()
                ? ChromeManager.getDriver()
                : FireFoxManager.getDriver();

    }
    private static boolean isBrowserChrome() {
        return ConfigFactory.getConfig()
                .browser() == BrowserType.CHROME;
    }
}
