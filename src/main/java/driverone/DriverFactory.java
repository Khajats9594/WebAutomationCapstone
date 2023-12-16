package driverone;

import enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();


    private DriverFactory() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static synchronized WebDriver getDriver(BrowserType browserType) {
        if (threadDriver.get() == null) {
            // If the WebDriver instance is not created, create one based on the specified browser type
            switch (browserType) {
                case CHROME:
                    threadDriver.set(new ChromeDriver());
                    break;
                case FIREFOX:
                    threadDriver.set(new FirefoxDriver());
                    break;
                case EDGE:
                    threadDriver.set(new EdgeDriver());
                    break;
                case IE:
                    threadDriver.set(new InternetExplorerDriver());
                    break;
            }
        }
        return threadDriver.get();
    }

    public static synchronized void quitDriver() {
        if (threadDriver.get() != null) {
            threadDriver.get().quit();
            threadDriver.remove(); // Set to null after quitting to allow a new instance to be created if needed
        }
    }
}
