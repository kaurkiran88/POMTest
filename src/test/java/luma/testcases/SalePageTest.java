package luma.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import luma.base.TestBase;
import lumapages.HomePage;
import lumapages.LoginPage;
import lumapages.SalePage;

public class SalePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	SalePage salePage;
	
	public SalePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		salePage = new SalePage();
		loginPage = new LoginPage();	
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		salePage = homePage.clickSale();
	}
	
	@Test(priority=1)
	public void verifySalePageTitleTest() {
		String title = salePage.validateSalePageTitle();
		Assert.assertEquals(title, "Sale", "Sale page title not matched");
	}
	
	@Test(priority=2)
	public void verifySaleLabelTest() {
		Assert.assertTrue(salePage.validateSaleLabel(), "Sale label is missing on the page");
	}
	
	@Test(priority=3)
	public void shopWomensShortsTest() {
		salePage.shopByMensAndWomensDeals("women","bottoms","shorts","Shorts");
	}
	
	@Test(priority=4)
	public void shopMensJacketsTest() {
		salePage.shopByMensAndWomensDeals("men","tops","jackets","Jackets");
	}
	
	@Test(priority=5)
	public void shopBagsTest() {
		salePage.shopByGearDeals("Bags");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
