package employeeManagementTestSuite.pageObjects;

import employeeManagementTestSuite.pageObjects.locators.LoginPageLocators;
import employeeManagementTestSuite.stepDefinitions.BaseTest;
import employeeManagementTestSuite.utils.EmployeeManagerWaits;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseTest {

    private WebElement element;
    private SoftAssertions softly = new SoftAssertions();

    public void enterUserName(String username){

        EmployeeManagerWaits.waitForJsToLoad(driver);
        EmployeeManagerWaits.waitForSeconds(driver,5);
        element = driver.findElement(By.xpath(LoginPageLocators.xTxtLoginUserName));
        element.clear();
        element.sendKeys(username);
    }

    public void clickLoginButton() {
        EmployeeManagerWaits.waitForJsToLoad(driver);
        EmployeeManagerWaits.waitForSeconds(driver,5);
        element = driver.findElement(By.xpath(LoginPageLocators.xBtnLogin));
        element.click();
    }

    public void enterPassword(String password) {
        EmployeeManagerWaits.waitForJsToLoad(driver);
        EmployeeManagerWaits.waitForSeconds(driver,5);
        element = driver.findElement(By.xpath(LoginPageLocators.xTxtLoginPassword));
        element.clear();
        element.sendKeys(password);
    }

    public void validatePresenceOfLoginButton() {

        EmployeeManagerWaits.waitForJsToLoad(driver);
        EmployeeManagerWaits.waitForSeconds(driver,5);
        element = driver.findElement(By.xpath(LoginPageLocators.xBtnLogin));
        softly.assertThat(element.getText()).as("Text on Login Button").isEqualTo("Login");
        softly.assertAll();
    }

    public void validatePresenceOfErrorMessage() {
        EmployeeManagerWaits.waitForJsToLoad(driver);
        EmployeeManagerWaits.waitForSeconds(driver,5);
        element = driver.findElement(By.xpath(LoginPageLocators.xErrorMessage));
        softly.assertThat(element.getText()).as("Error message: ").isEqualTo("Invalid username or password!");
        softly.assertAll();
    }
}
