//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package apptestting;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Selenium4 {
    WebDriver driver;
    DevTools devTools;
    SoftAssert soft = new SoftAssert();
    int num1 = 10;
    int num2 = 5;

    public Selenium4() {
    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("http://automationpractice.com/index.php");
        System.out.println(this.driver.getTitle());
    }

    @Test(
        priority = 2,
        description = "credentials"
    )
    public void test1() {
        WebElement loginPanel = this.driver.findElement(By.id("logInPanelHeading"));
        WebElement credentials = this.driver.findElement(RelativeLocator.with(By.tagName("span")).above(loginPanel));
        System.out.println(credentials.getText());
    }

    @Test(
        groups = {"test"},
        priority = 1
    )
    public void test2() {
        List<WebElement> allSocialMedia = this.driver.findElements(RelativeLocator.with(By.tagName("img")).near(By.id("footer")));
        Iterator var2 = allSocialMedia.iterator();

        while(var2.hasNext()) {
            WebElement socialmedia = (WebElement)var2.next();
            System.out.println(socialmedia.getAttribute("alt"));
        }

    }

    @Test(
        groups = {"test"},
        dependsOnMethods = {"test2"}
    )
    public void test3() {
        Assert.assertEquals(this.num1 - 5, this.num2);
    }

    @Test
    public void test4() {
        WebDriver window = this.driver.switchTo().newWindow(WindowType.WINDOW);
        window.get("http://automationpractice.com/index.php");
        System.out.println(this.driver.getTitle());
    }

    @Test
    public void test5() {
        this.driver.switchTo().newWindow(WindowType.TAB).get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        System.out.println(this.driver.getTitle());
        WebElement text = this.driver.findElement(By.id("email_create"));
        WebElement btn = this.driver.findElement(By.xpath("//span[contains(.,'Create an account')]"));
        text.sendKeys(new CharSequence[]{"aury@yahoo.com"});
        btn.click();
        Set<String> all = this.driver.getWindowHandles();
        Iterator<String> it = all.iterator();
        String first = (String)it.next();
        this.driver.switchTo().window(first);
        WebElement search = this.driver.findElement(By.id("search_query_top"));
        WebElement btn2 = this.driver.findElement(By.name("submit_search"));
        search.sendKeys(new CharSequence[]{"dress"});
        btn2.click();
        System.out.println(this.driver.getTitle());
        WebElement img = this.driver.findElement(By.xpath("//div[@id='header_logo']/a/img"));
        Rectangle rec = img.getRect();
        System.out.println(rec.getX());
        System.out.println(rec.getY());
        System.out.println(rec.getWidth());
        System.out.println(rec.getHeight());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.isSuccess()) {
            File scrFile = (File)((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(scrFile, new File("TEST-" + System.currentTimeMillis() + ".png"));
            } catch (IOException var4) {
                var4.printStackTrace();
            }

            this.driver.quit();
        }

    }
}
