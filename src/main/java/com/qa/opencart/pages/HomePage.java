package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	
	private Page page;
	
      // 1.String Locators -OR
	  private String search="input[name='search']";
	  private String searchIcon="div#search button";
	  private String SearchPageHeader="div#content h1";
	  private String LoginClick ="//a[normalize-space()='Login']";
	  private String myAccountLink="//span[normalize-space()='My Account']"; 
	  
	  //2.page constructor:
	  public HomePage(Page page) {
		  this.page=page;
	  }
	  //3. page actions/methods:
	  public String getHomePageTitle() {
		  String title= page.title();
		  System.out.println("page title:"+ title);
		  return title;
		  
	  }
	  
	  public String getHomePageURL() {
		  String url= page.url();
		  System.out.println("page url :"+url);
		  return url;
	  }
	  
	  public String doSearch(String productName) {
		  page.fill(search, productName);
		  page.click(searchIcon);
		  String header=page.textContent(SearchPageHeader);
		  System.out.println("search header: "+header);
		  return header;
	  }
	  public LoginPage navigateToLoginPage(){
		  page.click(myAccountLink);
		  page.click(LoginClick);
		  return new LoginPage(page);
	  }
	  

}
