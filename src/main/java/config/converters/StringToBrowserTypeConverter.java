package config.converters;

import enums.BrowserType;
import org.aeonbits.owner.Converter;
import java.lang.reflect.Method;
import java.util.Map;

public class StringToBrowserTypeConverter implements Converter<BrowserType> {
    @Override
    public BrowserType convert(Method method, String browser) {
        Map<String, BrowserType> stringBrowserTypeMap = Map.of("CHROME", BrowserType.CHROME,
                "FIREFOX", BrowserType.FIREFOX);
        return stringBrowserTypeMap.getOrDefault(browser.toUpperCase(),BrowserType.CHROME);
    }
}
