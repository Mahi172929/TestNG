package selenium.academy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	private WebDriver driver;
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements( driver, this);
	}

	@FindBy(xpath="//input[@type='email']")
	WebElement email;
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath="//a[@class='btn1']")
	WebElement Registerbtn;
	@FindBy(xpath="//p[contains(text(),'Successfull Orders')]/../h1")
	WebElement SuccessfulOrders;
	@FindBy(xpath="//p[contains(text(),'Daily Orders')]/../h1")
	WebElement DailyOrders;
	@FindBy(xpath="//p[contains(text(),'Daily New Customer Joining')]/../h1")
	WebElement NewCustomers;
	
	
	
	public void loginToApp(String email1,String password1) {
		
		email.sendKeys(email1);
		password.sendKeys(password1);
		submit.click();
		
		
	}



	public void verifyUIElements() {
		// TODO Auto-generated method stub
		Registerbtn.isDisplayed();
		DailyOrders.isDisplayed();
		System.out.println("Daily Orders "+DailyOrders.getText());
		System.out.println("SuccessfulOrders "+SuccessfulOrders.getText());
		System.out.println("NewCustomers "+NewCustomers.getText());
		
		
	}
}
