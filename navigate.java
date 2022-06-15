package apptestting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigation { //NAVIGATION COMMANDS

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        String pagina ="https://the-internet.herokuapp.com/";
        driver.navigate().to(pagina);

        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[11]/a")).click();

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().to(pagina);
        driver.navigate().refresh();


        driver.quit();


    }
}
