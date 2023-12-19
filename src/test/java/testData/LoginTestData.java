package testData;

import constants.FrameworkConstants;
import entity.User;
import entity.UserData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utiles.JsonUtils;

public class LoginTestData {

    private LoginTestData(){}

    private static final Logger logger = LogManager.getLogger(LoginTestData.class);

    public static User getValidLoginData(){
        logger.info("Creating the user data for Login functional testing");
        JsonUtils<UserData> userDataJsonUtils = JsonUtils
                .initializeData(FrameworkConstants.getLoginDataFilePath(), UserData.class);
        return userDataJsonUtils.getData().getValidUser();
    }
    public static User getInvalidLoginData(){
        logger.info("Creating the user data for Login functional testing");
        JsonUtils<UserData> userDataJsonUtils = JsonUtils
                .initializeData(FrameworkConstants.getLoginDataFilePath(), UserData.class);
        return userDataJsonUtils.getData().getInvalidUser();
    }
}
