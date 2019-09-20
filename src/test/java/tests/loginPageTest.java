package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LIB.baseClass;
import pages.loginPage;

public class loginPageTest extends baseClass {

	loginPage page;

	public loginPageTest() {
		super();
	}

	@BeforeMethod
	public void start() {
		initilizeBrowser("chrome", "https://opensource-demo.orangehrmlive.com/");
		page = new loginPage();

	}

	@Test
	public void login() {

		// page.loginToHrm();
		// page.verifyLinks();
		//verifyLinksUrl();
		//sverifyImages();
		//excel();
	}

	@AfterMethod
	public void stop() {
		driver.close();

	}

}
