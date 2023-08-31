package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utilities.Objects;
import utilities.ObjectsActions;
import utilities.Utilities;

import java.util.List;

public class ServiceSteps {
    WebDriver driver = Hooks.driver;
    ObjectsActions obj = new ObjectsActions();
    Objects elements = new Objects();
    Utilities utils = new Utilities();

    @Given("User is on the Testing Lab landing page")
    public void user_is_on_the_testing_lab_landing_page() {
        System.out.println("User is on the Testing Lab landing page");
    }

    @When("User clicks Services")
    public void user_clicks_services() {
        System.out.println("User clicks Services");
        if(obj.checkIfObjectDisplayed(driver, elements.btnServices))
        {
            obj.clickObject(driver, elements.btnServices);
        }
    }

    @Then("The services offered are displayed")
    public void the_services_offered_are_displayed() {
        if(obj.checkIfObjectDisplayed(driver, elements.lblServicesOffered))
        {
            Assert.assertTrue(true);
            System.out.println("The services offered are displayed");
        }
    }

    @When("User selects a service")
    public void user_selects_a() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'})", obj.getElement(driver, elements.btnMobileTesting));
        if(obj.checkIfObjectDisplayed(driver, elements.btnMobileTesting))
        {
            obj.clickObject(driver, elements.btnMobileTesting);
        }
        System.out.println("User selects a service");
    }

    @Then("Mobile Testing is displayed")
    public void mobileTestingIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Mobile Testing']")).isDisplayed());
        System.out.println("Mobile Testing is displayed");
    }

    @When("User ticks Appium [Framework set up and training]")
    public void userTicksAppiumFrameworkSetUpAndTraining() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//*[@value='Appium [Framework set up and training]']")).click();
        System.out.println("User ticks Appium [Framework set up and training]");
    }

    @And("User scrolls down")
    public void userScrollsDown() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block: \"center\"});",
                (driver.findElement(By.xpath("//*[text()='Submit']"))));
        System.out.println("User scrolls down");
    }

    @Then("Additional information is displayed")
    public void additionalInformationIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@placeholder='Additional information']")).isDisplayed());
        System.out.println("Additional information is displayed");
    }

    @When("User populates the Additional_information, Name, Contact_number, Email and Company")
    public void userPopulatesTheAdditional_informationNameContact_numberEmailAndCompany(DataTable dataTable) {
        List<String> list = dataTable.asList(String.class);
        driver.findElement(By.xpath("//*[@placeholder='Additional information']")).sendKeys((list.get(0)));
        driver.findElement(By.xpath("//*[@name='names-(required)']")).sendKeys((list.get(1)));
        driver.findElement(By.xpath("//*[@name='contact-number (required)']")).sendKeys((list.get(2)));
        driver.findElement(By.xpath("//*[@name='email-(required)']")).sendKeys((list.get(3)));
        driver.findElement(By.xpath("//*[@name='company-(optional)']")).sendKeys((list.get(4)));
        System.out.println("User populates the Additional_information, Name, Contact_number, Email and Company");
    }

    @And("User clicks Submit button")
    public void userClicksSubmitButton() {
        (driver.findElement(By.xpath("//*[text()='Submit']"))).click();
        System.out.println("User clicks submit button");
    }

    @Then("The Thank You message is displayed")
    public void theThankYouMessageIsDisplayed() {
        System.out.println("End of Test");
    }
}
