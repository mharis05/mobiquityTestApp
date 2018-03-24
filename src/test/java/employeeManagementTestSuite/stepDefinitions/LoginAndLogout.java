package employeeManagementTestSuite.stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import employeeManagementTestSuite.pageObjects.EmployeesPage;
import employeeManagementTestSuite.pageObjects.LoginPage;
import employeeManagementTestSuite.utils.EmployeeManagerWaits;

import java.util.List;
import java.util.Map;

public class LoginAndLogout extends BaseTest {

    private LoginPage loginPage = new LoginPage();
    private EmployeesPage employeesPage = new EmployeesPage();

    //Stored as a member variable to be used for validation later
    private String userName;

    @Given("^Employee management app is open in browser$")
    public void employeeManagementAppIsOpenInBrowser() {
        driver.get(url);
        driver.manage().window().maximize();
        EmployeeManagerWaits.waitForSeconds(driver,30);
    }


    @When("^User enters credentials$")
    public void userEntersValidCredentials(DataTable tblUserDetails) {

        List<Map<String, String>> userDetails = tblUserDetails.asMaps(String.class, String.class);

        userName = userDetails.get(0).get("Username");

        loginPage.enterUserName(userName);
        EmployeeManagerWaits.waitForSeconds(driver,5);

        loginPage.enterPassword(userDetails.get(0).get("Password"));
        EmployeeManagerWaits.waitForSeconds(driver,5);
    }

    @And("^Presses login button$")
    public void pressesLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("^Validate that User has successfully logged in$")
    public void validateThatUserHasSuccessfullyLoggedIn() {
        employeesPage.validateGreetings(userName);
    }

    @And("^User is able to log out$")
    public void userIsAbleToLogOut() {
        employeesPage.clickLogoutButton();
        loginPage.validatePresenceOfLoginButton();

    }

    @Then("^Validate that Error message is shown$")
    public void validateThatErrorMessageIsShown() {
        loginPage.validatePresenceOfErrorMessage();
    }
}
