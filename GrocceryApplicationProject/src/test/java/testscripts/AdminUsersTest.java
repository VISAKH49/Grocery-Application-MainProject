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
	@Test
	public void verifyWhetherUserIsAbleToAddUserInAdminUsers() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnSigninButton();
		
		HomePage home = new HomePage(driver);
		home.clickOnAdminUsersMoreInfo();
		
		AdminUsersPage admin = new AdminUsersPage(driver);
		admin.clickOnNewButtonInAdminUsers();
		
		FakeUtility fake = new FakeUtility();
		
		String AdminUsername = fake.createRandomUsername();
		String AdminPassword = fake.createRandomPassword();
		
		admin.enterUsernameInAdminUsersInfo(AdminUsername);
		admin.enterPasswordInAdminUsersInfo(AdminPassword);
		admin.selectUserTypeInAdminUsersInfo();
		admin.clickOnSaveButtonInAdminUserInfo();
		
		boolean adminusersdisplay = admin.isAdminUserTextDisplayed();
		Assert.assertTrue(adminusersdisplay,Constants.CREATEADMINERROR );		
	}
	
	@Test
	public void verifyWhetherUserIsAbleToSearchAdminUsers() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		String AdminSearchUsername = ExcelUtility.getStringData(1, 0, "AdminUsers");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnSigninButton();
		
		HomePage home = new  HomePage(driver);
		home.clickOnAdminUsersMoreInfo();
		
		AdminUsersPage admin = new AdminUsersPage(driver);
		admin.clickOnSearchButtonInAdminUsers();
		admin.enterUserNameInSearchAdminUsers(AdminSearchUsername);
		admin.selectUserTypeInSearchAdminUsers();
		admin.clickOnSearchButtonAfterEnterValues();
		
		boolean adminusersdisplay = admin.isAdminUserTextDisplayed();
		Assert.assertTrue(adminusersdisplay, Constants.SEARCHADMINERROR );
		
	}
	@Test
	public void verifyWhetherUserIsAbleToResetAdminUsers() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnSigninButton();
		
		HomePage home = new  HomePage(driver);
		home.clickOnAdminUsersMoreInfo();
		
		AdminUsersPage admin = new AdminUsersPage(driver);
		admin.clickOnResetButtonInAdminUsers();
		
		boolean adminusersdisplay = admin.isAdminUserTextDisplayed();
		Assert.assertTrue(adminusersdisplay,Constants.RESETADMINERROR );
		
		
		
    }
}
