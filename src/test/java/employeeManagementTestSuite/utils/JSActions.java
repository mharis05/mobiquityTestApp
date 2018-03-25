package employeeManagementTestSuite.utils;

import employeeManagementTestSuite.stepDefinitions.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSActions extends BaseTest {

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void doubleClick(WebElement element) {
        String jsCode = "var evObj = new MouseEvent('dblclick', {bubbles: true, cancelable: true, view: window});";
        jsCode += " arguments[0].dispatchEvent(evObj);";
        ((JavascriptExecutor)driver).executeScript(jsCode, element);
    }
}
