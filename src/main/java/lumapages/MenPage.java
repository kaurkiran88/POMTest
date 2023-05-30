package lumapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import luma.base.TestBase;

public class MenPage extends TestBase{
	
	@FindBy(xpath="//h1//span[contains(text(),'Men')]")
	WebElement menLabel;
	
	public MenPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateMenPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateMenLabel() {
		return menLabel.isDisplayed();
	}
	
	public void shopByCategory(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).click();
	}
	

}
