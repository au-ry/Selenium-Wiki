package apptestting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class tables  {
        public WebDriver driver;

        @BeforeMethod
        public void setUp(){

            System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
            driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/webtables");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
        @Test
        public void test1() {
            List<WebElement> nombre=driver.findElements(By.xpath("//div[@class='rt-tr']/div[@class='rt-th rt-resizable-header -cursor-pointer']/div[.='First Name']"));

        }

        @AfterMethod
        public void tearDown(){

            //driver.quit();
        }
    }

