package employeeManagementTestSuite.stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import employeeManagementTestSuite.pageObjects.EmployeeDetailsPage;
import employeeManagementTestSuite.pageObjects.EmployeesPage;
import employeeManagementTestSuite.utils.DataGenerator;

import java.util.List;
import java.util.Map;

public class EmployeeManagement {

    private EmployeesPage employeesPage = new EmployeesPage();
    private EmployeeDetailsPage employeeDetailsPage = new EmployeeDetailsPage();

    private String employeeFirstName;
    private String employeeLastName;

    @When("^User clicks on Create Button$")
    public void userClicksOnCreateButton() {
        employeesPage.clickCreateButton();
    }

    @And("^Enters details in the form$")
    public void entersValidDetailsInTheForm(DataTable employeeDetails) {
        List<Map<String,String>> employeeDetailsMap = employeeDetails.asMaps(String.class, String.class);
        employeeDetailsMap = DataGenerator.setActualValues(employeeDetailsMap);

        if(employeeDetailsMap.get(0).containsKey("First Name")){
            employeeFirstName = employeeDetailsMap.get(0).get("First Name");
            employeeDetailsPage.enterFirstName(employeeFirstName);
        }
        if(employeeDetailsMap.get(0).containsKey("Last Name")){
            employeeLastName = employeeDetailsMap.get(0).get("Last Name");
            employeeDetailsPage.enterLastName(employeeLastName);
        }
        if(employeeDetailsMap.get(0).containsKey("Email")){
            employeeDetailsPage.enterEmail(employeeDetailsMap.get(0).get("Email"));
        }
        if(employeeDetailsMap.get(0).containsKey("Start Date")){
            employeeDetailsPage.enterStartDate(employeeDetailsMap.get(0).get("Start Date"));
        }

    }

    @And("^Presses Add Button$")
    public void pressesAddButton() {
        employeeDetailsPage.clickAddButton();
        System.out.println("Creating Employee " + employeeFirstName + " " + employeeLastName);
    }

    @Then("^Validate that employee has been added or updated in the employee list$")
    public void validateThatUserHasBeenAddedToTheEmployeeList() {
        employeesPage.validatePresenceOfEmployeeInList(employeeFirstName, employeeLastName);
    }

    @When("^User selects an employee record$")
    public void userSelectsAnEmployeeRecord() {
        employeesPage.clickAnEmployee(employeeFirstName, employeeLastName);
    }

    @And("^Presses Edit button on Employee List$")
    public void pressesEditButton() {
        employeesPage.clickUpdateButton();

    }

    @And("^Presses Update Button$")
    public void pressesUpdateButton() {
        employeeDetailsPage.clickUpdateButton();

    }

    @And("^Presses Delete button on Employee List$")
    public void pressesDeleteButtonOnEmployeeList() {
        employeesPage.pressDeleteButton();
    }

    @Then("^Validate that employee does not exist in Employee List$")
    public void validateThatEmployeeDoesNotExistInEmployeeList() {
        employeesPage.validateAbsenceOfEmployeeInList(employeeFirstName, employeeLastName);
    }

    @And("^Responds to Alert with \"([^\"]*)\"$")
    public void respondsToAlertWith(String response) {
        employeesPage.responseToAlert(response);
    }

    @And("^Presses Delete button on Employee Details screen$")
    public void pressesDeleteButtonOnEmployeeDetailsScreen() {
        employeeDetailsPage.clickDeleteButton();
    }

    @When("^User opens an employee record with double click$")
    public void userOpensAnEmployeeRecordWithDoubleClick() {
        employeesPage.doubleClickAnEmployeeRecord(employeeFirstName, employeeLastName);

    }

    @Then("^Validate that employee is not saved$")
    public void validateThatIncorrectEmailErrorIsShown() {
        employeeDetailsPage.validateThatEmployeeIsNotSaved();
    }

    @Then("^Validate that Invalid Date Error message is shown$")
    public void validateThatInvalidDateErrorMessageIsShown() {
        employeeDetailsPage.validatePresenceOfInvalidDateError();
    }
}
