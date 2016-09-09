package Tests;

import General.Basic;
import General.ConfigurationVariables;
import General.General;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Dmitriy on 9/9/2016.
 */
public class verifyButtons extends Basic {

    ConfigurationVariables config = new ConfigurationVariables();

    @Test
    public void VerifyLNButtonLogged() throws Exception {
        General general = new General(driver);
        general.LoginPositive(config.login, config.password);

        String parentHandle = driver.getWindowHandle(); // get the current window handle
        driver.findElement(By.xpath("//span[contains(.,'Share')]")).click(); // click some link that opens a new window

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        Assert.assertTrue (driver.findElement(By.xpath("/html/body/div[1]/div[1]/h1")).isDisplayed()); //code to do something on new window

        driver.close(); // close newly opened window when done with it
        driver.switchTo().window(parentHandle); // switch back to the original window

    }

    @Test
    public void VerifyTWButtonLogged() throws Exception {
        General general = new General(driver);
        //general.LoginPositive(config.login, config.password);

        String parentHandle = driver.getWindowHandle(); // get the current window handle
        driver.findElement(By.xpath("//span[contains(.,'Tweet')]")).click(); // click some link that opens a new window

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        Assert.assertTrue (driver.findElement(By.xpath("/html/body/div[1]/div/h1/a")).isDisplayed()); //code to do something on new window

        driver.close(); // close newly opened window when done with it
        driver.switchTo().window(parentHandle); // switch back to the original window

    }

}
