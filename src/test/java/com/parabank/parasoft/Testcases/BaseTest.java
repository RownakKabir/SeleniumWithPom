package com.parabank.parasoft.Testcases;

import com.parabank.parasoft.Pages.BasePage;
import com.parabank.parasoft.Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
WebDriver driver;
Page page;
    @BeforeMethod
    public void setupBrowser(){
 driver =new ChromeDriver();
 driver.get("https://parabank.parasoft.com/parabank/index.htm");
 driver.manage().window().maximize();
  page=new BasePage(driver);

    }
    @AfterMethod
 public void tearDown(){
        driver.quit();

 }


}
