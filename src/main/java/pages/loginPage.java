package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import LIB.baseClass;

public class loginPage extends baseClass {
	
	homePage homepage;
	WebDriverWait wait=new WebDriverWait(driver, 10);

	// creating the page factory for webelements in the homepage
	@FindBy(name = "txtUsername")
	WebElement usernametxt;

	@FindBy(name = "txtPassword")
	WebElement passwordtxt;

	@FindBy(id = "btnLogin")
	WebElement submitbtn;

	// for initializing the page factory we have to use constuctor
	public loginPage() {
		PageFactory.initElements(driver, this);

	}
	//method for login
	public homePage loginToHrm()
	{
	
		usernametxt.click();
		usernametxt.clear();
		usernametxt.sendKeys(prop.getProperty("uname"));
		
		passwordtxt.click();
		passwordtxt.clear();
		passwordtxt.sendKeys(prop.getProperty("pword"));
		
		submitbtn.click();
		return new homePage();
		
	}
	
	public void loginExcel()
	{
		String uname=excel(0, 1, 0);
		String pword=excel(0, 1, 1);
		usernametxt.click();
		usernametxt.clear();
		usernametxt.sendKeys(uname);
		
		passwordtxt.click();
		passwordtxt.clear();
		passwordtxt.sendKeys(pword);
		
		submitbtn.click();

		
	}

	
	
}
