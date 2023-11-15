package constructor;


import io.restassured.response.Response;
import pageobjects.ConstructorPage;
import pageobjects.LogInPage;
import pageobjects.RegisterPage;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import utils.RoutesConstants;
import utils.User;
import utils.UserClient;



import static utils.BrowserVariants.createWebDriver;
import static utils.RandomString.randomString;


public class ConstructorPageTest {

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
        UserClient.deleteUser(accessToken);
        driver.quit();
    }









}