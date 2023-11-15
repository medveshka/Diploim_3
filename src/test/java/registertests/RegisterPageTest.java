package registertests;

import io.restassured.response.Response;
import org.junit.Assert;
import pageobjects.LogInPage;
import pageobjects.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.openqa.selenium.WebDriver;


import org.junit.Before;
import org.junit.Test;

import utils.RoutesConstants;
import utils.User;
import utils.UserClient;

import static utils.BrowserVariants.createWebDriver;
import static utils.RandomString.randomString;


public class RegisterPageTest {

    private static WebDriver driver;

    public String email = randomString(5) + "@mail.ru";
    public String password = randomString(8);
    public String name = randomString(5);
    public String accessToken;



    @Before
    public void setDriver(){

        driver = createWebDriver();
        driver.get(RoutesConstants.REGISTER);
        driver.manage().window().maximize();



    }

    @DisplayName("Успешная регистрация со страницы регистрации")
    @Test
    public void registrationFromRegisterPageTest(){
        RegisterPage objRegisterObj = new RegisterPage(driver);
        objRegisterObj.register(name, email, password);
        objRegisterObj.checkSuccess();
        LogInPage logInObj = new LogInPage(driver);
        logInObj.waitLogInPageLoaded();

        Assert.assertEquals(RoutesConstants.LOGIN, driver.getCurrentUrl());

    }

    @After
   public void teardown() {
        User loggedInUser = new User(email, password);
        Response response = UserClient.logInUser(loggedInUser);
        accessToken= response.then().extract().body().path("accessToken");
        UserClient.deleteUser(accessToken);
     driver.quit();
   }


}