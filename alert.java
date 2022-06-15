package apptestting;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.tree.ExpandVetoException;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class alert {
WebDriver driver;
   @BeforeMethod
   public void setUp()

    {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");

    }

    @Test(description = "confirm alert")
    public void test1(){
        WebElement btn1 = driver.findElement(By.xpath("//button[@id='alertButton']"));
        btn1.click();
        String text = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        System.out.println(text);
    }
    @Test(description = "waiting alert")
    public void test2() {
        WebElement btn2 = driver.findElement(By.id("timerAlertButton"));
        try {
            btn2.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
@Test(description = "dismiss alert")
        public void test3() {
    WebElement btn3 = driver.findElement(By.id("confirmButton"));

    btn3.click();
    driver.switchTo().alert().dismiss();
}

@Test(description = "form alerts")
        public void test4() {
    WebElement btn4 = driver.findElement(By.id("promtButton"));
    btn4.click();
    driver.switchTo().alert().sendKeys("Aury");
    driver.switchTo().alert().accept();
}
@Test(description = "Context Menu")
        public void test5(){

        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(By.id("hot-spot"));
        actions.contextClick(elementLocator).perform();
        driver.switchTo().alert().accept();


    }
}
