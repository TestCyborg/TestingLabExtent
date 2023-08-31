package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSetup {
    static WebDriver driver;
    public static WebDriver getDriver()
    {
        String browser = "firefox";
        switch (browser.toUpperCase())
        {
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new EdgeDriver(options);
                break;
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(optionsChrome);
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
//                FirefoxOptions optionsFox = new FirefoxOptions();
//                optionsFox.addArguments("--remote-allow-origins=*");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Select browser");
                break;
        }
        driver.navigate().to("https://www.dialtestinglab.co.za");
        driver.manage().window().maximize();
        return driver;
    }
}
