package apptestting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class select {
WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
         driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");


    }

    @Test (description = "seleccionar opcion en el select")
    public void test1(){

        Select select   = new Select(driver.findElement(By.id("oldSelectMenu")));
        select.selectByIndex(5);
        select.selectByValue("10");
        select.selectByVisibleText("Voilet");


    }
@Test(description = "imprimir opciones")
public void test2(){
    Select select   = new Select(driver.findElement(By.id("oldSelectMenu")));
    List<WebElement> lst = select.getOptions();
    System.out.println("Las opciones son :");
    for(WebElement opciones: lst)
        System.out.println(opciones.getText());

}

@Test(description = "select multiple ")
public void test3(){
        //selecciona
    Select multi = new Select(driver.findElement(By.id("cars")));
    if (multi.isMultiple()) {
        multi.selectByIndex(1);
        multi.selectByIndex(2);

        //imprime los elementos
        List<WebElement> lista = multi.getOptions();
        System.out.println("Las opciones son :");

        for (WebElement opciones:lista)
            System.out.println(opciones.getText());
    }
    
  //descelecciona los elementos
    multi.deselectAll();
}
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
