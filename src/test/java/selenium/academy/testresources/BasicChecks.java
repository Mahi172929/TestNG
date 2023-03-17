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
		List<Map<String, String>> dataList = new ArrayList<>();
		String ExcelFile="C:\\Users\\tmahe\\eclipse-workspace\\academy\\src\\main\\java\\selenium\\academy\\testdata//LoginData.xlsx";
		//ExcelUtility excel=new ExcelUtility();
		dataList=ExcelUtility.getExcelDataAsListofMaps(ExcelFile, "Login");
		//System.out.println("Size is "+dataList.size());
		Object[][] testData=new Object[dataList.size()][3];
		for(int i=0;i<dataList.size();i++) {
			testData[i][0]=dataList.get(i).get("Email");
			testData[i][1]=dataList.get(i).get("Password");
			testData[i][2]=dataList.get(i).get("Result");
		}
		//System.out.println("Data is "+testData);
		return testData;
		
	}
	
	@Test(dataProvider="getLoginDetails")
	public void login(String Email,String Password,String Result) throws IOException {
		System.out.println("Login testStarted");
		LandingPage lp=new LandingPage(driver);	
		lp.loginToApp(Email,Password);
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
		//ExcelUtility excel=new ExcelUtility();
		dataList=ExcelUtility.getExcelDataAsListofMaps(ExcelFile, "Login");
		System.out.println(dataList);
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.close();
	}
}
