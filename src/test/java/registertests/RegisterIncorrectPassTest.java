package registertests;

import org.junit.Assert;
import pageobjects.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import utils.RoutesConstants;

import static utils.BrowserVariants.createWebDriver;
import static utils.RandomString.randomString;

public class RegisterIncorrectPassTest {

    private static WebDriver driver;

    public String email = randomString(5) + "@mail.ru";
    public String password = randomString(5);
    public String name = randomString(5);



    @Before
    public void setDriver(){
        driver = createWebDriver();
        driver.get(RoutesConstants.REGISTER);
        driver.manage().window().maximize();



    }

    @DisplayName("Зарегистрроваться с паролем из 5 символов нельзя")
    @Test
    public void registrationFromRegisterPageTest(){
        RegisterPage objRegisterObj = new RegisterPage(driver);
        objRegisterObj.register(name, email, password);
        objRegisterObj.waitForIncorrectMess();
        Assert.assertEquals("Некорректный пароль", objRegisterObj.getPassErrorText());
        Assert.assertEquals(RoutesConstants.REGISTER, driver.getCurrentUrl());


    }

    @After
    public void teardown() {
        driver.quit();
    }











}