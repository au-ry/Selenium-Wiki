package apptestting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frames {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement iframe = driver.findElement(By.cssSelector("//fieldset[contains(.,'iFrame Example')]"));

        driver.switchTo().frame(iframe);


        WebElement reg = driver.findElement(By.xpath("/html/body/div/header/div[2]/div/div/div[2]/div[1]/a"));
        reg.click();
    }
}

