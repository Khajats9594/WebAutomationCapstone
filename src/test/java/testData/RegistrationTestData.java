package testData;

import constants.FrameworkConstants;
import entity.Registration;
import entity.RegistrationData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utiles.JsonUtils;

public final class RegistrationTestData {

    private RegistrationTestData(){}

    private static final Logger logger = LogManager.getLogger(RegistrationTestData.class);

    public static Registration getValidUserData(){

        logger.info("Creating the user data for Registration functional testing");
        JsonUtils<RegistrationData> registrationDataJsonUtils = JsonUtils
                .initializeData(FrameworkConstants.getRegistrationDataFilePath(), RegistrationData.class);
        return registrationDataJsonUtils
                .getData()
                .getValidRegistration();
    }
    public static Registration getInvalidUserData(){

        logger.info("Creating the user data for Registration functional testing");
        JsonUtils<RegistrationData> registrationDataJsonUtils = JsonUtils
                .initializeData(FrameworkConstants.getRegistrationDataFilePath(), RegistrationData.class);
        return registrationDataJsonUtils
                .getData()
                .getInvalidRegistration();
    }
}
