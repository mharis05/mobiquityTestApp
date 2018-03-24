package employeeManagementTestSuite.pageObjects.locators;

public interface LoginPageLocators {

    String xTxtLoginUserName = ".//*[@ng-model='user.name']";
    String xTxtLoginPassword = ".//*[@ng-model='user.password']";
    String xBtnLogin = ".//button[@type='submit']";
    String xErrorMessage = ".//p[contains(@class, 'error-message')]";

}
