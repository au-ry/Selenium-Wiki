package apptestting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class scroll {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/large");
    }
    @Test(description = "scroll to specific element")
            public void test1(){
        WebElement table = driver.findElement(By.id("large-table"));
        String script = "arguments[0].scrollIntoView();";
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(script,table);
    }
@Test(description = "scroll by pixel")
    public void test2(){
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(0,1000)");

    }

    @Test(description = "scroll to bottom")
    public void test3(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Test(description = "scroll to horizontal element")
    public void test4(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement element = driver.findElement(By.xpath("//*[@id=\"large-table\"]/tbody/tr[8]/td[50]"));
        String script = "arguments[0].scrollIntoView();";
        js.executeScript(script,element);
    }

}
