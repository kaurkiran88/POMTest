package lumapages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import luma.base.TestBase;

public class LoginPage extends TestBase{

	//Page factory - OR:
	@FindBy(name="login[username]")
	public WebElement email;
	
	@FindBy(name="login[password]")
	public WebElement password;
	
	@FindBy(xpath="//button[@class='action login primary']")
	public WebElement LogIn;
	
	@FindBy(xpath="//div[@class='panel header']//ul[@class='header links']//li[@class='greet welcome']//span[@class='logged-in'][contains(text(),'Welcome, ')]")
	public WebElement welcomeUser;
	
	//Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String mail, String pw) {
		email.sendKeys(mail);
		password.sendKeys(pw);
		LogIn.click();
		
		return new HomePage();
	}
	
	public boolean validateUserLoggedIn() {
		return welcomeUser.isDisplayed();
	}
}

