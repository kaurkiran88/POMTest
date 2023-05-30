package luma.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import luma.base.TestBase;
import lumapages.HomePage;
import lumapages.LoginPage;
import lumapages.WomenPage;

public class WomenPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	WomenPage womenPage;
	
	public WomenPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		womenPage = new WomenPage();
		loginPage = new LoginPage();	
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		womenPage = homePage.clickWomen();
	}
	
	@Test(priority=1)
	public void verifyWomenPageTitleTest() {
		String title = womenPage.validateWomenPageTitle();
		Assert.assertEquals(title, "Women", "Women page title not matched");
	}
	
	@Test(priority=2)
	public void verifyWomenLabelTest() {
		Assert.assertTrue(womenPage.validateWomenLabel(), "women label is missing on the page");
	}
	
	@Test(priority=3)
	public void shopTopsTest() {
		womenPage.shopByCategory("Tops");
	}
	
	@Test(priority=4)
	public void shopBottomsTest() {
		womenPage.shopByCategory("Bottoms");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
