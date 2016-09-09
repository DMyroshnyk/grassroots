package General;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

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
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div/form/button")).click();
        driver.manage().window().maximize();
    }

    public void JoinusPositive(String pagename, String firstname, String lastname, String email, String password) throws Exception {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/div/div[2]/div/a[2]")).click();
        driver.findElement(By.name("name")).sendKeys(pagename);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[3]/form/button")).click();
        driver.findElement(By.name("firstName")).sendKeys(firstname);
        driver.findElement(By.name("lastName")).sendKeys(lastname);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[2]/form/button")).click();
        driver.manage().window().maximize();
    }


}
