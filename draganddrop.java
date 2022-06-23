package apptestting;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class draganddrop {
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();



        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String title = driver.getTitle();
        System.out.println(title);

        String url = driver.getCurrentUrl();
        System.out.println(url);

        String page = driver.getPageSource();
        //System.out.println(page);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test1(){
        driver.get("https://demoqa.com/droppable/");

        Actions action = new Actions(driver);
        WebElement drag = driver.findElement(By.id("draggable"));

        WebElement drop = driver.findElement(By.id("droppable"));

        action.dragAndDrop(drag,drop).perform();



    }




    @AfterMethod
    public void tearDown(){
        //driver.close();//cierra la ventana
        //driver.quit();//cierra el navegador entero

    }
}
