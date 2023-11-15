package logintests;

import io.restassured.response.Response;
import org.junit.Assert;
import pageobjects.LogInPage;
import pageobjects.MainPage;

import pageobjects.ResetPassPage;
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

public class LogInPageTest {

    private static WebDriver driver;

    public String email = randomString(5) + "@mail.ru";
    public String password = randomString(8);
    public String name = randomString(5);
    public String accessToken;

    @Before
    public void setUp(){


        driver = createWebDriver();

        driver.get(RoutesConstants.REGISTER);
        driver.manage().window().maximize();
        User user = new User(email, password, name);
        Response response = UserClient.createUser(user);
        accessToken = response.then().extract().body().path("accessToken");

    }

    @DisplayName("Успешная авторизация через кнопку в форме регистрации")
    @Test
    public void logInFromRegisterPageTest(){


        driver.get(RoutesConstants.LOGIN);
        LogInPage objLogInPage = new LogInPage(driver);
        objLogInPage.waitLogInPageLoaded();

        objLogInPage.logIn(email, password);
        objLogInPage.waitForMakeOrderButton();

        Assert.assertEquals(RoutesConstants.MAIN_PAGE, driver.getCurrentUrl());



    }

    @DisplayName("Успешная авторизация по кнопке «Войти в аккаунт» на главной")
    @Test
    public void logInFromMainPageLogInButtonTest(){
        driver.get(RoutesConstants.MAIN_PAGE);

        MainPage objMain = new MainPage(driver);
        LogInPage objLogInPage = new LogInPage(driver);
        objMain.clickLoginButton();
        objLogInPage.logIn(email, password);
        objLogInPage.waitForMakeOrderButton();
        Assert.assertEquals(RoutesConstants.MAIN_PAGE, driver.getCurrentUrl());


    }

    @DisplayName("Успешная авторизация  через кнопку «Личный кабинет")
    @Test
    public void logInFromMainPagePersonalAreaButtonTest(){
        driver.get(RoutesConstants.MAIN_PAGE);

        MainPage objMain = new MainPage(driver);
        LogInPage objLogInPage = new LogInPage(driver);
        objMain.clickPersonalAreaButton();

        objLogInPage.logIn(email, password);
        objLogInPage.waitForMakeOrderButton();
        Assert.assertEquals(RoutesConstants.MAIN_PAGE, driver.getCurrentUrl());


    }

    @DisplayName("Успешная авторизация через восстановленеи пароля")
    @Test
    public void logInFromResetPassButtonTest(){
        driver.get(RoutesConstants.RESTORE_PASS);

        ResetPassPage objReset = new ResetPassPage(driver);
        LogInPage objLogInPage = new LogInPage(driver);
        objReset.clickLogInButton();

        objLogInPage.logIn(email, password);
        objLogInPage.waitForMakeOrderButton();
        Assert.assertEquals(RoutesConstants.MAIN_PAGE, driver.getCurrentUrl());



    }

  @After
  public void teardown() {

        UserClient.deleteUser(accessToken);
        driver.quit();
}
}