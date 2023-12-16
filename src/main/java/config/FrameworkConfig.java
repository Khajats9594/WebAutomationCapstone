package config;

import config.converters.StringToBrowserRemoteModeTypeConverter;
import config.converters.StringToBrowserRunModeTypeConverter;
import config.converters.StringToBrowserTypeConverter;
import config.converters.StringToURLConverter;
import enums.BrowserRemoteModeType;
import enums.BrowserRunModeType;
import enums.BrowserType;
import org.aeonbits.owner.Config;
import org.checkerframework.checker.units.qual.K;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "System.properties",
        "System.evn",
        "file:${user.dir}/src/test/resources/config-files/config1.properties",
})
public interface FrameworkConfig extends Config {
    @DefaultValue("CHROME")
    @ConverterClass(StringToBrowserTypeConverter.class)
    BrowserType browser();
    @Key("browserRunMode")
    @ConverterClass(StringToBrowserRunModeTypeConverter.class)
    BrowserRunModeType browserRunMode();

    @Key("browserRemoteMode")
    @ConverterClass(StringToBrowserRemoteModeTypeConverter.class)
    BrowserRemoteModeType browserRemoteMode();
    @Key("seleniumGridUrl")
    @ConverterClass(StringToURLConverter.class)
    URL seleniumGridUrl();
}
