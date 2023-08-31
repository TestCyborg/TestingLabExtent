package stepDefinitions;

import driverManager.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks extends DriverSetup {
    static WebDriver driver;
    @Before
    public void setup(Scenario scenario)
    {
        if (driver == null)
        {
            driver = getDriver();
            System.out.println("Test Case: "+ (scenario.getName()));
        }
    }
    @AfterStep
    public void captureScreen(Scenario scenario)
    {
        byte[] source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(source, "image/png", "screen");
    }
    @After
    public void teardown(Scenario scenario)
    {
        System.out.println("Test Case: "+ scenario.getName());
        driver.quit();
    }
}
