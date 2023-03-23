package selenium.academy.testresources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

	 WebDriver driver;
	
	//Read Properties
	public WebDriver initializeBrowser() throws IOException {
		Properties properties=new Properties();
		
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\selenium\\academy\\resources\\GlobalProperties.properties");
		properties.load(fis);
		
		String browsername=properties.getProperty("browser");
		System.out.println(browsername);
		String projectPath=System.getProperty("user.dir");
		//System.out.println("B4Initialized");
		if(browsername.equalsIgnoreCase("chrome")) {
			System.out.println("Initialized");
			System.setProperty("webdriver.chrome.driver", projectPath+"\\src\\main\\java\\selenium\\academy\\resources\\chromedriver.exe");
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			driver = new ChromeDriver();
			
		}
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}
	
	
	
}
