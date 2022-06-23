package apptestting;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class windowsize {
public WebDriver driver;


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
       driver = new ChromeDriver();
        //posicion exacta del navegador
        driver.manage().window().setPosition(new Point(300,0));
        //tamano de la pantalla
        driver.manage().window().setSize(new Dimension(800, 800));
        //pantalla completa
        driver.manage().window().fullscreen();
        //maximizar
        driver.manage().window().maximize();
        //minimizar
        driver.manage().window().minimize();




        //Opens a new tab and switches to new tab
       driver.switchTo().newWindow(WindowType.TAB);

        // Opens a new window and switches to new window
        driver.switchTo().newWindow(WindowType.WINDOW);


        //Close the tab or window
       // driver.close();








        //para que dure mas abierto
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}

    @Test(description = "Obtener titulo y url")
    public void test1(){
    driver.navigate().to("http://demo-store.seleniumacademy.com/");
        String titulo = driver.getTitle();

        String url = driver.getCurrentUrl();
        System.out.println("el titulo es: "+titulo+"y la url es: "+url);



    }

        @AfterMethod
    public void tearDown(ITestResult result){
            System.out.println("El nombre del test case es: "+result.getMethod().getDescription()+ " y el resultado es: "+result.getStatus());
            System.out.println("Ejecutando las postcondiciones");
            System.out.println("Test case finalizado");
            driver.quit();
    }
}
