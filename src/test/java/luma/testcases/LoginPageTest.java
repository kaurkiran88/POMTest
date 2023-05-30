package luma.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import luma.base.TestBase;
import lumapages.HomePage;
import lumapages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Customer Login");
	}
	
	@Test(priority = 2)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test(priority = 3)
	public void successfullyLoggedInTest() {
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		Assert.assertTrue(loginPage.validateUserLoggedIn());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
