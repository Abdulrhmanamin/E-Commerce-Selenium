package Basics.testcases;

import Basics.pages.HomePage;
import Basics.pages.LoginPage;
import Basics.utlities.Screenshot;
import Basics.utlities.read_excel_data;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestcase extends BaseTest{
    LoginPage lp;
    HomePage hp;
    @Test(dataProvider = "readData")
    public void validLogin(String userName, String password) throws InterruptedException {
        lp=new LoginPage(driver);
        lp.insertUserName(userName);
        lp.insertPassword(password);
        lp.clickOnLoginBtn();
        hp = new HomePage(driver);
        String expectedResult = hp.getWebsiteTitle();
        Assert.assertEquals(expectedResult, "Swag Labs");
        hp.openMenu();
        hp.waitForMenuOpen(driver);
        hp.userLogout();

    }
    @AfterMethod
    public void failed_testcase(ITestResult testcaseResult) throws IOException {
        if (testcaseResult.getStatus()==ITestResult.FAILURE){
            Screenshot.take_screenshot(driver,".\\screenshots\\"+testcaseResult.getName()+".png");
        }

    }

    @DataProvider
    public String[][] readData() throws IOException, InvalidFormatException {
        read_excel_data data = new read_excel_data();
        return data.read_data();
    }
}
