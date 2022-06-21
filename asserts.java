package apptestting;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class asserts {
    public WebDriver driver;
 int num1 = 10;
 int num2 = 5;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }


    //This Assertion verifies the Boolean value returned by the condition. If the Boolean value is true, then the assertion passes the test case.
    @Test
    public void numtrue(){
        Assert.assertTrue(num1==num2,"el numero es verdadero"+num1);

    }
    //This method works opposite of that of assertTrue(). The Assertion verifies the Boolean value returned by the condition. If the Boolean value is false, then the assertion passes the test case.
    @Test
    public void numfalse(){
        Assert.assertFalse(num1==num2+5,"los numeros no son iguales "+num1+" != "+num2);

    }
    //This method takes a minimum of 2 arguments and compares actual results with expected results. If both match, then the assertion is passed and the test case is marked as passed. assertEquals() can compare Strings, Integers, Doubles and many more variables
    @Test
    public void numEquals(){
        Assert.assertEquals(num1,num2+5);

    }

    @Test
    public void numNotEquals(){
Assert.assertNotEquals(num1,num2);


    }

    @AfterMethod
    public void tearDown(ITestResult result){

        if(!result.isSuccess()){
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(scrFile, new File("TEST-"+System.currentTimeMillis()+".png"));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }



        }

        driver.quit();

    }
}
