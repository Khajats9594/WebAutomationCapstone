package config.converters;

import enums.BrowserRemoteModeType;
import enums.BrowserRunModeType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToBrowserRemoteModeTypeConverter implements Converter<BrowserRemoteModeType> {
    @Override
    public BrowserRemoteModeType convert(Method method, String browserRemoteMode) {
        return BrowserRemoteModeType.valueOf(browserRemoteMode.toUpperCase());
    }
}
