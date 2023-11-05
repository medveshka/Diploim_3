package PageObjects.PO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailField = By.xpath("//fieldset[2]//input[@name='name']");
    By passField = By.name("Пароль");
    By nameField = By.xpath("//fieldset[1]//input[@name='name']");
    By registerButton = By.xpath("//button[.='Зарегистрироваться']");
    By succesHeader = By.cssSelector(".button_button__33qZ0");
    By incorrectPass = By.xpath(".//p[text()='Некорректный пароль']");



    public void setName(String name) {

        driver.findElement(nameField).sendKeys(name);
    }

    public void setEmail(String email) {

        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {

        driver.findElement(passField).sendKeys(password);
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();

    }
    public void checkSuccess() {
        driver.findElement(succesHeader);

    }


    public void register(String name, String email, String password ){
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegister();


    }

    public void waitForLoad(By fieldToAppear) {

        new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(fieldToAppear));
    }


    public void waitForIncorrectMess() {

        waitForLoad(incorrectPass);
    }



}
