package lumapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import luma.base.TestBase;

public class SalePage extends TestBase{
	
	@FindBy(xpath="//h1//span[contains(text(),'Sale')]")
	WebElement saleLabel;
	
	
	public SalePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateSalePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateSaleLabel() {
		return saleLabel.isDisplayed();
	}
	
	public void shopByMensAndWomensDeals(String gender, String category, String name1, String name2) {
		driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/"+gender+"/"+category+"-"+gender+"/"+name1+"-"+gender+".html'][contains(text(),'"+name2+"')]"));
	}
	
	public void shopByGearDeals(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).click();
	}

}
