package employeeManagementTestSuite.pageObjects.locators;

public interface EmployeeDetailsPageLocators {

    String xTxtFirstName = ".//input[@ng-model='selectedEmployee.firstName']";
    String xTxtLastName = ".//input[@ng-model='selectedEmployee.lastName']";
    String xTxtStartDate = ".//input[@ng-model='selectedEmployee.startDate']";
    String xTxtEmail = ".//input[@ng-model='selectedEmployee.email']";


    String xAddButton = ".//button[contains(text(),'Add')]";
    String xUpdateButton = ".//button[contains(text(),'Update')]";
    String xDeleteButton = ".//p[@ng-click='deleteEmployee()']";

}
