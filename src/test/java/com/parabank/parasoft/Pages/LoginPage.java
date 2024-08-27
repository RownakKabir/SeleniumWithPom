package com.parabank.parasoft.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public LoginPage fillUsername(String username) {

        getWebElement(By.cssSelector("input[name='username']")).sendKeys(username);
        return this;
    }

    public LoginPage fillPassword(String password) {

        getWebElement(By.cssSelector("input[name='password']")).sendKeys(password);

        return this;
    }

    public AccountsOverviewPage clickloginBtn() {

        getWebElement(By.cssSelector("input[value='Log In']")).click();
        return getInstance(AccountsOverviewPage.class);



    }
    public LoginPage clickloginLinkBtn() {

        getWebElement(By.cssSelector("input[value='Log In']")).click();
        return this;



    }


    public CustomerLookupPage clickForgetLink() {
        getWebElement(By.cssSelector("a[href='lookup.htm']")).click();

        return getInstance(CustomerLookupPage.class);

    }


    public RegisterPage clickRegistrationLink() {
        getWebElement(By.cssSelector("a[href='register.htm']")).click();
        return getInstance(RegisterPage.class);

    }

    public boolean hasError(){

        return getWebElements(By.className("error")).size() > 0;

    }



    public AccountsOverviewPage doLogin(String username,String password){

        return fillUsername(username)
                .fillPassword(password)
                .clickloginBtn();
    }

}
