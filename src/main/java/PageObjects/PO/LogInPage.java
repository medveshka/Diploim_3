package PageObjects.PO;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


public class LogInPage  {
     By emailField = By.name("name");
     By passField = By.name("Пароль");
     By loginButtonOnLoginPage = By.cssSelector(".button_button__33qZ0");

     By toMain = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a[@href='/']");



    private WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {

        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {

        driver.findElement(passField).sendKeys(password);
    }

    public void clickLogIn() {
        driver.findElement(loginButtonOnLoginPage).click();

    }

    public void clickToMain() {
        driver.findElement(toMain).click();

    }


    public void logIn(String email, String password) {
        waitForLoad(loginButtonOnLoginPage);
        setEmail(email);
        setPassword(password);
        clickLogIn();


    }


    public void waitForLoad(By fieldToAppear) {

        new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(fieldToAppear));
    }







}