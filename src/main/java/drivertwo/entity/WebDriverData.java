package drivertwo.entity;


import enums.BrowserRemoteModeType;
import enums.BrowserRunModeType;
import enums.BrowserType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebDriverData {

    BrowserType browserType;
    BrowserRunModeType browserRunModeType;
    BrowserRemoteModeType browserRemoteModeType;
}
