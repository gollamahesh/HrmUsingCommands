package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import LIB.baseClass;
import pages.homePage;
import pages.loginPage;
@Listeners(listeners.testnglisteners.class)
public class homePageTest extends baseClass {
	homePage hpage;
	loginPage lpage;

	// creating constructor for loading the parameters

	public homePageTest() {
		super();
	}

	@BeforeMethod
	public void start() {
		initilizeBrowser("chrome", "https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		hpage = new homePage();
		lpage = new loginPage();
	}

	@Test
	public void verifyuser() {
		lpage.loginToHrm();
		hpage.verifyUsers();
		//verifysingledrop("//*[@id=\"searchSystemUser_userType\"]");
		verifyChechBox();
	}

	@AfterMethod
	public void stop() {
		driver.close();
	}

}
