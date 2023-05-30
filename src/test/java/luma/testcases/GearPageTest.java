package luma.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import luma.base.TestBase;
import lumapages.HomePage;
import lumapages.LoginPage;
import lumapages.GearPage;

public class GearPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	GearPage gearPage;
	
	public GearPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		gearPage = new GearPage();
		loginPage = new LoginPage();	
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		gearPage = homePage.clickGear();
	}
	
	@Test(priority=1)
	public void verifyGearPageTitleTest() {
		String title = gearPage.validateGearPageTitle();
		Assert.assertEquals(title, "Gear", "Gear page title not matched");
	}
	
	@Test(priority=2)
	public void verifyGearLabelTest() {
		Assert.assertTrue(gearPage.validateGearLabel(), "Gear label is missing on the page");
	}
	
	@Test(priority=3)
	public void shopBags() {
		gearPage.shopByCategory("Bags");
	}
	
	@Test(priority=4)
	public void shopFitnessEquipmentTest() {
		gearPage.shopByCategory("Fitness Equipment");
	}
	
	@Test(priority=5)
	public void shopWatches() {
		gearPage.shopByCategory("Watches");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
