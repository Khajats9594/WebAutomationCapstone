package drivertwo;

import drivertwo.entity.WebDriverData;
import org.openqa.selenium.WebDriver;

public interface IWebDriver {

    WebDriver getDriver(WebDriverData driverData);
}
