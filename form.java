package apptestting;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class test3 {
    public WebDriver driver;
    public static String tipo;
    public static String passenger;
    public static String desde;
    public static String mes1;
    public static String dia1;
    public static String destino;
    public static String mes2;
    public static String dia2;
    public static String servicio;
    public static String airline;


    @BeforeMethod

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void  testSteps1() throws InterruptedException {

        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        SoftAssert soft = new SoftAssert();

        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Find a Flight: Mercury Tours";
        //igual
        soft.assertEquals(ExpectedTitle, ActualTitle);

        //no igual
        soft.assertNotEquals(ExpectedTitle, ActualTitle);

        WebElement otipo = driver.findElement(By.xpath("//input[@value='oneway']"));
        Select opassenger = new Select(driver.findElement(By.name("passCount")));
        Select odesde = new Select(driver.findElement(By.name("fromPort")));
        Select omes1 = new Select(driver.findElement(By.name("fromMonth")));
        Select odia1 = new Select(driver.findElement(By.name("fromDay")));
        Select odestino = new Select(driver.findElement(By.name("toPort")));
        Select omes2 = new Select(driver.findElement(By.name("toMonth")));
        Select odia2 = new Select(driver.findElement(By.name("toDay")));
        WebElement oservicio = driver.findElement(By.xpath("//input[@value='First']"));
        Select oairline = new Select(driver.findElement(By.name("airline")));
        WebElement boton = driver.findElement(By.name("findFlights"));

        tipo = "oneway";
        passenger = "3";
        desde = "Zurich";
        mes1 = "8";
        dia1 = "10";
        destino = "Portland";
        mes2 = "12";
        dia2 = "10";
        servicio ="First";
        airline ="Pangea Airlines";

        otipo.click();
        opassenger.selectByValue(passenger);
        odesde.selectByValue(desde);
        omes1.selectByValue(mes1);
        odia1.selectByValue(dia1);
        odestino.selectByValue(destino);
        omes2.selectByValue(mes2);
        odia2.selectByValue(dia2);
        oservicio.click();
        oairline.selectByVisibleText(airline);
        Thread.sleep(3000);

        boton.click();


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



        }

        driver.quit();

    }

}
