package Testcase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Pageobject.Loginpage;
import Utilities.Readconfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	Readconfig readconfig = new Readconfig();

	public String url = readconfig.URL();
	public String username = readconfig.username();

	public String password = readconfig.password();
	public String Fname = readconfig.Fname();
	public String Lname = readconfig.Lname();
	public String zip = readconfig.Zipcode();
	public static WebDriver driver;

	@BeforeClass
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();
		Loginpage lp = new Loginpage(driver);

		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();
		Thread.sleep(3000);
		if (driver.getTitle().equals("Swag Labs")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
