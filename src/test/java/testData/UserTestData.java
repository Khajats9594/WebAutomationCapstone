package testData;

import entity.UserDetail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class UserTestData {

    private UserTestData(){}

    private static final Logger logger = LogManager.getLogger(UserTestData.class);

    public static UserDetail getValidUserData(){

        logger.info("Creating the user data for Registration functional testing");

        return UserDetail.builder()
                .setFirstName("Jon12")
                .setLastName("Akbar12")
                .setEmail("jonAkbar12@gmail.com")
                .setPassword("jonAkbar12344")
                .build();
    }
    public static UserDetail getInvalidUserData(){

        logger.info("Creating the user data for Registration functional testing");

        return UserDetail.builder()
                .setFirstName("Jon12")
                .setLastName("Akbar12")
                .setEmail("jonAkbar12")
                .setPassword("jo")
                .build();
    }
}
