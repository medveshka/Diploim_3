package Constructor;


import PageObjects.PO.*;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static PageObjects.Itils.RandomString.randomString;
import static org.junit.Assert.assertEquals;

public class ConstructorPageTest {

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
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        RegisterPage objRegisterInPage = new RegisterPage(driver);
        objRegisterInPage.register(name, email, password);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LogInPage objLogInPage = new LogInPage(driver);
        objLogInPage.logIn(email, password);

    }




    @DisplayName("В разделе с булками")
    @Test
    public void IsInBunTab()  {
        ConstructorPage objConstPage = new ConstructorPage(driver);

        Assert.assertThat(objConstPage.classActiveSectionBuns(), CoreMatchers.containsString("tab_tab_type_current"));
    }

    @DisplayName("В разделе с соусами")
    @Test
    public void IsInSauceTab(){
        ConstructorPage objConstPage = new ConstructorPage(driver);
        objConstPage.clickSauceTab();
        Assert.assertThat(objConstPage.classActiveSectionSauces(), CoreMatchers.containsString("tab_tab_type_current"));
    }

    @DisplayName("В разделе с начинкой")
    @Test
    public void IsInBunFillings(){
        ConstructorPage objConstPage = new ConstructorPage(driver);
        objConstPage.clickFeelingTab();
        Assert.assertThat(objConstPage.classActiveSectionFillings(), CoreMatchers.containsString("tab_tab_type_current"));
    }



    @After
    public void teardown() {
        driver.quit();
    }









}