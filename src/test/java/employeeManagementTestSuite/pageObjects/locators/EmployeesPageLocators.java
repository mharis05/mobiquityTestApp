package employeeManagementTestSuite.pageObjects.locators;

public interface EmployeesPageLocators {

    String cssLblGreeting = "#greetings";
    String xBtnLogout = ".//p[@ng-click='logout()']";
    String cssBtnCreateEmployee = "#bAdd";
    String cssBtnEditEmployee = "#bEdit";
    String xLiEmpName = ".//*[@id='employee-list']/li[contains(text(),'FULLNAME')]";
    String cssBtnDeleteEmployee = "#bDelete";
    String xAllEmployees = ".//*[@id='employee-list']/li";
}
