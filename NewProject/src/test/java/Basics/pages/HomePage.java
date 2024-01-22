package Basics.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    private By websiteName = By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div");
    private By menu = By.xpath("//*[@id=\"react-burger-menu-btn\"]");
    private  By logout = By.xpath("//*[@id=\"logout_sidebar_link\"]");

    public void openMenu(){
        baseDriver.findElement(menu).click();
    }
    public void userLogout (){

        baseDriver.findElement(logout).click();
    }
    public String getWebsiteTitle(){
        return baseDriver.findElement(websiteName).getText();
    }
    public void waitForMenuOpen(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(d -> driver.findElement(logout).isDisplayed());
//        wait.until(ExpectedConditions.visibilityOf((WebElement) logout));
    }

}
