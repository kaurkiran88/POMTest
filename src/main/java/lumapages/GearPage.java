package lumapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import luma.base.TestBase;

public class GearPage extends TestBase{

	@FindBy(xpath="//h1//span[contains(text(),'Gear')]")
	WebElement gearLabel;
	
	public GearPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateGearPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateGearLabel() {
		return gearLabel.isDisplayed();
	}
	
	public void shopByCategory(String name) {
		driver.findElement(By.xpath("//ol[@class='items']//li[@class='item']//a[contains(text(),'"+name+"')]")).click();
	}
	
	
}
