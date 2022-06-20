package apptestting;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class keys {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        WebElement name= driver.findElement(By.id("userName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement dir1 = driver.findElement(By.id("currentAddress"));
        WebElement dir2= driver.findElement(By.id("permanentAddress"));
        WebElement btn = driver.findElement(By.id("submit"));


        name.sendKeys("Mr.Peter Haynes");
        email.sendKeys("PeterHaynes@toolsqa.com");
        dir1.sendKeys("43 School Lane London EC71 9GO");
        dir1.click();
        dir1.sendKeys(Keys.CONTROL+"A");
        dir1.sendKeys(Keys.CONTROL+"C");



        dir2.sendKeys(Keys.CONTROL+"V");
        //dir2.sendKeys("hola");
        assertEquals(dir1.getAttribute("value"),dir2.getAttribute("value"));;

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", btn);

       //driver.quit();

    }
}
