package PageObjects.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAreaPage {
    By personalAreaButton = By.xpath("//p[.='Личный Кабинет']");
    By logOutButton = By.xpath("//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']");


    private WebDriver driver;

    public PersonalAreaPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickLogOutButton() {
        driver.findElement(logOutButton).click();

    }

    public void logOut() {


        clickLogOutButton();


    }
    public void waitForLoad(By fieldToAppear) {

        new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(fieldToAppear));
    }
    public void waitForExitButton() {

        waitForLoad(logOutButton);
    }

}
