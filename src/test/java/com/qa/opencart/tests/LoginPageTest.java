package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.constants.AppConstants;

import pom.qa.opencart.java.BaseTest;

public class LoginPageTest extends  BaseTest {

@Test (priority=1)
public void loginPageNavigateTest(){
	
loginpage=homepage.navigateToLoginPage();                        //Chaining process
String actLoginPageTitle=loginpage.getLoginPageTitle();
System.out.println("page act title:"+actLoginPageTitle);
Assert.assertEquals(actLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
}

@Test(priority=2)
public void forgotpwdLinkExistTest() {
	
	Assert.assertTrue(loginpage.isForgetPwdLinkExist());
}
@Test(priority=3)
public void appLoginTest() {
	Assert.assertTrue(loginpage.doLogin(prop.getProperty("username").trim(),
			prop.getProperty("password").trim()));
}
}

