package General;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy on 9/9/2016.
 */
public class General extends Basic {


    ConfigurationVariables config = new ConfigurationVariables();

    public General(WebDriver driver) {
        this.driver = driver;
    }

    public void LoginPositive(String login, String password) throws Exception {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@class='login']")).click();
        driver.findElement(By.name("email")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='btn btn-primary primary-bg btn-block primary-bg']")).click();
        driver.manage().window().maximize();
    }

    public void JoinusPositive(String pagename, String firstname, String lastname, String email, String password) throws Exception {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[contains(.,'Join Us')]")).click();
        driver.findElement(By.name("name")).sendKeys(pagename);
        driver.findElement(By.xpath("//button[@class='btn btn-primary primary-bg btn-block primary-bg']")).click();
        driver.findElement(By.name("firstName")).sendKeys(firstname);
        driver.findElement(By.name("lastName")).sendKeys(lastname);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='btn btn-primary primary-bg btn-block primary-bg']")).click();
        driver.manage().window().maximize();
    }

   /* public void logOut () throws Exception {

       //locate the menu to hover over using its xpath
        WebElement menu = driver.findElement(By.xpath("//span[@class='dropdown']"));

        //Initiate mouse action using Actions class
        Actions builder = new Actions(driver);

        // move the mouse to the earlier identified menu option
        builder.moveToElement(menu).build().perform();

        // wait for max of 5 seconds before proceeding. This allows sub menu appears properly before trying to click on it
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,'Logout')]")));  // until this submenu is found


        //identify menu option from the resulting menu display and click
        builder.moveToElement(driver.findElement(By.xpath("//a[contains(.,'Logout')]"))).click();

    } */

    public static void waitForAjax(WebDriver driver) throws InterruptedException {
        new WebDriverWait(driver, 180).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                Object a = js.executeScript("return document.readyState == 'complete'");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return (Boolean) a;
            }
        });
    }

}
