package selenium.academy.testresources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import selenium.academy.pageobjects.LandingPage;
import selenium.academy.tests.BaseTest;
import selenium.academy.tests.ExcelUtility;

public class BasicChecks extends BaseTest {
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void init() throws IOException{
		driver=initializeBrowser();
		
	}
	@DataProvider(name="getLoginDetails")
	public Object[][] loginDetails(){
		return new Object[][] {{"t.maheshbsc@gmail.com","Qwe213as@"}, {"test@test.com","Qwe213as@"}};
		
	}
	
	@Test(dataProvider="getLoginDetails")
	public void login(String UserName,String Password) throws IOException {
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
	@Test
	public void getExcelDataTest() {
		List<Map<String, String>> dataList = new ArrayList<>();
		String ExcelFile="C:\\Users\\tmahe\\eclipse-workspace\\academy\\src\\main\\java\\selenium\\academy\\testdata//LoginData.xlsx";
		ExcelUtility excel=new ExcelUtility();
		dataList=excel.getExcelDataAsListofMaps(ExcelFile, "Login");
		System.out.println(dataList);
		
		
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.close();
	}
}
