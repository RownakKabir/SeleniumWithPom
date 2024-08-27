package com.parabank.parasoft.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsOverviewPage extends BasePage {
    public AccountsOverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasLogout(){

        return  getWebElements(By.cssSelector("a[href^='logout' ]")).size()> 0;
    }

    public OpenNewAccountPage clickOpenNewAccountLink(){
        getWebElement(By.cssSelector("a[href='openaccount.htm']")).click();

        return getInstance(OpenNewAccountPage.class);
    }
}
