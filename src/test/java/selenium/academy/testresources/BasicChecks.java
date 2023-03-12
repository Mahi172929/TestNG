package selenium.academy.testresources;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import selenium.academy.pageobjects.LandingPage;
import selenium.academy.tests.BaseTest;

public class BasicChecks extends BaseTest {
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void init() throws IOException{
		driver=initializeBrowser();
		
	}
	@Test
	public void login() throws IOException {
		LandingPage lp=new LandingPage(driver);	
		lp.loginToApp("t.maheshbsc@test.com", "Qwe213as@");
	}
	
	@Test
	public void verifyUi(){
		LandingPage lp=new LandingPage(driver);	
		lp.verifyUIElements();
	}
	
	@Test
	public void verifyForgotPassword() {
		LandingPage lp=new LandingPage(driver);	
		lp.forgotPassword("best@test.com", "test1234");
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.close();
	}
}
