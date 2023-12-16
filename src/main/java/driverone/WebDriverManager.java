package driverone;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {
    private WebDriver driver;

    WebDriverManager(WebDriverBuilder builder) {
        this.driver = builder.driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
