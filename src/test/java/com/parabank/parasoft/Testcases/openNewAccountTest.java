package com.parabank.parasoft.Testcases;

import com.parabank.parasoft.Pages.LoginPage;
import com.parabank.parasoft.Pages.OpenNewAccountPage;
import com.parabank.parasoft.Util.General;
import org.testng.Assert;
import org.testng.annotations.Test;

public class openNewAccountTest extends BaseTest{

    
    @Test
public void OpenAccountshouldSuccessed(){
    OpenNewAccountPage openNewAccountPage =page.getInstance(LoginPage.class)
            .doLogin(getUsername(),getPassword())
            .clickOpenNewAccountLink()
            .selectAccountType(0)
            .selectAccountNumber(0)
            .clickNewAccountBtn();
    Assert.assertTrue(openNewAccountPage.hasAccountId());









}







}
