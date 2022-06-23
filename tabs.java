package apptestting;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Dimension;

import java.util.ArrayList;

public class tabs {
    public WebDriver driver;
    ArrayList<String> tabs;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(414, 896));

        driver.navigate().to("http://demo-store.seleniumacademy.com/");

        JavascriptExecutor javas = (JavascriptExecutor)driver;
        String google = "window.open('https://www.google.com/')";
        javas.executeScript(google);



        tabs = new ArrayList<String>(driver.getWindowHandles());

    }

    @Test
    public void test1(){


        driver.switchTo().window(tabs.get(1)).navigate().to("https://mail.google.com/mail/u/0/?ogbl#inbox");
        driver.switchTo().window(tabs.get(0)).navigate().to("https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/");
    }


    @AfterMethod
    public void tearDown(){

        driver.quit();
       
    }
}
