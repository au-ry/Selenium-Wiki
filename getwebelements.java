package apptestting;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class getwebelements {
    public WebDriver driver;


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

}

    @Test
    public void test1() throws IOException {
        driver.navigate().to("http://demo-store.seleniumacademy.com/");
        //obtener lista de elementos
        List<WebElement> elementos = driver.findElements(By.tagName("span"));
        System.out.println("numeros de elementos: "+elementos.size());
        System.out.println(elementos);

        for (WebElement element : elementos) {
            System.out.println("Paragraph text:" + element.getText());
        }
        System.out.println("-----------------------------------------------------");

        for(int i =0;i<elementos.size();i++) {
            String elementText = elementos.get(i).getText();
            System.out.println(elementText);
        }

}


    @AfterMethod

    public void tearDown(ITestResult result){

        if(!result.isSuccess()){
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(scrFile, new File("TEST-"+System.currentTimeMillis()+".png"));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }



        }

        driver.quit();

    }
}
