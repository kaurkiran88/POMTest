package luma.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import luma.base.TestBase;
import lumapages.HomePage;
import lumapages.LoginPage;
import lumapages.MenPage;
import lumapages.SalePage;
import lumapages.GearPage;
import lumapages.WomenPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	WomenPage womenPage;
	MenPage menPage;
	GearPage trainingPage;
	SalePage salePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();	
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		womenPage = new WomenPage();
		menPage = new MenPage();
		trainingPage = new GearPage();
		salePage = new SalePage();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "Home Page", "Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.validateUserName());
	}
	
	@Test(priority=4)
	public void verifyWomenLinkTest() {
		womenPage = homePage.clickWomen();
	}
	
	@Test(priority=5)
	public void verifyMenLinkTest() {
		menPage = homePage.clickMen();
	}
	
	@Test(priority=7)
	public void verifyGearLinkTest() {
		trainingPage = homePage.clickGear();
	}
	
	@Test(priority=8)
	public void verifySaleLinkTest() {
		salePage = homePage.clickSale();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
