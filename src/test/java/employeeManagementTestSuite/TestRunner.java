package employeeManagementTestSuite;


import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/DeleteEmployee.feature",
        plugin = { "pretty", "html:target/htmlreport","com.cucumber.listener.ExtentCucumberFormatter:target/testReport.html"})
public class TestRunner {


    // Generate extentReort (HTML based report) in the target folder
    // Find the report with filename: testReport.html

    @AfterClass
    public static void setup() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Win 10");
    }
}
