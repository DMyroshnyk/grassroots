package Tests;

import General.Basic;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import General.General;
import General.ConfigurationVariables;


import java.util.concurrent.TimeUnit;




/**
 * Created by Dmitriy on 9/14/2016.
 */

public class verifyJoinus extends Basic{


    ConfigurationVariables config = new ConfigurationVariables();

    @Test
    public void SmallBigJoinus() throws Exception {

        General general = new General(driver);

        general.JoinusPositiveSmall(config.pagenamesm, config.firstname, config.lasttname, config.emailsm, config.password);

        general.waitForAjax(driver);

        driver.navigate().refresh();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        general.logOut();

        general.waitForAjax(driver);

        driver.findElement(By.xpath("//a[@href='/starlight/tour-de-kids-2017']")).click();
        driver.navigate().refresh();

        general.JoinusPositiveBig(config.pagenamebig, config.firstname, config.lasttname, config.emailbig, config.password);

        general.waitForAjax(driver);

        driver.navigate().refresh();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        general.logOut();




    }

}
