@Test(description = "Hover simple")
public void test1(){

System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\pruebas\\driver\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();

driver.get("https://rahulshettyacademy.com/AutomationPractice/");



Actions action = new Actions(driver);
WebElement btn = driver.findElement(By.id("mousehover"));

//Para hacer scrollDown
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].scrollIntoView();", btn);


//Para hacer hover
action.moveToElement(btn).perform();
WebElement submenu = driver.findElement(By.linkText("Top"));
action.moveToElement(submenu).perform();
submenu.click();


}


@Test(description = "hover avanzado")
public void test2(){
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\pruebas\\driver\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://demoqa.com/menu/");

//Para hacer hover en el primer menu
Actions action = new Actions(driver);
WebElement menu = driver.findElement(By.linkText("Main Item 2"));
action.moveToElement(menu).perform();



//Para hacer hover en opcion de menú
WebElement submenu = driver.findElement(By.linkText("SUB SUB LIST »"));
action.moveToElement(submenu).perform();



//Para hacer hover en opcion de opcion de menu
WebElement submenu1 = driver.findElement(By.linkText("Sub Sub Item 1"));
action.moveToElement(submenu1).perform();
submenu1.click();



}
