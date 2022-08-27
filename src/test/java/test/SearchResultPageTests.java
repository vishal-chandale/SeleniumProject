package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultPage;

public class SearchResultPageTests extends BaseTest{
	
	@Test
	public void VerifyNoOfVillasOnPage() {	
		
		HomePage homePage= new HomePage(driver);	
		SearchResultPage searchPage= homePage.searchVilla();
		boolean isPresent= searchPage.verifySearchText();
		Assert.assertTrue(isPresent);
				
		int noOfVillas= searchPage.getNoOfVillasOnPage();
		System.out.println(noOfVillas);		
	}
	

}
