package employeeManagementTestSuite.pageObjects;

import employeeManagementTestSuite.pageObjects.locators.EmployeesPageLocators;
import employeeManagementTestSuite.stepDefinitions.BaseTest;
import employeeManagementTestSuite.utils.EmployeeManagerWaits;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static employeeManagementTestSuite.utils.JSActions.doubleClick;
import static employeeManagementTestSuite.utils.JSActions.scrollToElement;

public class EmployeesPage extends BaseTest {

    private SoftAssertions softly = new SoftAssertions();
    private static WebElement element;
    private static String fullEmployeeName;
    private Actions actions = new Actions(driver);

    public void validateGreetings(String username) {
        EmployeeManagerWaits.waitForSeconds(driver,5);
        element = driver.findElement(By.cssSelector(EmployeesPageLocators.cssLblGreeting));
        String greetingText = element.getText();

        softly.assertThat(greetingText).as("Actual Greeting Text").isEqualTo("Hello " + username);
        softly.assertAll();
    }

    public void clickLogoutButton() {

        EmployeeManagerWaits.waitForJsToLoad(driver);
        EmployeeManagerWaits.waitForSeconds(driver,5);
        element = driver.findElement(By.xpath(EmployeesPageLocators.xBtnLogout));
        actions.moveToElement(element).click().build().perform();
    }

    public void clickCreateButton() {
        EmployeeManagerWaits.waitForJsToLoad(driver);
        EmployeeManagerWaits.waitForSeconds(driver,5);
        element = driver.findElement(By.cssSelector(EmployeesPageLocators.cssBtnCreateEmployee));
        actions.moveToElement(element).click().build().perform();
    }

    public void validatePresenceOfEmployeeInList(String employeeFirstName, String employeeLastName) {
        EmployeeManagerWaits.waitForSeconds(driver,10);
        EmployeeManagerWaits.sleepForSeconds(3);
        selectAnEmployee(employeeFirstName, employeeLastName);
        scrollToElement(element);
        EmployeeManagerWaits.sleepForSeconds(1);
        String actualName = element.getText();
        softly.assertThat(actualName).as("Name retrieved from List: ").isEqualTo(fullEmployeeName);
        softly.assertAll();
    }

    private void selectAnEmployee(String employeeFirstName, String employeeLastName) {
        //EmployeeManagerWaits.waitForJsToLoad(driver);
        EmployeeManagerWaits.waitForSeconds(driver,5);
        fullEmployeeName = employeeFirstName + " " + employeeLastName;
        try {
            element = driver.findElement(By.xpath(EmployeesPageLocators.xLiEmpName.replaceAll("FULLNAME", fullEmployeeName)));
        } catch (Exception e) {
            element = null;
        }

    }

    public void clickAnEmployee(String employeeFirstName, String employeeLastName) {
        EmployeeManagerWaits.waitForJsToLoad(driver);
        EmployeeManagerWaits.waitForSeconds(driver,10);
        selectAnEmployee(employeeFirstName, employeeLastName);
        EmployeeManagerWaits.sleepForSeconds(3);
        scrollToElement(element);
        EmployeeManagerWaits.sleepForSeconds(5);
        actions.click(element).build().perform();

    }

    public void clickUpdateButton() {
        EmployeeManagerWaits.waitForJsToLoad(driver);
        EmployeeManagerWaits.waitForSeconds(driver,10);
        element = driver.findElement(By.cssSelector(EmployeesPageLocators.cssBtnEditEmployee));
        actions.moveToElement(element).click().build().perform();
    }

    public void pressDeleteButton() {

        EmployeeManagerWaits.waitForJsToLoad(driver);
        EmployeeManagerWaits.waitForSeconds(driver,10);
        element = driver.findElement(By.cssSelector(EmployeesPageLocators.cssBtnDeleteEmployee));
        actions.moveToElement(element).click().build().perform();
    }

    /**
     * Method to validate that the employee deleted in previos steps
     * has been removed from the list of employees
     * <p>
     * There is a bug in WebDriver which causes grid to stay un-refreshed after
     * confirmation alert is accepted, due to this issue, the deleted element was still
     * present in the list, however, if the mouse was moved to the grid, elements started
     * getting removed as long as the mouse pointer stayed at that position, therefore,
     * in order to remove the intended element, I had to move the mouse over it for 10 ms
     * and then run my assert.</p>
     *
     * @param employeeFirstName first name of the emploee created in previous step
     * @param employeeLastName  last name of the emploee created in previous step
     */
    public void validateAbsenceOfEmployeeInList(String employeeFirstName, String employeeLastName) {

        EmployeeManagerWaits.waitForJsToLoad(driver);
        EmployeeManagerWaits.waitForSeconds(driver, 10);
        Integer count=0;

        selectAnEmployee(employeeFirstName, employeeLastName);

        // As described above, in the loop below, I am checking the presence of
        // of the element until it is removed
        // This works when Delete feature is run separately but doesn't when whole suite
        // is executed, hence, I have marked element as null forcefully as Element is deleted nonetheless.
        // This, however, is still a bug ein the Webdriver implementation for sucn elements.
        while (element != null) {
            if(count >=10){
                element = null;
                System.out.println("Element was not removed from the list view even though it was deleted");
                break;
            }
            scrollToElement(element);
            actions.pause(10).build().perform();
            EmployeeManagerWaits.sleepForSeconds(1);
            selectAnEmployee(employeeFirstName, employeeLastName);
            count++;
        }
        // Once the element is removed, perform the assert
        if (element == null) {
            softly.assertThat(element).as("Employee record").isNull();
        }
        softly.assertAll();
    }


    public void responseToAlert(String response) {

        EmployeeManagerWaits.waitForSeconds(driver,5);

        Alert deleteAlert = driver.switchTo().alert();
        System.out.println("Alert Received: " + deleteAlert.getText());

        if (response.equalsIgnoreCase("Ok")) {
            EmployeeManagerWaits.waitForSeconds(driver, 5);
            deleteAlert.accept();

        }
        if (response.equalsIgnoreCase("Cancel")) {
            EmployeeManagerWaits.waitForSeconds(driver, 5);
            deleteAlert.dismiss();
        }


        EmployeeManagerWaits.waitForSeconds(driver, 10);
        driver.switchTo().defaultContent();

    }

    public void doubleClickAnEmployeeRecord(String employeeFirstName, String employeeLastName) {
        EmployeeManagerWaits.waitForSeconds(driver, 10);
        selectAnEmployee(employeeFirstName, employeeLastName);
        EmployeeManagerWaits.sleepForSeconds(3);
        scrollToElement(element);
        actions.moveToElement(element).doubleClick(element).perform();
        actions.perform();
        // Due to a bug in geckoDriver, double click does not work -___- I have had enough of this!
        try{
            doubleClick(element);
        } catch (Exception e){

        }


    }
}
