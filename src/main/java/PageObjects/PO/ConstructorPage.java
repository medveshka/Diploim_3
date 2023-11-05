package PageObjects.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage {
    By constructorButton = By.xpath("//a[.='Конструктор']");

    By sauceTab = By.xpath("//div[.='Соусы']");
    By feelingTab = By.xpath("//div[.='Начинки']");
    By bunTab = By.xpath("//div[.='Булки']");



    private WebDriver driver;

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();

    }



    public void clickSauceTab() {
        driver.findElement(sauceTab).click();

    }
    public void clickFeelingTab() {
        driver.findElement(feelingTab).click();

    }
    public String classActiveSectionBuns(){
        return  driver.findElement(bunTab).getAttribute("class");
    }
    public String classActiveSectionSauces(){
        return  driver.findElement(sauceTab).getAttribute("class");
    }
    public  String classActiveSectionFillings() {
        return driver.findElement(feelingTab).getAttribute("class");
    }

}
