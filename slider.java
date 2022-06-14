@Test(description = "slider")
public void test3(){



        driver.get("https://demoqa.com/slider/");


        WebElement slider = driver.findElement(By.tagName("input"));
        WebElement value = driver.findElement(By.id("sliderValue"));

        for (int i = 0; i < 70; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
