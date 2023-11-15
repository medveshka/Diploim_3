package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {

    private By personalAreaButton = By.xpath("//a[.='Личный Кабинет']");
    private By logInButtonOnMainPage = By.cssSelector(".button_button__33qZ0");
    private By constructorButton = By.xpath("//a[.='Конструктор']");


    private WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }


    public void clickPersonalAreaButton(){
        driver.findElement(personalAreaButton).click();
    }
    public void clickLoginButton(){
        driver.findElement(logInButtonOnMainPage).click();
    }

    public void clickConstructorButton(){
        driver.findElement(constructorButton).click();
    }


    public void waitForLoad(By fieldToAppear) {

        new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(fieldToAppear));
    }
    public void waitForPersonalAreaButton() {

        waitForLoad(personalAreaButton);
    }

}
