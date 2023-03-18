package selenium.academy.pageobjects;

import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	private static  String Gender = null;
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
	@FindBy(xpath="//div[@class='overlay-container']//div[starts-with(@aria-label,\"Incorrect\")]")
	WebElement InvalidCreds;
	@FindBy(xpath="//div[@class='overlay-container']//div[starts-with(@aria-label,\"Login\")]")
	WebElement ValidCreds;
	
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
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement AgeConfirmationCheckbox;
	@FindBy(xpath="//div[@id='toast-container']")
	WebElement Toaster;
	@FindBy(xpath="//h1[contains(text(),'Created')]")
	WebElement AccountCreated;
	@FindBy(xpath="//h1[contains(text(),'Created')]/following-sibling::button")
	WebElement Loginbtn;
	@FindBy(xpath="//div[@class='overlay-container']//div[starts-with(@aria-label,\"User already\")]")
	WebElement Existingaccount;
	
	public void loginToApp(String email1,String password1,String Result) {
		
		email.sendKeys(email1);
		password.sendKeys(password1);
		submit.click();	
		if(Result.equalsIgnoreCase("Valid"))
			ValidCreds.isDisplayed();
		else
			InvalidCreds.isDisplayed();
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
	
	public void verifyRegistration(String fname2, String lname2, String email2, String phone, String occupation2, String gender2, String password2, String confirmPassword2, String results) {
		Register.click();
		Fname.sendKeys(fname2);
		Lname.sendKeys(lname2);
		if(results.equalsIgnoreCase("New")) {
			Instant instant = Instant.now();
			long timeStampMillis = instant.toEpochMilli();
			email2=Long.toString(timeStampMillis);
			email2=fname2+email2+"@gmail.com";
		}
		System.out.println(email2);
		UserEmail.sendKeys(email2);
		System.out.println(phone);
		UserMobile.sendKeys(phone);
		Occupation.sendKeys(occupation2);
		clickDynamicText(gender2);
		password.sendKeys(password2);
		ConfirmPassword.sendKeys(confirmPassword2);
		AgeConfirmationCheckbox.click();
		submit.click();
		if(results.equalsIgnoreCase("New")) {
			AccountCreated.isDisplayed();
			Loginbtn.isDisplayed();
			Loginbtn.click();
			loginToApp(email2, confirmPassword2, "Valid");
		}
		else
			Existingaccount.isDisplayed();
		
		
	}
	
	public void clickDynamicText(String Gender) {
		WebElement Genderbtn = driver.findElement(By.xpath("//label[contains(text(),'Gender')]/following-sibling::label//input[@value='"+Gender+"']"));
		Genderbtn.click(); 
	}
}
