package employeeManagementTestSuite.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class EmployeeManagerWaits {

    // Methods declared as static so that we can call the waits without
    // creating unnecessary objects and maintaining their states

    public static void waitForSeconds(WebDriver driver, int i) {
        driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
    }

    public static void waitForClickableElement(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void sleepForSeconds(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForJsToLoad(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 15, 100);
        wait.until(AdditionalConditions.angularHasFinishedProcessing());
    }
}
