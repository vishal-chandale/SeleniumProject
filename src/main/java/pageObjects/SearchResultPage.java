package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BasePage{
	
		
	@FindBy(xpath="//a[text()='View Villa']") 
	public List<WebElement> btnViewVilla;
	
	@FindBy(xpath="//div/div[1]/h4[@class='vcount']")
	public WebElement lblSearchText;
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public int getNoOfVillasOnPage() {
		
		return btnViewVilla.size();
	}
	
	public boolean verifySearchText() {
		
		return lblSearchText.isDisplayed();	
	}
	
	
	
	
	
}
