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
import org.testng.asserts.SoftAssert;

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
        General general = new General(driver);
        SoftAssert softAssert = new SoftAssert();
        //general.LoginPositive(config.login, config.password);

        String parentHandle1 = driver.getWindowHandle(); // get the current window handle
        driver.findElement(By.xpath("//span[contains(.,'Facebook')]")).click(); // click some link that opens a new window

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        general.waitForAjax(driver);
        softAssert.assertTrue (driver.findElement(By.xpath("//span[contains(.,'Share on Facebook')]")).isDisplayed()); //code to do something on new window

        driver.close(); // close newly opened window when done with it
        softAssert.assertAll();
        driver.switchTo().window(parentHandle1); // switch back to the original window

    }


    @Test(priority=3)
    public void VerifyLNButtonLogged() throws Exception {
        General general = new General(driver);
        SoftAssert softAssert = new SoftAssert();
        //general.LoginPositive(config.login, config.password);

        String parentHandle2 = driver.getWindowHandle(); // get the current window handle
        driver.findElement(By.xpath("//span[contains(.,'Share')]")).click(); // click some link that opens a new window

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        general.waitForAjax(driver);
        softAssert.assertTrue (driver.findElement(By.xpath("//h1[@class='logo']")).isDisplayed()); //code to do something on new window

        driver.close(); // close newly opened window when done with it
        softAssert.assertAll();
        driver.switchTo().window(parentHandle2); // switch back to the original window


    }

    @Test(priority=4)
    public void VerifyTWButtonLogged() throws Exception {
        General general = new General(driver);
        SoftAssert softAssert = new SoftAssert();
        //general.LoginPositive(config.login, config.password);

        String parentHandle3 = driver.getWindowHandle(); // get the current window handle
        driver.findElement(By.xpath("//span[contains(.,'Tweet')]")).click(); // click some link that opens a new window

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        general.waitForAjax(driver);
        softAssert.assertTrue (driver.findElement(By.xpath("//a[contains(.,'Twitter')]")).isDisplayed()); //code to do something on new window

        driver.close(); // close newly opened window when done with it
        softAssert.assertAll();
        driver.switchTo().window(parentHandle3); // switch back to the original window


    }

    @Test(priority=1)
    public void VerifyEMButtonLogged() throws Exception {
        General general = new General(driver);
        SoftAssert softAssert = new SoftAssert();
        //general.LoginPositive(config.login, config.password);

        driver.findElement(By.xpath("//span[contains(.,'Email')]")).click(); // click some link that opens a new window

        general.waitForAjax(driver);

        softAssert.assertTrue (driver.findElement(By.id(":or")).isDisplayed()); //code to do something on new window

        driver.navigate().back();

    }

    @Test(priority=5)
    public void VerifyFBcircle() throws Exception {
        General general = new General(driver);
        SoftAssert softAssert = new SoftAssert();
        //general.LoginPositive(config.login, config.password);

       // Store the current window handle
        String winHandleBefore4 = driver.getWindowHandle();
        // Perform the click operation that opens new window
        driver.findElement(By.xpath("//a[@class='btn btn-secondary facebook circle']")).click(); // click some link that opens a new window
        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        general.waitForAjax(driver);

        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.titleContains("Facebook"));  // until this element is found

        // Perform the actions on new window

       // softAssert.assertEquals(driver.getTitle(),"(4) Facebook");
        softAssert.assertTrue(driver.getTitle().contains("Facebook"));

        // Close the new window, if that window no more required
        driver.close();
        // Switch back to original browser (first window)
        softAssert.assertAll();
        driver.switchTo().window(winHandleBefore4);
        // Continue with original browser (first window)

    }

    @Test(priority=6)
    public void VerifyTWcircle() throws Exception {
        General general = new General(driver);
        SoftAssert softAssert = new SoftAssert();
        //general.LoginPositive(config.login, config.password);

        // Store the current window handle
        String winHandleBefore5 = driver.getWindowHandle();
        // Perform the click operation that opens new window
        driver.findElement(By.xpath("//a[@class='btn btn-secondary twitter circle']")).click(); // click some link that opens a new window
        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        general.waitForAjax(driver);

        // Perform the actions on new window
        softAssert.assertEquals(driver.getTitle(),"Twitter / ?");
        // Close the new window, if that window no more required
        driver.close();
        // Switch back to original browser (first window)
        softAssert.assertAll();
        driver.switchTo().window(winHandleBefore5);
        // Continue with original browser (first window)

    }

    @Test(priority=7)
    public void VerifyYTbottomcircle() throws Exception {
        General general = new General(driver);
        SoftAssert softAssert = new SoftAssert();
        //general.LoginPositive(config.login, config.password);

        // Store the current window handle
        String winHandleBefore6 = driver.getWindowHandle();
        // Perform the click operation that opens new window
        driver.findElement(By.xpath("//a[@href='https://www.youtube.com/user/StarlightAus']")).click(); // click some link that opens a new window
        // Switch to new window opened
        for(String winHandle2 : driver.getWindowHandles()){
            driver.switchTo().window(winHandle2);
            //winHandle2.compareTo("https://www.youtube.com/user/StarlightAus");
        }

        general.waitForAjax(driver);

        // Perform the actions on new window
        softAssert.assertEquals(driver.getTitle(),"Starlight Children's Foundation - YouTube");
        // Close the new window, if that window no more required
        driver.close();
        // Switch back to original browser (first window)
        softAssert.assertAll();
        driver.switchTo().window(winHandleBefore6);
        // Continue with original browser (first window)

    }


    @Test(priority=8)
    public void VerifyFBbottomcircle() throws Exception {
        General general = new General(driver);
        SoftAssert softAssert = new SoftAssert();
        //general.LoginPositive(config.login, config.password);

        // Store the current window handle
        String winHandleBefore7 = driver.getWindowHandle();
        // Perform the click operation that opens new window
        driver.findElement(By.xpath("//a[@href='https://www.facebook.com/StarlightAustralia']")).click(); // click some link that opens a new window
        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        general.waitForAjax(driver);
        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,'Facebook')]")));  // until this element is found

        //WebDriverWait wait = new WebDriverWait(driver, 15);
        //wait.until(ExpectedConditions.titleContains("Starlight Children's Foundation Australia"));  // until this element is found


        // Perform the actions on new window
        softAssert.assertTrue(driver.getTitle().contains("Starlight Children's Foundation Australia"));
        // Close the new window, if that window no more required
        driver.close();
        // Switch back to original browser (first window)
        softAssert.assertAll();
        driver.switchTo().window(winHandleBefore7);
        // Continue with original browser (first window)

    }


    @Test(priority=9)
    public void VerifyTWbottomcircle() throws Exception {
        General general = new General(driver);
        SoftAssert softAssert = new SoftAssert();
        //general.LoginPositive(config.login, config.password);

        // Store the current window handle
        String winHandleBefore8 = driver.getWindowHandle();
        // Perform the click operation that opens new window
        driver.findElement(By.xpath("//a[@href='https://twitter.com/Starlight_star']")).click(); // click some link that opens a new window
        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        general.waitForAjax(driver);

        // Perform the actions on new window
        softAssert.assertEquals(driver.getTitle(),"Starlight Australia (@Starlight_star) | Twitter");
        // Close the new window, if that window no more required
        driver.close();
        // Switch back to original browser (first window)
        softAssert.assertAll();
        driver.switchTo().window(winHandleBefore8);
        // Continue with original browser (first window)

    }



   @Test(priority=10)
    public void VerifyINSTbottomcircle() throws Exception {
        General general = new General(driver);
       SoftAssert softAssert = new SoftAssert();
        //general.LoginPositive(config.login, config.password);

        // Store the current window handle
        String winHandleBefore9 = driver.getWindowHandle();
        // Perform the click operation that opens new window
        driver.findElement(By.xpath("//a[@href='http://instagram.com/starlightau']")).click(); // click some link that opens a new window
        // Switch to new window opened
        for(String winHandle3 : driver.getWindowHandles()){
            driver.switchTo().window(winHandle3);
            winHandle3.compareTo("https://www.instagram.com/starlightau/");
        }

       general.waitForAjax(driver);

        // Perform the actions on new window
       softAssert.assertEquals(driver.getTitle(),"Starlight Australia (@starlightau) • Instagram photos and videos");
        // Close the new window, if that window no more required
        driver.close();
        // Switch back to original browser (first window)
       softAssert.assertAll();
        driver.switchTo().window(winHandleBefore9);
        // Continue with original browser (first window)

    }

   @Test(priority=11)
    public void VerifyINSTcircle() throws Exception {
         General general = new General(driver);
         SoftAssert softAssert = new SoftAssert();
        // general.LoginPositive(config.login, config.password);

        // Store the current window handle
        String winHandleBefore10 = driver.getWindowHandle();
        // Perform the click operation that opens new window

        general.waitForAjax(driver);

       WebElement Tab = (new WebDriverWait(driver, config.LongWait)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://www.instagram.com/tour_de_kids/']")));
       Tab.click();

        //driver.findElement(By.xpath("//a[@href='https://www.instagram.com/tour_de_kids/']")).click(); // click some link that opens a new window


        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);

        }
       general.waitForAjax(driver);


        // Perform the actions on new window
       softAssert.assertEquals(driver.getTitle(),"Tour de Kids (@tour_de_kids) • Instagram photos and videos");
        // Close the new window, if that window no more required
        driver.close();
        // Switch back to original browser (first window)
       softAssert.assertAll();
        driver.switchTo().window(winHandleBefore10);
        // Continue with original browser (first window)

    }

}
