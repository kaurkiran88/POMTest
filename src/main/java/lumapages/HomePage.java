package lumapages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import luma.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//div[@class='panel header']//ul[@class='header links']//li[@class='greet welcome']//span[@class='logged-in'][contains(text(),'Welcome,')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Women')]")
	WebElement women;
	
	@FindBy(xpath="//span[contains(text(),'Men')]")
	WebElement men;
	
	@FindBy(xpath="//span[contains(text(),'Gear')]")
	WebElement gear;
	
	@FindBy(xpath="//span[contains(text(),'Sale')]")
	WebElement sale;
	
	@FindBy(xpath="//div[@class='footer content']/ul/li[4]")
	WebElement ordersAndReturns;
	
	@FindBy(xpath="//div[@class='panel header']//ul[@class='header links']//li[@class='customer-welcome']//span[@class='customer-name']//button[@type='button']")
	WebElement signOutDropDown;
	
	@FindBy(xpath="//li[@class='customer-welcome active']//div[@class='customer-menu']//ul[@class='header links']//li[@class='authorization-link']//a[contains(text(),'Sign Out')]")
	WebElement signOutButton;
	
	
	
	//Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateUserName() {
		return userNameLabel.isDisplayed();
	}

	public WomenPage clickWomen() {
		women.click();
		return new WomenPage();
	}
	
	public MenPage clickMen() {
		men.click();
		return new MenPage();
	}
	
	public GearPage clickGear() {
		gear.click();
		return new GearPage();
	}
	
	public SalePage clickSale() {
		sale.click();
		return new SalePage();
	}
	
	public SignOutPage clickSignOut() throws InterruptedException {
		Thread.sleep(4000);
		signOutDropDown.click();
		signOutButton.click();
		return new SignOutPage();
	}
		
}
