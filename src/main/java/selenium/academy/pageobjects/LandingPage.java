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
	
	
	@FindBy(linkText="Forgot password?")
	WebElement ForgotPassword;
	@FindBy(tagName="h3")
	WebElement popup;
	@FindBy(xpath="//input[@type='email']")
	WebElement ForgotEmail;
	@FindBy(id="userPassword")
	WebElement NewPassword;
	@FindBy(id="confirmPassword")
	WebElement ConfirmPassword;
	@FindBy(xpath="//button[@type='submit']")
	WebElement SavePassword;
	@FindBy(xpath="//div[@class='login-section-wrapper']")
	WebElement LoginSection;
	
	//Register
	@FindBy(linkText="Register")
	WebElement Register;
	@FindBy(id="firstName")
	WebElement Fname;
	@FindBy(id="lastName")
	WebElement Lname;
	@FindBy(id="userEmail")
	WebElement UserEmail;
	@FindBy(id="userMobile")
	WebElement UserMobile;
	@FindBy(xpath="//label[contains(text(),'Occupation')]/following-sibling::select")
	WebElement Occupation;
	@FindBy(xpath="//label[contains(text(),'Gender')]/following-sibling::label//input[@value='+Gender+']")
	WebElement Gender;
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement AgeConfirmationCheckbox;
	@FindBy(xpath="//div[@id='toast-container']")
	WebElement Toaster;
	@FindBy(xpath="//h1[contains(text(),'Created')]")
	WebElement AccountCreated;
	@FindBy(xpath="//h1[contains(text(),'Created')]/following-sibling::button")
	WebElement Loginbtn;
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
	
	public void forgotPassword(String existingemail,String newpassword) {
		ForgotPassword.click();
		popup.isDisplayed();
		ForgotEmail.sendKeys(existingemail);
		NewPassword.sendKeys(newpassword);
		ConfirmPassword.sendKeys(newpassword);
		SavePassword.click();
		LoginSection.isDisplayed();
	}
}
