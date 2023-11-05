package Profile;



import PageObjects.PO.LogInPage;
import PageObjects.PO.MainPage;
import PageObjects.PO.PersonalAreaPage;
import PageObjects.PO.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.openqa.selenium.WebDriver;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import static PageObjects.Itils.RandomString.randomString;

public class ProfileTest {

    private static WebDriver driver;
    public String email = randomString(5) + "@mail.ru";
    public String password = randomString(8);
    public String name = randomString(5);


    @Before
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://stellarburgers.nomoreparties.site/register");
        driver.manage().window().maximize();

        RegisterPage objRegisterInPage = new RegisterPage(driver);
        objRegisterInPage.register(name, email, password);
        driver.get("https://stellarburgers.nomoreparties.site/login");
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

        assertEquals( "https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());

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



    }
    @After
    public void teardown() {
        driver.quit();
    }









}