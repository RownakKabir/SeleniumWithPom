package com.parabank.parasoft.Testcases;

import com.parabank.parasoft.Pages.AccountsOverviewPage;
import com.parabank.parasoft.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void loginshouldfail(){
        LoginPage loginpage=page.getInstance(LoginPage.class);
        loginpage=loginpage
                .fillPassword("1233")
                .clickloginLinkBtn();

        Assert.assertTrue(loginpage.hasError());


    }
    @Test
    public void loginShouldFail(){
        LoginPage loginpage= page.getInstance(LoginPage.class);
        loginpage=loginpage.fillUsername("dgjhg")
                .fillPassword("5345")
                .clickloginLinkBtn();
        Assert.assertTrue(loginpage.hasError());

    }
    @Test
    public void  loginshouldsuccess(){
         LoginPage loginpage=page.getInstance(LoginPage.class);
         AccountsOverviewPage overviewPage=loginpage
                 .fillUsername("sqa")
                 .fillPassword("sqa")
                 .clickloginBtn();

        Assert.assertTrue(overviewPage.hasLogout());

    }
}
