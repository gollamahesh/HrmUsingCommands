package LIB;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class baseClass {
	// for accessing webdriver and webdriver wait globally we have to use like this
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;

	// initializing the property file

	public baseClass() {
		try {
			FileInputStream fis = new FileInputStream(
					"/Users/maheshbabugolla/Documents/workspace/HrmApplication/src/main/java/configuration/config.properties");
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// initializing a browser

	public void initilizeBrowser(String browser, String url) {
		if (browser == "chrome") {
			System.setProperty("webdriver.chrome.driver", "/Volumes/Files/Softwares/Selenium/chromedriver 5");
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.manage().deleteAllCookies();
			driver.get(url);

		} else if (browser == "firefox") {
			driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get(url);
		} else {
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get(url);
		}

	}

	// method for verify links
	public void verifyLinks() {

		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (int i = 0; i < links.size(); i++) {
			String link = links.get(i).getText();
			System.out.println(link);
		}

	}

	// method for verify links and getting url names
	public void verifyLinksUrl() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (int i = 0; i < links.size(); i++) {
			if (links.get(i).isDisplayed()) {
				String link = links.get(i).getText();
				links.get(i).getText();
				String url = driver.getCurrentUrl();
				System.out.println("link name is " + link + "url is   : " + url);
				driver.navigate().back();
				links = driver.findElements(By.tagName("a"));

			}

		}

	}

	// method for getting the dropdowns

	public void verifyDropdowns() {
		List<WebElement> dropdowns = driver.findElements(By.tagName("select"));
		for (int i = 0; i < dropdowns.size(); i++) {
			String drop = dropdowns.get(i).getText();
			System.out.println("Drop downs are" + drop);
		}

	}

	// method for verify single dropdown
	public void verifysingledrop(String locator) {
		WebElement drop = driver.findElement(By.xpath(locator));
		List<WebElement> values = drop.findElements(By.tagName("option"));
		for (int i = 0; i < values.size(); i++) {
			String dropvalues = values.get(i).getText();
			System.out.println(dropvalues);
		}
	}

	// method for verifying the images in page
	public void verifyImages() {
		List<WebElement> images = driver.findElements(By.tagName("img"));
		for (int i = 0; i < images.size(); i++) {
			String image = images.get(i).getAttribute("src");
			System.out.println("images in the page are :" + image);
		}
	}
	
	//method for verifying the radio buttons
	
	public void verifyRadioButtons()
	{
		List<WebElement> drops=driver.findElements(By.xpath("//input[@type='radio']"));
		for(int i=0;i<drops.size();i++)
		{
			String radionames=drops.get(i).getAttribute("name");
			System.out.println(radionames);
		}
		
	}
	
	//method for verifying the checkboxes
	
	public void verifyChechBox()
	{
		
		List<WebElement> checkbox=driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int i=0;i<checkbox.size();i++)
		{
			
			String cbnames=checkbox.get(i).getAttribute("name");
			System.out.println(cbnames);
			System.out.println(checkbox.get(i).getAttribute("checked"));
		}
	}
	
	//method for screenshots
	
//	public String getScreenshot(WebDriver driver,String path) throws IOException
//	{
//		try{TakesScreenshot sshot=(TakesScreenshot)driver;
//		File src=sshot.getScreenshotAs(OutputType.FILE);
//		path=path+"name"+".png";
//		File pathobj=new File(path);
//		FileUtils.copyFile(src,pathobj);
//		return path;}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
//		
//	}
	
	
	public static String excel(int index,int rowindex,int columnindex)
	{
		try {
			FileInputStream fis=new FileInputStream("/Users/maheshbabugolla/Documents/demo.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheetAt(index);
			Row r=sheet.getRow(rowindex);
			Cell c= r.getCell(columnindex);
			System.out.println(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	//method for autocomplete searchbox
	
	public static void autocompleteSearch(String xpath,String expected)
	{
		
		List<WebElement> list=driver.findElements(By.xpath(xpath));
		for(int i=0;i<list.size();i++)
		{
			String names=list.get(i).getText();
			if(list.get(i).getText().equals(expected))
			{
				list.get(i).click();
				break;
			}
		}
		
		
		
	}
	
	

}
