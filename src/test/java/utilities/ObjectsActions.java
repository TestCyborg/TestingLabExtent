package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ObjectsActions {
    WebDriver driver;

    public void clickObject(WebDriver driver, By element)
    {
        if(driver.findElements(element).size()!=0)
        {
            driver.findElement(element).click();
        }
    }

    public WebElement getElement(WebDriver driver, By element)
    {
        WebElement wElement = null;
        if(driver.findElements(element).size()!=0)
        {
            wElement = driver.findElement(element);
        }
        return wElement;
    }

    public void scrollToObject(WebDriver driver, WebElement element)
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'})", element);
    }

    public boolean checkIfObjectDisplayed(WebDriver driver, By el)
    {
        boolean exists = false;
        try
        {
            WebElement element;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(el));
            if ((driver.findElement(el)).isDisplayed() == true)
            {
                exists = true;
            }
        }catch (Exception ex)
        {
            ex.getStackTrace();
        }
        return exists;
    }

}
