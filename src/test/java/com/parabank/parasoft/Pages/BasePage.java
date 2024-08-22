package com.parabank.parasoft.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends Page{
    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTittle() {
        return driver.getTitle();
    }

    @Override
    public WebElement getWebElement(By locator) {
        WebElement element=null;
        try {
            element= driver.findElement(locator);
        } catch (Exception e) {
           System.out.println(locator.toString() +"locator not found");
        }
        return element;
    }

    @Override
    public List<WebElement> getWebElements(By locator) {
        List<WebElement> elements=null;
        try {
            elements= driver.findElements(locator);
        } catch (Exception e) {
            System.out.println(locator.toString() +"locator not found");
        }
        return elements;

    }

    @Override
    public void waitForElement(By locator) {
wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
