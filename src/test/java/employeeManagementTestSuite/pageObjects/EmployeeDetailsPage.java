package employeeManagementTestSuite.pageObjects;

import employeeManagementTestSuite.pageObjects.locators.EmployeeDetailsPageLocators;
import employeeManagementTestSuite.stepDefinitions.BaseTest;
import employeeManagementTestSuite.utils.EmployeeManagerWaits;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class EmployeeDetailsPage extends BaseTest {
    private static WebElement element;
    private SoftAssertions softly = new SoftAssertions();
    private Actions actions = new Actions(driver);

    public void enterFirstName(String employeeFirstName) {
        EmployeeManagerWaits.waitForJsToLoad(driver);
        EmployeeManagerWaits.waitForSeconds(driver,5);
        element = driver.findElement(By.xpath(EmployeeDetailsPageLocators.xTxtFirstName));
        element.clear();
        actions.moveToElement(element).sendKeys(employeeFirstName).perform();
    }

    public void enterLastName(String employeeLastName) {
        EmployeeManagerWaits.waitForJsToLoad(driver);
        EmployeeManagerWaits.waitForSeconds(driver,5);
        EmployeeManagerWaits.sleepForSeconds(3);
        element = driver.findElement(By.xpath(EmployeeDetailsPageLocators.xTxtLastName));
        element.clear();
        actions.moveToElement(element).sendKeys(employeeLastName).perform();
    }

    public void enterEmail(String email) {
        EmployeeManagerWaits.waitForJsToLoad(driver);
        EmployeeManagerWaits.waitForSeconds(driver,5);
        EmployeeManagerWaits.sleepForSeconds(3);
        element = driver.findElement(By.xpath(EmployeeDetailsPageLocators.xTxtEmail));
        element.clear();
        actions.moveToElement(element).sendKeys(email).perform();
    }

    public void enterStartDate(String start_date) {
        EmployeeManagerWaits.waitForJsToLoad(driver);
        EmployeeManagerWaits.waitForSeconds(driver,5);
        element = driver.findElement(By.xpath(EmployeeDetailsPageLocators.xTxtStartDate));
        element.clear();
        EmployeeManagerWaits.waitForSeconds(driver, 5);
        actions.moveToElement(element).sendKeys(start_date).perform();
    }

    public void clickAddButton() {
        EmployeeManagerWaits.waitForJsToLoad(driver);
        EmployeeManagerWaits.waitForSeconds(driver,5);
        element = driver.findElement(By.xpath(EmployeeDetailsPageLocators.xAddButton));
        actions.moveToElement(element).click().perform();
    }

    public void clickUpdateButton() {
        EmployeeManagerWaits.waitForJsToLoad(driver);
        EmployeeManagerWaits.waitForSeconds(driver,5);
        element = driver.findElement(By.xpath(EmployeeDetailsPageLocators.xUpdateButton));
        actions.moveToElement(element).click().perform();
    }

    public void clickDeleteButton() {
        EmployeeManagerWaits.waitForJsToLoad(driver);
        EmployeeManagerWaits.waitForSeconds(driver,5);
        element = driver.findElement(By.xpath(EmployeeDetailsPageLocators.xDeleteButton));
        actions.moveToElement(element).click().perform();
    }

    public void validateThatEmployeeIsNotSaved() {
        EmployeeManagerWaits.waitForJsToLoad(driver);
        EmployeeManagerWaits.waitForSeconds(driver,5);
        element = driver.findElement(By.xpath(EmployeeDetailsPageLocators.xTxtEmail));
        softly.assertThat(element.isDisplayed()).as("Email Box Present").isTrue();
    }

    public void validatePresenceOfInvalidDateError() {

        EmployeeManagerWaits.sleepForSeconds(3);
        Alert dateAlert = driver.switchTo().alert();
        String alertMessage = dateAlert.getText();

        EmployeeManagerWaits.waitForSeconds(driver, 5);
        dateAlert.accept();

        softly.assertThat(alertMessage).as("Alert Message: ").isEqualTo("Error trying to create a new employee: {\"start_date\":[\"can't be blank\"]})");
        softly.assertAll();
        EmployeeManagerWaits.waitForSeconds(driver, 10);
        driver.switchTo().defaultContent();

    }
}
