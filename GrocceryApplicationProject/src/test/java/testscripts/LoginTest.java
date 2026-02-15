package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;


public class LoginTest extends Base {
	@Test(priority =1,description= "validating userlogin with valid credentials",groups="smoke")
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnSigninButton();
	}
	
    @Test(priority =2,description= "validating userlogin with valid username and invalid password")
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnSigninButton();
	}
	
    @Test(priority =3,description= "validating userlogin with invalid username and valid password")
    public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnSigninButton();
	}
    
    @Test(priority =4,description= "validating userlogin with invalid credentials",groups="smoke")
    public void verifyUserLoginWithInvalidCredentials() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(3, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnSigninButton();
	}
	

}
