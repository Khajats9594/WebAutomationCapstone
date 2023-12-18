package testcases;

import entity.UserDetail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;
import testData.UserTestData;

import java.util.Map;

public class UserRegistrationTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(UserRegistrationTest.class);
    @Test
    public void userRegistrationTest(){
        //Arrange
        UserDetail validUserData = UserTestData.getValidUserData();
        logger.info("Testing the registration functionality with the userdata {}",validUserData);

        //Act
        String accountPageDashboardText = LandingPage.getInstance()
                .navigateToLoginPage()
                .navigateToCreateAccountPage()
                .createAccountForValidData(validUserData)
                .navigateRegisterAccountPage()
                .verifyLoginFunction();

        logger.info("Verifying the registration function by fetching the {} text from account page",accountPageDashboardText);

        //Assert
       Assert.assertEquals(accountPageDashboardText,"Account details","user is not registered");
    }

    @Test
    public void userRegistrationWithInvalidData(){
        //Arrange
        UserDetail invalidUserData = UserTestData.getInvalidUserData();
        logger.info("Testing the registration functionality with the userdata {}",invalidUserData);

        //Act
        Map<String, String> errorMessagesOfRegistrationForm = LandingPage.getInstance()
                .navigateToLoginPage()
                .navigateToCreateAccountPage()
                .createAccountForInvalidData(invalidUserData)
                .getErrorMessagesOfRegistrationForm();
        logger.info("The error message is {}",errorMessagesOfRegistrationForm);


        //Assert
        for(Map.Entry<String,String> entry : errorMessagesOfRegistrationForm.entrySet()){
            if(entry.getValue()!=null){
                Assert.assertEquals(errorMessagesOfRegistrationForm.get("passwordErrorMessage"),
                        "Password is too short (minimum is 5 characters)","password errorMessage did not matched");
                Assert.assertEquals(errorMessagesOfRegistrationForm.get("emailErrorMessage"),
                        "Email is invalid","email errorMessage is not matched");
            }
        }
    }
}
