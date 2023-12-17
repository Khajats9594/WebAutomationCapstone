package drivertwo.manager.local;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class ChromeManager {

    private ChromeManager(){}

    public static ChromeDriver getDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        return new ChromeDriver(options);
    }
}
