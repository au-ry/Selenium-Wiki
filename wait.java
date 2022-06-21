package apptestting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class wait {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(100, SECONDS);

        driver.manage().timeouts().setScriptTimeout(100,SECONDS);

        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement btn = driver.findElement(By.xpath("/html[@class='no-js']/body/div[@class='row'][2]/div[@id='content']/div[@class='example']/div[@id='start']/button"));
        WebElement label = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        btn.click();
        WebElement mensaje = driver.findElement(By.xpath("/html[@class='no-js']/body/div[@class='row'][2]/div[@id='content']/div[@class='example']/div[@id='loading']/img/@src"));
        wait.until(ExpectedConditions.invisibilityOf(mensaje));
        System.out.println(label.getText());




    }
}
