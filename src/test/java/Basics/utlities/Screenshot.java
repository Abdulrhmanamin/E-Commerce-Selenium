package Basics.utlities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public static void  take_screenshot(WebDriver driver,String screenshotPath) throws IOException {
        TakesScreenshot screenshot= ((TakesScreenshot) driver);
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshotFile,new File (screenshotPath));

    }
}
