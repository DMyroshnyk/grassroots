package General;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy on 9/8/2016.
 */
public class Basic {

    public static WebDriver driver;
    ConfigurationVariables config = new ConfigurationVariables();

    @BeforeSuite()
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\Dmitriy\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.get(config.URL);


        //General general = new General(driver);
        //general.JoinusPositive(config.pagename, config.firstname, config.lasttname, config.email, config.password);

    }



    @AfterSuite()
    public void browserDown () throws Exception {

       driver.quit();

    }


}
