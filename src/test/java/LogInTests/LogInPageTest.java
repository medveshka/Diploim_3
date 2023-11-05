package LogInTests;

import PageObjects.PO.LogInPage;
import PageObjects.PO.MainPage;
import PageObjects.PO.RegisterPage;
import PageObjects.PO.ResetPassPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.openqa.selenium.WebDriver;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;


import static PageObjects.Itils.RandomString.randomString;

public class LogInPageTest {

    private static WebDriver driver;

    public String email = randomString(5) + "@mail.ru";
    public String password = randomString(8);
    public String name = randomString(5);

    @Before
    public void setUp(){


        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://stellarburgers.nomoreparties.site/register");
        driver.manage().window().maximize();

        RegisterPage objRegisterInPage = new RegisterPage(driver);
        objRegisterInPage.register(name, email, password);






    }

    @DisplayName("Успешная авторизация через кнопку в форме регистрации")
    @Test
    public void logInFromRegisterPageTest(){

        LogInPage objLogInPage = new LogInPage(driver);
        objLogInPage.logIn(email, password);


    }

    @DisplayName("Успешная авторизация по кнопке «Войти в аккаунт» на главной")
    @Test
    public void logInFromMainPageLogInButtonTest(){
        driver.get("https://stellarburgers.nomoreparties.site");

        MainPage objMain = new MainPage(driver);
        LogInPage objLogInPage = new LogInPage(driver);
        objMain.clickLoginButton();
        objLogInPage.logIn(email, password);


    }

    @DisplayName("Успешная авторизация  через кнопку «Личный кабинет")
    @Test
    public void logInFromMainPagePersonalAreaButtonTest(){
        driver.get("https://stellarburgers.nomoreparties.site");

        MainPage objMain = new MainPage(driver);
        LogInPage objLogInPage = new LogInPage(driver);
        objMain.clickPersonalAreaButton();

        objLogInPage.logIn(email, password);


    }

    @DisplayName("Успешная авторизация через восстановленеи пароля")
    @Test
    public void logInFromResetPassButtonTest(){
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");

        ResetPassPage objReset = new ResetPassPage(driver);
        LogInPage objLogInPage = new LogInPage(driver);
        objReset.clickLogInButton();

        objLogInPage.logIn(email, password);



    }

    @After
    public void teardown() {
        driver.quit();
    }
}