package lumapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import luma.base.TestBase;

public class WomenPage extends TestBase{

	@FindBy(xpath="//h1//span[contains(text(),'Women')]")
	WebElement womenLabel;
	
	public WomenPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateWomenPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateWomenLabel() {
		return womenLabel.isDisplayed();
	}
	
	public void shopByCategory(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).click();
	}

	
}
