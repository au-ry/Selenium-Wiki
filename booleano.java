package apptestting;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class booleano {
    public static void main(String[] args) {//WEBELEMENTS COMMANDS
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        String pagina ="https://demoqa.com/automation-practice-form";
        driver.get(pagina);

        WebElement nombre = driver.findElement(By.id("firstName"));
        nombre.sendKeys("Orquidea");
        nombre.clear();
        nombre.sendKeys("Rosa");
        String texto = driver.findElement(By.id("userName-label")).getText();
        System.out.println(texto);
        String tag = nombre.getTagName();
        System.out.println(tag);
        String css = nombre.getCssValue("font-size");
        System.out.println(css);
        String css1 = nombre.getAttribute("font-size");
        System.out.println(css1);
        Dimension size = nombre.getSize();
        System.out.println(size);
        Point point = nombre.getLocation();
        System.out.println(point);



        System.out.println("***********************************************************************");

        ///isDisplayed

        boolean email = driver.findElement(By.id("userEmail")).isDisplayed();
        if (email== true){

            System.out.println("se ve el elemento");
        }
        else{

            System.out.println("no se ve el elemento");
        }
        System.out.println("***********************************************************************");
        //isEnabled

        boolean city = driver.findElement(By.id("city")).isEnabled();
        if(city){

            System.out.println("esta habilitado");

        }else{

            System.out.println("no esta habilitado");
        }

        System.out.println("***********************************************************************");

        ///isSelected

        //driver.findElement(By.cssSelector("label[for='hobbies-checkbox-2']")).click();
        boolean hobbies = driver.findElement(By.id("hobbies-checkbox-2")).isSelected();
        if (hobbies == true){

            System.out.println("esta seleccionado");
        }else {
            System.out.println("NO esta seleccionado");
        }

        /*WebElement element = driver.findElement(By.id("SubmitButton"));
        element.submit();*/
        System.out.println("***********************************************************************");
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        System.out.println(inputs.size());
        for(WebElement inputElement : inputs)
        {
            System.out.println(inputElement.getAttribute("placeholder"));
        }
        System.out.println("***********************************************************************");

       driver.quit();

    }

}
