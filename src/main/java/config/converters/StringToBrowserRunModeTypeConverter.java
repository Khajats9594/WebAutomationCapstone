package config.converters;

import enums.BrowserRunModeType;
import enums.BrowserType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToBrowserRunModeTypeConverter implements Converter<BrowserRunModeType> {
    @Override
    public BrowserRunModeType convert(Method method, String browserRunMode) {
        return BrowserRunModeType.valueOf(browserRunMode.toUpperCase());
    }
}
