package com.parabank.parasoft.Testcases;

import com.parabank.parasoft.Pages.BasePage;
import com.parabank.parasoft.Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    Page page;
    protected Properties properties;

    public BaseTest() {
            try {
                properties = new Properties();
                String filePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
                FileInputStream inputStream = new FileInputStream(filePath);
                properties.load(inputStream);

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


    }


    @BeforeMethod
    public void setupBrowser() {
        String browserName = properties.getProperty("browseName");
        switch (browserName) {
            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefoxHeadless":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "chromeHeadless":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                break;
            default:
                System.out.println("Please provide right Browser Name");
                break;

        }


        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
        page = new BasePage(driver);
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

    public  String getUsername(){
        return properties.getProperty("username");
    }
   public  String getPassword(){
        return  properties.getProperty("password");
}

}
