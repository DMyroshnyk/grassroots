package Tests;

import General.Basic;
import General.ConfigurationVariables;
import General.General;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

/**
 * Created by Dmitriy on 9/9/2016.
 */
public class verifyButtons extends Basic {

    ConfigurationVariables config = new ConfigurationVariables();

    @Test
    public void SwitchOnLogging() throws Exception {
        General general = new General(driver);
        general.LoginPositive(config.login, config.password);

    }


    @Test(priority=2)
    public void VerifyFBButtonLogged() throws Exception {
        //General general = new General(driver);
        //general.LoginPositive(config.login, config.password);

        String parentHandle = driver.getWindowHandle(); // get the current window handle
        driver.findElement(By.xpath("//span[contains(.,'Facebook')]")).click(); // click some link that opens a new window

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        Thread.sleep(10);
        Assert.assertTrue (driver.findElement(By.xpath("//span[contains(.,'Share on Facebook')]")).isDisplayed()); //code to do something on new window

        driver.close(); // close newly opened window when done with it
        driver.switchTo().window(parentHandle); // switch back to the original window

    }


    @Test(priority=3)
    public void VerifyLNButtonLogged() throws Exception {
        //General general = new General(driver);
        //general.LoginPositive(config.login, config.password);

        String parentHandle = driver.getWindowHandle(); // get the current window handle
        driver.findElement(By.xpath("//span[contains(.,'Share')]")).click(); // click some link that opens a new window

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        Thread.sleep(10);
        Assert.assertTrue (driver.findElement(By.xpath("//h1[@class='logo']")).isDisplayed()); //code to do something on new window

        driver.close(); // close newly opened window when done with it
        driver.switchTo().window(parentHandle); // switch back to the original window


    }

    @Test(priority=4)
    public void VerifyTWButtonLogged() throws Exception {
        //General general = new General(driver);
        //general.LoginPositive(config.login, config.password);

        String parentHandle = driver.getWindowHandle(); // get the current window handle
        driver.findElement(By.xpath("//span[contains(.,'Tweet')]")).click(); // click some link that opens a new window

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        Thread.sleep(10);
        Assert.assertTrue (driver.findElement(By.xpath("//a[contains(.,'Twitter')]")).isDisplayed()); //code to do something on new window

        driver.close(); // close newly opened window when done with it
        driver.switchTo().window(parentHandle); // switch back to the original window


    }

    @Test(priority=1)
    public void VerifyEMButtonLogged() throws Exception {
        //General general = new General(driver);
        //general.LoginPositive(config.login, config.password);

        driver.findElement(By.xpath("//span[contains(.,'Email')]")).click(); // click some link that opens a new window

        Thread.sleep(10);

        Assert.assertTrue (driver.findElement(By.id(":or")).isDisplayed()); //code to do something on new window

        driver.navigate().back();

    }

