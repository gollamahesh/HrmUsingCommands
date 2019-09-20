package tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LIB.baseClass;
import pages.homePage;
import pages.loginPage;

public class workingExcelFiles extends baseClass{
	loginPage lpage;
	homePage hpage;
	WebDriverWait wait;
	@BeforeMethod
	public void start()
	{
		initilizeBrowser("chrome", "https://opensource-demo.orangehrmlive.com/");
		wait=new WebDriverWait(driver,10);
		lpage=new loginPage();
		hpage=new homePage();
	}
	@Test
	public void exceldemo() throws Exception
	{
		lpage.loginToHrm();
		hpage.verifyuserExcel();
		
		
	}
	

}
