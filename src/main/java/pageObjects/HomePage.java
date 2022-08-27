package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	@FindBy(xpath="//div[@class='selectize-input items has-options not-full']")
	private WebElement destinationDrpDown;	
	
	@FindBy(id="input-departureDate")
	private WebElement calendarIcon;	
		
	@FindBy(xpath="//div[@data-date='30']")
	private WebElement dayOfMonth;
	
	@FindBy(id="input-duration") 
	private WebElement durationDrpDown;
	
	@FindBy(id="main_search_submit")
	private WebElement btnSearch;
	
	
	
	public SearchResultPage searchVilla() {
		
		calendarIcon.click();
		dayOfMonth.click();
		
		Select sel= new Select(durationDrpDown);
		sel.selectByIndex(2);
		btnSearch.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new SearchResultPage(driver);
	}
	
	

}
