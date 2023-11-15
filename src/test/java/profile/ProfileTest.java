package profile;



import io.restassured.response.Response;
import org.junit.Assert;
import pageobjects.LogInPage;
import pageobjects.MainPage;
import pageobjects.PersonalAreaPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.openqa.selenium.WebDriver;


import org.junit.Before;
import org.junit.Test;

import utils.RoutesConstants;
import utils.User;
import utils.UserClient;

import static org.junit.Assert.assertEquals;


import static utils.BrowserVariants.createWebDriver;
import static utils.RandomString.randomString;

public class ProfileTest {

    private static WebDriver driver;
    public String email = randomString(5) + "@mail.ru";
    public String password = randomString(8);
    public String name = randomString(5);
    public String accessToken;


    @Before
    public void setDriver(){
        driver = createWebDriver();


        User user = new User(email, password, name);
        Response response = UserClient.createUser(user);
        accessToken = response.then().extract().body().path("accessToken");

        driver.get(RoutesConstants.LOGIN);
        driver.manage().window().maximize();
        LogInPage objLogInPage = new LogInPage(driver);
        objLogInPage.logIn(email, password);

    }




    @DisplayName("Переход в личный кабинет")
    @Test
    public void goToProfileFromMainTest(){
        MainPage objMain = new MainPage(driver);
        PersonalAreaPage perAr = new PersonalAreaPage(driver);
        objMain.waitForPersonalAreaButton();
        objMain.clickPersonalAreaButton();
        perAr.waitForExitButton();
        Assert.assertEquals(RoutesConstants.PROFILE, driver.getCurrentUrl());


    }

    @DisplayName("Из личного кабинета в ингредиенты")
    @Test
    public void fromProfileToConstructorTest(){
        MainPage objMain = new MainPage(driver);
        PersonalAreaPage perAr = new PersonalAreaPage(driver);
        objMain.waitForPersonalAreaButton();
        objMain.clickPersonalAreaButton();
        perAr.waitForExitButton();
        objMain.clickConstructorButton();

        assertEquals(RoutesConstants.MAIN_PAGE, driver.getCurrentUrl());

    }


    @DisplayName("Выход из аккаунта")
    @Test
    public void logOutTest(){
        MainPage objMain = new MainPage(driver);
        PersonalAreaPage perAr = new PersonalAreaPage(driver);
        objMain.waitForPersonalAreaButton();
        objMain.clickPersonalAreaButton();
        perAr.waitForExitButton();
        perAr.logOut();
        LogInPage logInObj = new LogInPage(driver);
        logInObj.waitLogInPageLoaded();
        Assert.assertEquals(RoutesConstants.LOGIN, driver.getCurrentUrl());



    }
    @After

    public void teardown() {

        UserClient.deleteUser(accessToken);
       // driver.quit();
    }









}