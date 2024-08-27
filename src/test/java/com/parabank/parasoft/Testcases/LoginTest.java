package com.parabank.parasoft.Testcases;

import com.parabank.parasoft.Pages.AccountsOverviewPage;
import com.parabank.parasoft.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void loginshouldfail(){
        LoginPage loginpage=page.getInstance(LoginPage.class)
                .fillPassword(getUsername())
                .clickloginLinkBtn();

        Assert.assertTrue(loginpage.hasError());


    }
    @Test
    public void loginShouldFail(){
        LoginPage loginpage= page.getInstance(LoginPage.class)
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickloginLinkBtn();
        Assert.assertTrue(loginpage.hasError());

    }
    @Test
    public void  loginshouldsuccess(){
        AccountsOverviewPage overviewPage=page.getInstance(LoginPage.class)
                 .fillUsername(getUsername())
                 .fillPassword(getPassword())
                 .clickloginBtn();

        Assert.assertTrue(overviewPage.hasLogout());

    }
}
