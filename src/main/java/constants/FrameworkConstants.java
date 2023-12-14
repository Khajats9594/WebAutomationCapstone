package constants;

import lombok.Data;
import lombok.Getter;


public final class FrameworkConstants {

    private FrameworkConstants() {}

    private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
    private static final String CONFIGFILEPATH = RESOURCESPATH+"/config-files/config.properties";
    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }
}
