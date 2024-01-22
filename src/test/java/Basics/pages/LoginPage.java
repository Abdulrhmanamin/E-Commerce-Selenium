package Basics.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private By userName_fld = By.xpath("//*[@id=\"user-name\"]");
    private By password_fld = By.xpath("//*[@id=\"password\"]");
    private By login_btn = By.xpath("//*[@id=\"login-button\"]");


    public void insertUserName(String username){
        baseDriver.findElement(userName_fld).clear();
        baseDriver.findElement(userName_fld).sendKeys(username);
    }
    public void insertPassword (String pass){
        baseDriver.findElement(password_fld).clear();
        baseDriver.findElement(password_fld).sendKeys(pass);
    }
    public void clickOnLoginBtn(){
        baseDriver.findElement(login_btn).click();
    }
}
