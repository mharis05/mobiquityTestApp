package employeeManagementTestSuite.stepDefinitions;

import org.openqa.selenium.WebDriver;


/**
 * BaseTest.java
 * Purpose: Basic test features defined here.
 *
 * @author Haris Saleem
 */

public class BaseTest {

    protected static WebDriver driver;
    private static BrowserInvoke invokeBrowser = new BrowserInvoke();
    protected String url = "http://cafetownsend-angular-rails.herokuapp.com";
    //Overriding SharedDriver implementation to make sure all driver instances
    //are killed after completion of text execution.

    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            try {
                driver.quit();
            } catch ( Exception e ) {
                // e.printStackTrace();
            }
        }
    };

    //static block to initialize driver as soon as tests are fired from Runner Class
    static {
        initializeWebDriver();
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }
    //provide browser name in the parameter (Not case sensitive)
    private static void initializeWebDriver() {
        driver = invokeBrowser.openBrowser("chrome");
    }


}
