package luma.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import luma.base.TestBase;
import lumapages.HomePage;
import lumapages.LoginPage;
import lumapages.MenPage;

public class MenPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	MenPage menPage;
	
	public MenPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		menPage = new MenPage();
		loginPage = new LoginPage();	
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		menPage = homePage.clickMen();
	}
	
	@Test(priority=1)
	public void verifyMenPageTitleTest() {
		String title = menPage.validateMenPageTitle();
		Assert.assertEquals(title, "Men", "Men page title not matched");
	}
	
	@Test(priority=2)
	public void verifyMenLabelTest() {
		Assert.assertTrue(menPage.validateMenLabel(), "women label is missing on the page");
	}
	
	@Test(priority=3)
	public void shopHoodiesAndSweatshirtsTest() {
		menPage.shopByCategory("Hoodies & Sweatshirts");
	}
	
	@Test(priority=4)
	public void shopJacketsTest() {
		menPage.shopByCategory("Jackets");
	}
	
	@Test(priority=5)
	public void shopPantsTest() {
		menPage.shopByCategory("Pants");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
