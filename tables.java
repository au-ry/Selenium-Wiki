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
            driver.get("https://www.w3schools.com/html/html_tables.asp");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
        @Test(description = "encontrar numero de filas")
        public void test1() {
            List<WebElement> filas=driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[2]/td[1]"));
            int numfila = filas.size();
            System.out.println("La cantidad de filas en esta tabla son :" +numfila);
        }
    @Test(description = "encontrar numero de columnas")
    public void test2() {
        List<WebElement> columnas=driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[2]/td[1]"));
        int numcol = columnas.size();
        System.out.println("La cantidad de filas en esta tabla son :" +numcol);
    }
        @AfterMethod
        public void tearDown(){

            driver.quit();
        }
    }

