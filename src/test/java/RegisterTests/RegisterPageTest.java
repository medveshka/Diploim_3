package RegisterTests;

import PageObjects.PO.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.openqa.selenium.WebDriver;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static PageObjects.Itils.RandomString.randomString;

public class RegisterPageTest {

    private static WebDriver driver;

    public String email = randomString(5) + "@mail.ru";
    public String password = randomString(8);
    public String name = randomString(5);



    @Before
    public void setDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();

        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");
        driver.manage().window().maximize();



    }

    @DisplayName("Успешная регистрация со страинц регистрации")
    @Test
    public void registrationFromRegisterPageTest(){
        RegisterPage objRegisterObj = new RegisterPage(driver);
        objRegisterObj.register(name, email, password);
        objRegisterObj.checkSuccess();



    }

    @After
    public void teardown() {
        driver.quit();
    }











}