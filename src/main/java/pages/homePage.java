package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import LIB.baseClass;

public class homePage extends baseClass {

	// creating actions for moveToElement and click

	Actions act = new Actions(driver);

	// creating page factory for webelements in homepage
	@FindBy(xpath = "//*[@id=\"menu_admin_viewAdminModule\"]")
	WebElement adminMenu;

	@FindBy(xpath = "//*[@id=\"menu_admin_UserManagement\"]")
	WebElement userManagementMenu;

	@FindBy(xpath = "//*[@id=\"menu_admin_viewSystemUsers\"]")
	WebElement usersMenu;

	@FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr/td[2]")
	List<WebElement> tableRows;

	@FindBy(xpath = "//*[@id=\"btnAdd\"]")
	WebElement addbtn;

	@FindBy(xpath = "//*[@id=\"systemUser_userType\"]")
	WebElement userRole;

	@FindBy(xpath = "//*[@id=\"systemUser_employeeName_empName\"]")
	WebElement empName;

	@FindBy(xpath = "//*[@id=\"systemUser_userName\"]")
	WebElement username;

	// initializig the page factory
	public homePage() {
		PageFactory.initElements(driver, this);

	}

	public void verifyUsers() {

		adminMenu.click();
		act.moveToElement(userManagementMenu).build().perform();
		usersMenu.click();
		act.moveToElement(driver.findElement(By.xpath("//table[@id=\"resultTable\"]/tbody/tr[1]")));

//		List<WebElement> user=driver.findElements(By.xpath("//table[@id=\"resultTable\"]/tbody/tr"));
//		System.out.println(user.size());

		for (int i = 1; i < tableRows.size(); i++) {
			String name = tableRows.get(i).getText();
			System.out.println(name);
			if (name.equals("fiona.grace")) {
				WebElement chk = driver.findElement(By.xpath("//*[@id=\"ohrmList_chkSelectRecord_6\"]"));
				if (chk.isSelected()) {
					System.out.println("not checked");
				} else {
					chk.click();
					System.out.println("checkbox checked");
				}
			}
		}

	}

	public void verifyuserExcel() throws Exception {

		adminMenu.click();
		act.moveToElement(userManagementMenu).build().perform();
		usersMenu.click();
		act.moveToElement(driver.findElement(By.xpath("//table[@id=\"resultTable\"]/tbody/tr[1]")));
		FileInputStream fis = new FileInputStream("/Users/maheshbabugolla/Documents/demo.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("sheet2");
		XSSFRow r;
		XSSFCell c;
//		List<WebElement> user=driver.findElements(By.xpath("//table[@id=\"resultTable\"]/tbody/tr"));
//		System.out.println(user.size());

		for (int i = 0; i < tableRows.size(); i++) {
			String name = tableRows.get(i).getText();
			r = sheet.createRow(i);
			r.createCell(0).setCellValue(tableRows.get(i).getText());

		}
		FileOutputStream fos=new FileOutputStream("/Users/maheshbabugolla/Documents/demo.xlsx");
wb.write(fos);
	}

}
