package apptestting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.junit.Test;

public class test1 {

    public static void main(String[] args) {

        //Beforemethod

        //buscamos el driver
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

        //iniciamos el driver para abrir el navegador
        WebDriver driver = new ChromeDriver();
        
        //maximizar ventana
        driver.manage().window().maximize();
        
        //borrar las cookies
        //driver.manage().deleteAllCookies();

        //Test

        //abreme tal pagina
        driver.get("https://www.google.com/");
        //driver.navigate().to("https://www.google.com/");

        //encuentra elemento con nombre tal y enviale este texto
        driver.findElement(By.name("q")).sendKeys("selenium");

        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);


        //After Method


        //cerrar el browser
        driver.quit();



    }
}
