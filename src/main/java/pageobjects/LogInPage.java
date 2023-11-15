package pageobjects;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


public class LogInPage  {
    private By emailField = By.name("name");
    private By passField = By.name("Пароль");
    private By loginButtonOnLoginPage = By.xpath("//button[.='Войти']");;

    private By makeOrderButton = By.xpath("//button[.='Оформить заказ']");



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




    public void logIn(String email, String password) {
        waitForLoad(loginButtonOnLoginPage);
        setEmail(email);
        setPassword(password);
        clickLogIn();


    }


    public void waitForLoad(By fieldToAppear) {

        new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(fieldToAppear));
    }


    public void waitForMakeOrderButton() {

        waitForLoad(makeOrderButton);
    }

    public void waitLogInPageLoaded() {

        waitForLoad(loginButtonOnLoginPage);
    }


}