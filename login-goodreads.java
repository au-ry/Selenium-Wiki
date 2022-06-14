package apptestting;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.*;
import org.testng.reporters.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class test2 {
public WebDriver driver;

            @BeforeMethod

            public void setUp() {
            System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }

            @Test
           public void testSteps1(){
            driver.navigate().to("https://www.goodreads.com/user/sign_in");
            driver.findElement(By.xpath("//button[@class='gr-button gr-button--dark gr-button--auth authPortalConnectButton authPortalSignInButton']")).click();
            driver.findElement(By.id("ap_email")).sendKeys("aury@hotmail.com");
            driver.findElement(By.name("password")).sendKeys("Pass");
            WebElement btn = driver.findElement(By.id("a-autoid-0-announce"));

            JavascriptExecutor js = (JavascriptExecutor)driver;
          js.executeScript("arguments[0].click()", btn);


            }



    @AfterMethod
    public void tearDown(ITestResult result){

        if(result.isSuccess()){
            //toma la captura
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            try {
                //guarda la captura
                FileUtils.copyFile(scrFile, new File("TEST-"+System.currentTimeMillis()+".png"));
            }
            catch (IOException e)
            {
                //captura cualquier error
                e.printStackTrace();
            }

        driver.quit();

    }}}














