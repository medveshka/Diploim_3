package pageobjects;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
public class ResetPassPage {

    private By logInButton = By.cssSelector(".Auth_link__1fOlj");

    private WebDriver driver;
    public ResetPassPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickLogInButton() {
        driver.findElement(logInButton).click();

    }
}
