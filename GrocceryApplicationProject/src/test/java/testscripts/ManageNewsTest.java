package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	@Test
	public void verifyWhetherUserIsAbleToAddNewNews() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		String enterthenewsvalue = ExcelUtility.getStringData(0, 0, "ManageNews");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnSigninButton();
		
		HomePage home = new HomePage(driver);
		home.clickOnManageNewsMoreInfo();
		
		ManageNewsPage manage = new ManageNewsPage(driver);
		manage.clickOnNewButton();
		
		manage.enterTheNewsOnNewsField(enterthenewsvalue);
		manage.clickOnSaveButton();
		
		boolean managenewsdisplay = manage.isManageNewsDisplayed();
		Assert.assertTrue(managenewsdisplay, Constants.ADDNEWSERROR);
		
	}
	@Test	
    public void verifyWhetherUserIsAbleToSearchTheAddedNews() throws IOException {
    	String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		String searchthetitlevalue = ExcelUtility.getStringData(1, 0, "ManageNews");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnSigninButton();
		
		HomePage home = new HomePage(driver);
		home.clickOnManageNewsMoreInfo();
		
		
		ManageNewsPage manage = new ManageNewsPage(driver);
		manage.clickOnSearchButton();
		manage.enterSearchTitleOnSearchField(searchthetitlevalue);
		manage.clickOnSearchButtonAfterEnterSearchValue();
		
		boolean managenewsdisplay = manage.isManageNewsDisplayed();
		Assert.assertTrue(managenewsdisplay, Constants.SEARCHNEWSERROR );
	
	}

	@Test	
    public void verifyWhetherUserIsAbleToResetTheNews() throws IOException {
    	String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnSigninButton();
		
		HomePage home = new HomePage(driver);
		home.clickOnManageNewsMoreInfo();
		
		ManageNewsPage manage = new ManageNewsPage(driver);
		manage.clickOnResetButton();
		
		boolean managenewsdisplay = manage.isManageNewsDisplayed();
		Assert.assertTrue(managenewsdisplay, Constants.RESETNEWSERROR );
		
	}
}
