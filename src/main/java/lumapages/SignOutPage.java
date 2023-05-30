package lumapages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import luma.base.TestBase;

public class SignOutPage extends TestBase{

	@FindBy(xpath="//h1//span[contains(text(),'You are signed out')]")
	WebElement signOutLabel;
	
	@FindBy(xpath = "//div[@class='panel header']//ul[@class='header links']//li[@class='authorization-link']//a[contains(text(),'Sign In')]")
	WebElement signInButton;
	
	//Initializing the Page Objects:
		public SignOutPage() {
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public boolean validateSignOutPageLabel() {
			return signOutLabel.isDisplayed();
		}
		
		public String validateSignOutPageTitle() throws InterruptedException {
			Thread.sleep(6000);
			return driver.getTitle();
		}
		
		public boolean validateSignInButton() throws InterruptedException {
			Thread.sleep(6000);
			return signInButton.isDisplayed();
		}


}
