package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {
public WebDriver driver;
PageUtility page = new PageUtility();
	
	public AdminUsersPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
    }
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newinadminusers;
	@FindBy(xpath="//input[@id='username']")WebElement usernameinadminusersinfo;
	@FindBy(xpath="//input[@id='password']")WebElement passwordinadminusersinfo;
	@FindBy(xpath ="//select[@id='user_type']")WebElement dropdown;
	@FindBy(xpath ="//button[@name='Create']")WebElement saveinadminuserinfo;
	@FindBy(xpath ="//a[contains(@href,'javascript:void(0)')and contains(@class,'btn-primary')]")WebElement searchinadminusers;
	@FindBy(xpath ="//input[@id='un']")WebElement usernameinsearchadminusers;
	@FindBy(xpath ="//select[@id='ut']")WebElement usertypeinsearchadminusers;
	@FindBy(xpath ="//button[@name='Search']")WebElement searchinsearchadminusers;
	@FindBy(xpath ="//a[contains(@href,'com/admin/list-admin')and contains(@class,'btn-warning')]")WebElement resetinadminusers;
	@FindBy(xpath="//h1[@class='m-0 text-dark' and text()='Admin Users']")WebElement adminUserText;
	
	 public void clickOnNewButtonInAdminUsers() {
	    	newinadminusers.click();
    }
	 public void enterUsernameInAdminUsersInfo(String AdminUsername) {
		 usernameinadminusersinfo.sendKeys(AdminUsername);	
	}
	 public void enterPasswordInAdminUsersInfo(String AdminPassword) {
		passwordinadminusersinfo.sendKeys(AdminPassword);
	}
	 public void selectUserTypeInAdminUsersInfo() {
		 page.selectDragDropWithText(dropdown,"staff");
		 //Select s1= new Select(dropdown);
		// s1.selectByValue("staff");	
	}
	public void clickOnSaveButtonInAdminUserInfo() {
		saveinadminuserinfo.click();
	}
	
	
	
	public void clickOnSearchButtonInAdminUsers() {
		searchinadminusers.click();	
	}
	public void enterUserNameInSearchAdminUsers(String AdminSearchUsername) {
		usernameinsearchadminusers.sendKeys(AdminSearchUsername);
	}
	public void selectUserTypeInSearchAdminUsers() {
		Select s2= new Select(usertypeinsearchadminusers);
		s2.selectByValue("staff");	
	}
	public void clickOnSearchButtonAfterEnterValues() {
		searchinsearchadminusers.click();	
	}
	
	public void clickOnResetButtonInAdminUsers() {
		resetinadminusers.click();	
	}
	
	public boolean isAdminUserTextDisplayed()
	{
		return adminUserText.isDisplayed();
	}
}
