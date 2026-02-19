package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add'and contains (@class,'btn btn-rounded btn-danger')]")WebElement newinnews;
    @FindBy(xpath="//textarea[@id='news']")WebElement enterthenews;
    @FindBy(xpath="//button[@type='submit']")WebElement save;
    @FindBy(xpath="//a[@href='javascript:void(0)']")WebElement search;
    @FindBy(xpath="//input[@type='text']")WebElement searchtitle;
    @FindBy(xpath="//button[@type='submit']")WebElement clicksearchbutton;
    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")WebElement reset;
    @FindBy(xpath="//h1[@class='m-0 text-dark' and text()='Manage News']")WebElement managenewstext;
    
    public void clickOnNewButton() {
    	newinnews.click();
	}  
    public void enterTheNewsOnNewsField(String enterthenewsvalue) {
    	enterthenews.sendKeys(enterthenewsvalue);
	}
    public void clickOnSaveButton() {
    	save.click();
	}
    
    
   public void clickOnSearchButton() {
	   search.click();
    }
   public void enterSearchTitleOnSearchField (String searchthetitlevalue) {
	   searchtitle.sendKeys(searchthetitlevalue);
    }
   public void clickOnSearchButtonAfterEnterSearchValue() {
	   clicksearchbutton.click();
    }   
	
   
   public void clickOnResetButton() {
	  reset.click();
   }
   
   
   public boolean isManageNewsDisplayed()
	{
		return managenewstext.isDisplayed();
	}
}
    
    