    @Test(priority=5)
    public void VerifyFBcircle() throws Exception {
        //General general = new General(driver);
        //general.LoginPositive(config.login, config.password);

       // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
        // Perform the click operation that opens new window
        driver.findElement(By.xpath("//a[@class='btn btn-secondary facebook circle']")).click(); // click some link that opens a new window
        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(10);
        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,'Facebook')]")));  // until this element is found

        String acttitle =  driver.getTitle();
        String exptitle = "Facebook";
        Assert.assertEquals(acttitle, exptitle, "Passed");

        // Perform the actions on new window
       // Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Facebook')]")).isDisplayed());
        // Close the new window, if that window no more required
        driver.close();
        // Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);
        // Continue with original browser (first window)

    }

    @Test(priority=6)
    public void VerifyTWcircle() throws Exception {
        //General general = new General(driver);
        //general.LoginPositive(config.login, config.password);

        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
        // Perform the click operation that opens new window
        driver.findElement(By.xpath("//a[@class='btn btn-secondary twitter circle']")).click(); // click some link that opens a new window
        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        Thread.sleep(30);
       // WebDriverWait wait = new WebDriverWait(driver, 5);
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='nav-logo-link']")));  // until this element is found

        String acttitle =  driver.getTitle();
        String exptitle = "Twitter / ?";
        Assert.assertEquals(acttitle, exptitle, "Passed");

        // Perform the actions on new window
       // Assert.assertTrue(driver.findElement(By.xpath("//a[@class='nav-logo-link']")).isDisplayed());
        // Close the new window, if that window no more required
        driver.close();
        // Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);
        // Continue with original browser (first window)

    }

    @Test(priority=7)
    public void VerifyYTbottomcircle() throws Exception {
        //General general = new General(driver);
        //general.LoginPositive(config.login, config.password);

        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
        // Perform the click operation that opens new window
        driver.findElement(By.xpath("//a[@href='https://www.youtube.com/user/StarlightAus']")).click(); // click some link that opens a new window
        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(50);
       // WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='logo masthead-logo-renderer-logo yt-sprite']")));  // until this element is found

        String acttitle =  driver.getTitle();
        String exptitle = "Starlight Children's Foundation - YouTube";
        Assert.assertEquals(acttitle, exptitle, "Passed");


        // Perform the actions on new window
        //Assert.assertTrue(driver.findElement(By.xpath("//span[@class='logo masthead-logo-renderer-logo yt-sprite']")).isDisplayed());
        // Close the new window, if that window no more required
        driver.close();
        // Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);
        // Continue with original browser (first window)

    }


    @Test(priority=8)
    public void VerifyFBbottomcircle() throws Exception {
       // General general = new General(driver);
        //general.LoginPositive(config.login, config.password);

        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
        // Perform the click operation that opens new window
        driver.findElement(By.xpath("//a[@href='https://www.facebook.com/StarlightAustralia']")).click(); // click some link that opens a new window
        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(50);
        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,'Facebook')]")));  // until this element is found

        String acttitle =  driver.getTitle();
        String exptitle = "Starlight Children's Foundation Australia";
        Assert.assertEquals(acttitle, exptitle, "Passed");

        // Perform the actions on new window
        //Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Facebook')]")).isDisplayed());
        // Close the new window, if that window no more required
        driver.close();
        // Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);
        // Continue with original browser (first window)

    }


    @Test(priority=9)
    public void VerifyTWbottomcircle() throws Exception {
        //General general = new General(driver);
        //general.LoginPositive(config.login, config.password);

        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
        // Perform the click operation that opens new window
        driver.findElement(By.xpath("//a[@href='https://twitter.com/Starlight_star']")).click(); // click some link that opens a new window
        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(30);
        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='Icon Icon--bird Icon--large']")));  // until this element is found

        String acttitle =  driver.getTitle();
        String exptitle = "Starlight Australia (@Starlight_star) | Twitter";
        Assert.assertEquals(acttitle, exptitle, "Passed");

        // Perform the actions on new window
       // Assert.assertTrue(driver.findElement(By.xpath("//span[@class='Icon Icon--bird Icon--large']")).isDisplayed());
        // Close the new window, if that window no more required
        driver.close();
        // Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);
        // Continue with original browser (first window)

    }



   @Test(priority=10)
    public void VerifyINSTbottomcircle() throws Exception {
        //General general = new General(driver);
        //general.LoginPositive(config.login, config.password);

        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
        // Perform the click operation that opens new window
        driver.findElement(By.xpath("//a[@href='http://instagram.com/starlightau']")).click(); // click some link that opens a new window
        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
       // driver.switchTo().alert().dismiss();
       Thread.sleep(30);

       String acttitle =  driver.getTitle();
       String exptitle = "Starlight Australia (@starlightau) • Instagram photos and videos";
       Assert.assertEquals(acttitle, exptitle, "Passed");

       // WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,'Instagram')]")));  // until this element is found

        // Perform the actions on new window
        //Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Instagram')]")).isDisplayed());
        // Close the new window, if that window no more required
        driver.close();
        // Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);
        // Continue with original browser (first window)

    }

   /* @Test(priority=11)
    public void VerifyINSTcircle() throws Exception {
        // General general = new General(driver);
        // general.LoginPositive(config.login, config.password);

        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
        // Perform the click operation that opens new window
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[@href='https://www.instagram.com/tour_de_kids/']")).click(); // click some link that opens a new window

        //driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/div[2]/div[2]/div/div[1]/div[2]/div/div[4]/div/a[3]")).click(); // click some link that opens a new window

        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);

        }
        Thread.sleep(30);
        //driver.switchTo().alert().dismiss();
        String acttitle =  driver.getTitle();
        String exptitle = "Tour de Kids (@tour_de_kids) • Instagram photos and videos";
        Assert.assertEquals(acttitle, exptitle, "Passed");


        //WebDriverWait wait = new WebDriverWait(driver, 50);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,'Find People')]")));  // until this element is found


        // Perform the actions on new window
        // Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'Find People')]")).isDisplayed());
        // Close the new window, if that window no more required
        driver.close();
        // Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);
        // Continue with original browser (first window)

    } */

}
