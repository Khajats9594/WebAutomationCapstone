package testcases;

import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LandingPage;
import testData.LoginTestData;

public class LoginFunctionTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(LoginFunctionTest.class);

    @Test
    public void loginTestWithValidData(){
        //Arrange
        User validLoginData = LoginTestData.getValidLoginData();
        logger.info("Testing Login functionality with the login-data {}",validLoginData);

        //Act
        String text = LandingPage.getInstance()
                .navigateToLoginPage()
                .verifyingLoginFunctionWithValidData(validLoginData);
        logger.info("Verifying the login function using data");

        //Assert
        Assert.assertEquals(text,"Account","user is not logined");
    }
}
