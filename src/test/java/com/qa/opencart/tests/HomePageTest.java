package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;

import pom.qa.opencart.java.BaseTest;

public class HomePageTest extends BaseTest{
	
	@Test
	public void homePageTitleTest() {
		String actualTitle=homepage.getHomePageTitle();
		Assert.assertEquals(actualTitle,AppConstants.HOMEPAGE_PAGE_TITLE);
	}
	
	@Test
	public void homePageURLTest() {
		String actualURL =homepage.getHomePageURL();
		Assert.assertEquals(actualURL, prop.getProperty("url"));
	}
	@DataProvider
	public Object [] [] getProductData(){
		return new Object[] [] {
			{"Macbook"},
			{"iMac"},
			{"samsung"} 
		};
	}
	@Test(dataProvider ="getProductData")
	public void searchTest(String productName) {
		String actualsearchHeader=homepage.doSearch(productName);
		Assert.assertEquals(actualsearchHeader, "Search - "+productName);
	

}}
