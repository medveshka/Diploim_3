package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage {
    private By constructorButton = By.xpath("//a[.='Конструктор']");

    private By sauceTab = By.xpath("//div[.='Соусы']");
    private By feelingTab = By.xpath("//div[.='Начинки']");
    private By bunTab = By.xpath("//div[.='Булки']");



    private WebDriver driver;

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
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
