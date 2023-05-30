package luma.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import luma.base.TestBase;
import lumapages.HomePage;
import lumapages.LoginPage;
import lumapages.SignOutPage;

public class SignOutPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	SignOutPage signOutPage;
	
	public SignOutPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		signOutPage = new SignOutPage();
		loginPage = new LoginPage();	
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		signOutPage = homePage.clickSignOut();;
	}
	
	@Test(priority=1)
	public void verifySignOutPageLabelTest() {
		Assert.assertTrue(signOutPage.validateSignOutPageLabel(), "You are signed out is missing on the page");
	}
	
	@Test(priority=2)
	public void verifyHomePageTitleTest() throws InterruptedException {
		String title = signOutPage.validateSignOutPageTitle();
		Assert.assertEquals(title, "Home Page", "Home page title not matched");
	}
	
	@Test(priority=3)
	public void validateSignInButton() throws InterruptedException {
		Assert.assertTrue(signOutPage.validateSignInButton());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
