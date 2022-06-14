@AfterMethod
    public void tearDown(ITestResult result){

        if(result.isSuccess()){
            //toma la captura
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            try {
                //guarda la captura
                FileUtils.copyFile(scrFile, new File("TEST-"+System.currentTimeMillis()+".png"));
            }
            catch (IOException e)
            {
                //captura cualquier error
                e.printStackTrace();
            }

        driver.quit();

    }
