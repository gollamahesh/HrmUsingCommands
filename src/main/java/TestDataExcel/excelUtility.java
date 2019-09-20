package TestDataExcel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtility {

	// Excel WorkBook
	private static XSSFWorkbook excelWBook;

	// Excel Sheet
	private static XSSFSheet excelWSheet;

	// Excel cell
	private static XSSFCell cell;

	// Excel row
	private static XSSFRow row;

	// Row Number
	public static int rowNumber;

	// Column Number
	public static int columnNumber;

	public static XSSFWorkbook getExcelWBook() {
		return excelWBook;
	}

	public static void setExcelWBook(XSSFWorkbook excelWBook) {
		excelUtility.excelWBook = excelWBook;
	}

	public static XSSFSheet getExcelWSheet() {
		return excelWSheet;
	}

	public static void setExcelWSheet(XSSFSheet excelWSheet) {
		excelUtility.excelWSheet = excelWSheet;
	}

	public static XSSFCell getCell() {
		return cell;
	}

	public static void setCell(XSSFCell cell) {
		excelUtility.cell = cell;
	}

	public static XSSFRow getRow() {
		return row;
	}

	public static void setRow(XSSFRow row) {
		excelUtility.row = row;
	}

	public static int getRowNumber() {
		return rowNumber;
	}

	public static void setRowNumber(int rowNumber) {
		excelUtility.rowNumber = rowNumber;
	}

	public static int getColumnNumber() {
		return columnNumber;
	}

	public static void setColumnNumber(int columnNumber) {
		excelUtility.columnNumber = columnNumber;
	}

}
