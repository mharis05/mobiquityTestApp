package employeeManagementTestSuite.stepDefinitions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * BrowserInvoke.java
 * Purpose: WebDriver declaration, contains the implementation which
 * encapsulates browser selection.
 *
 * @author Haris Saleem
 */

public class BrowserInvoke {


    String browserName = null;
    private String chromeDriverPath = "src/test/resources/drivers/chromedriver.exe";
    private String mozillaPath = "src/test/resources/drivers/geckodriver.exe";

    public WebDriver openBrowser(String browserName) {

        System.out.println("Tests ready to be executed in " + browserName.toUpperCase());

        WebDriver myDriver = null;

        if (browserName.equalsIgnoreCase("FIREFOX")) {
            System.setProperty("webdriver.firefox.marionette", "true");
            System.setProperty("webdriver.gecko.driver", mozillaPath);
            myDriver = new FirefoxDriver();

        } else {

            if (browserName.equalsIgnoreCase("CHROME")) {
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                myDriver = new ChromeDriver();

            } else {

                if(browserName.equalsIgnoreCase("HEADLESS")){
                    System.setProperty("webdriver.chrome.driver",chromeDriverPath);
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("headless");
                    options.addArguments("window-size=1920x1080");
                    myDriver = new ChromeDriver(options);
                } else {
                    return null;
                }

            }
        }

        return myDriver;
    }
}
