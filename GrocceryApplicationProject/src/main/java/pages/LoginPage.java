package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	@FindBy(xpath="//input[@name='username']")WebElement username;
	@FindBy(xpath="//input[@name='password']")WebElement password;
	@FindBy(xpath="//button[@type='submit']")WebElement signinbutton;
	@FindBy(xpath ="//p[text()='Dashboard']")WebElement dashboardtile;
	@FindBy(xpath ="//b[text()='7rmart supermarket']")WebElement logintext;
	
	
	
	public void enterUsernameOnUsernameField(String usernamevalue) {
		username.sendKeys(usernamevalue);
		
	}
	
	public void enterPasswordOnPasswordField(String passwordvalue) {
		password.sendKeys(passwordvalue);
		
	}
	 
	 public void clickOnSigninButton() {
		 signinbutton.click();
		
	 }
	 
	 public boolean isDashboardDisplayed() {
		return dashboardtile.isDisplayed();
			 
	 }
	 
	 public String dashboardText() {
		 return logintext.getText();
	 }

}
