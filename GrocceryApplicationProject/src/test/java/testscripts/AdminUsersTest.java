package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import automationcore.Base;
import constants.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakeUtility;

public class AdminUsersTest extends Base {
	HomePage homepage;
	AdminUsersPage adminsuserspage;
	@Test
	public void verifyWhetherUserIsAbleToAddUserInAdminUsers() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage=login.clickOnSigninButton();
		
		adminsuserspage=homepage.clickOnAdminUsersMoreInfo();
		
		
		FakeUtility fake = new FakeUtility();
		
		String AdminUsername = fake.createRandomUsername();
		String AdminPassword = fake.createRandomPassword();
		
		adminsuserspage.clickOnNewButtonInAdminUsers().enterUsernameInAdminUsersInfo(AdminUsername).enterPasswordInAdminUsersInfo(AdminPassword).selectUserTypeInAdminUsersInfo().clickOnSaveButtonInAdminUserInfo();
		
		boolean adminusersdisplay = adminsuserspage.isAdminUserTextDisplayed();
		Assert.assertTrue(adminusersdisplay,Constants.CREATEADMINERROR );		
	}
	
	@Test
	public void verifyWhetherUserIsAbleToSearchAdminUsers() throws IOException {
		
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		String AdminSearchUsername = ExcelUtility.getStringData(1, 0, "AdminUsers");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage=login.clickOnSigninButton();
		
		adminsuserspage=homepage.clickOnAdminUsersMoreInfo();
		
		adminsuserspage.clickOnSearchButtonInAdminUsers().enterUserNameInSearchAdminUsers(AdminSearchUsername).selectUserTypeInSearchAdminUsers().clickOnSearchButtonAfterEnterValues();
		
		boolean adminusersdisplay = adminsuserspage.isAdminUserTextDisplayed();
		Assert.assertTrue(adminusersdisplay, Constants.SEARCHADMINERROR );
		
	}
	@Test
	public void verifyWhetherUserIsAbleToResetAdminUsers() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage=login.clickOnSigninButton();
		
		adminsuserspage=homepage.clickOnAdminUsersMoreInfo();
		
		
		adminsuserspage.clickOnResetButtonInAdminUsers();
		
		boolean adminusersdisplay = adminsuserspage.isAdminUserTextDisplayed();
		Assert.assertTrue(adminusersdisplay,Constants.RESETADMINERROR );
		
		
		
    }
}