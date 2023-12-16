package drivertwo;

import config.factory.ConfigFactory;
import drivertwo.entity.WebDriverData;
import drivertwo.factory.DriverFactory;
import enums.ConfigProperties;
import org.openqa.selenium.WebDriver;
import utiles.PropertyUtils;

public final class Driver {

    private Driver(){}

   static WebDriver driver;

    public static void initDriver(){
        WebDriverData webDriverData = WebDriverData.builder()
                .browserRunModeType(ConfigFactory.getConfig().browserRunMode())
                .browserRemoteModeType(ConfigFactory.getConfig().browserRemoteMode())
                .browserType(ConfigFactory.getConfig().browser())
                .build();
        WebDriver driver = DriverFactory.getDriverForWeb(webDriverData);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));

    }
    public static void quitDriver(){
       DriverManager.getDriver().quit();
    }
}
