package driverone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBuilder {

    WebDriver driver;


    public WebDriverBuilder setChromeDriver() {
        this.driver = new ChromeDriver();
        return this;
    }

    public WebDriverBuilder setFirefoxDriver() {
        this.driver = new FirefoxDriver();
        return this;
    }

    public WebDriverManager build() {
        return new WebDriverManager(this);
    }
}

