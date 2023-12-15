package testcases;

import driver.Driver;
import driver.DriverManager;
import enums.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    /*
    Naming standards
    package-name : sample,
    class-name  : pascal case-Example : Sample
    method-name and variable-name : camel case-Example : sampleTest
    constant-name : upper case-Example : SAMPLE
     */
    protected BaseTest() {
    }
     /*
    Principles to keep in mind while developing the framework for web automation:
    1. Organize everything in the right place.
    2. Avoid hardcoding values in the code.
    3. Design the framework to be scalable to accommodate future changes and additions.
    4. Consider cross-browser and cross-platform compatibility for broader usage.
    5. Implement logging and reporting functionalities for effective debugging and analysis.
    6. Follow a consistent coding style throughout the framework.
    7. Include proper test data management strategies for efficient testing.
     */

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        Driver.initDriver("chrome");
        driver = DriverManager.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

}
