package General;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by Dmitriy on 9/1/2016.
 */





public class testgrass {


    @Test
    public void MyFirstTest (){
        WebDriver driver;
        // declaration and instantiation of objects/variables
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        String baseUrl = "https://stg.grassrootz.com/starlight/tour-de-kids-2017";
        String expectedTitle = "Help support Tour De Kids 2017";
        String actualTitle = "";
        String visitName = "";
        String expectedVisitName = "VISIT OUR WEBSITE";

        // launch Firefox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();
        visitName = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[2]/div/div[1]/div[2]/div/div[3]/h5")).getText();
        /*
         * compare the actual title of the page witht the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }




        if (visitName.contentEquals(expectedVisitName)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }



        //close Firefox
        driver.quit();


        // exit the program explicitly
        //System.exit(0);



    }

}
