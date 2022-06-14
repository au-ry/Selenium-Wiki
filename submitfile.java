public class fileSubmition {




@Test
public void test() {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\pruebas\\driver\\chromedriver.exe");
WebDriver driver= new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://demoqa.com/automation-practice-form");
WebElement file = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
file.sendKeys("tu ruta");

}

@Test
public void test2() {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\pruebas\\driver\\chromedriver.exe");
WebDriver driver= new ChromeDriver();
driver.get("https://the-internet.herokuapp.com/upload");
WebElement file1 = driver.findElement(By.xpath("//input[@id='file-upload']"));
file1.sendKeys("tu ruta");
WebElement btn = driver.findElement(By.xpath("//input[@id='file-submit']"));
btn.click();
}
}
