package utiles;

import constants.FrameworkConstants;
import enums.BrowserRemoteModeType;
import enums.BrowserRunModeType;
import enums.BrowserType;
import enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {

    private static Properties property = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    private PropertyUtils() {
    }

    static {
        try (FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
            property.load(file);
            for (Map.Entry<Object, Object> entry : property.entrySet()) {
                CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()); //remove the trailing and leading spaces
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    public static String get(ConfigProperties key) {
        String sysPropertyValue = System.getProperty(key.name().toLowerCase());
        if (Objects.nonNull(sysPropertyValue)) {
            return sysPropertyValue;
        }
        String configMapValue = CONFIGMAP.get(key.name().toLowerCase());
        if (Objects.nonNull(configMapValue)) {
            return configMapValue;
        }
        throw new RuntimeException("Property name " + key + " is not found. Please check config.properties");
    }

    public static BrowserType getBrowserType(){
        String sysBrowserValue = System.getProperty("browser");
        if (Objects.nonNull(sysBrowserValue)) {
            return BrowserType.valueOf(sysBrowserValue.toUpperCase());
        }
        String browser = CONFIGMAP.get("browser");
        if (Objects.nonNull(browser)) {
            return BrowserType.valueOf(browser.toUpperCase());
        }
        throw new RuntimeException("Property name " + browser + " is not found. Please check config.properties");
    }
    public static BrowserRemoteModeType getRemoteMode() {
        String sysRemoteModeValue = System.getProperty("browserRemoteMode");
        if (Objects.nonNull(sysRemoteModeValue)) {
            return BrowserRemoteModeType.valueOf(sysRemoteModeValue.toUpperCase());
        }
        String remoteMode = CONFIGMAP.get("browserRemoteMode");
        if (Objects.nonNull(remoteMode)) {
            return BrowserRemoteModeType.valueOf(remoteMode.toUpperCase());
        }
        throw new RuntimeException("Property 'browserRemoteMode' is not found. Please check config.properties");
    }
    public static BrowserRunModeType getRunMode() {
        String sysRunModeValue = System.getProperty("browserRunMode");
        if (Objects.nonNull(sysRunModeValue)) {
            return BrowserRunModeType.valueOf(sysRunModeValue.toUpperCase());
        }
        String remoteMode = CONFIGMAP.get("browserRunMode");
        if (Objects.nonNull(remoteMode)) {
            return BrowserRunModeType.valueOf(remoteMode.toUpperCase());
        }
        throw new RuntimeException("Property 'remoteMode' is not found. Please check config.properties");
    }



}
