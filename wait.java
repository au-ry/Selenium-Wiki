package apptestting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class wait {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
       driver= new ChromeDriver();
        driver.manage().window().maximize();
    }
        @Test
        public void test1(){


            driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

            WebElement btn = driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
            WebElement label = driver.findElement(By.xpath("//h4[.='Hello World!']"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            btn.click();
            WebElement load = driver.findElement(By.xpath("//*[@id=\"loading\"]"));
           wait.until(ExpectedConditions.invisibilityOf(load));
          System.out.println(label.getText());
        }

        @AfterMethod
    public void tearDown(){
        driver.quit();
        }




    }

