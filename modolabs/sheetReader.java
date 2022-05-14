package ngrokUpdate;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class sheetReader {

	int rowCount, colCount;

	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	public String[] modules;
	public String[][] data;

	public sheetReader() throws IOException{
		fis = new FileInputStream(Constants.sheetPath);
		workbook = new XSSFWorkbook(fis);	
		rowCount=0;
		colCount=0;
		System.out.println("Sheet object initialized");
	}	

	public int rowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		return(sheet.getLastRowNum()+1);
	}

	public int colCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(0);
		return(row.getLastCellNum());
	}

	public void fetchData(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		rowCount = rowCount(sheetName);
		System.out.println("Total rows = " + (sheet.getLastRowNum()+1));
		colCount = colCount(sheetName);
		System.out.println("Total columns = " + row.getLastCellNum());

		data = new String[rowCount-1][colCount];
		modules = new String [rowCount-1];

		for (int r=1; r<rowCount;r++) {
			row = sheet.getRow(r);
			for(int c=0; c<colCount; c++) {
				cell = row.getCell(c);	
				if (c==0) {
					modules[r-1] = cell.getStringCellValue();
					continue;
				}
				data[r-1][c-1] = cell.getStringCellValue();
			}
		}
		System.out.println("Data fetched");
	}
	
	public void fetchData1(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		rowCount = rowCount(sheetName);
		System.out.println("Total rows = " + (sheet.getLastRowNum()+1));
		colCount = colCount(sheetName);
		System.out.println("Total columns = " + row.getLastCellNum());
		
		data = new String[rowCount-1][colCount];
		modules = new String [rowCount-1];
		
		for (int r=1; r<rowCount;r++) {
			row = sheet.getRow(r);
			for(int c=0; c<colCount; c++) {
				cell = row.getCell(c);	
				if (c==0) {
					//modules[r-1] = cell.getStringCellValue();
					continue;
				}
				data[r-1][c-1] = cell.getStringCellValue();
			}
		}
		System.out.println("Data fetched");
	}

	//	public void display() {
	//		for (int r=1; r<rowCount;r++) {
	//			row = sheet.getRow(r);
	//			for(int c=0;c<colCount;c++) {
	//				cell = row.getCell(c);	
	//				System.out.println(data[r][c]);
	//			}
	//		}
	//	}

	public void displayData() {
		for (int r=0; r<data.length;r++) {
			for(int c=0;c<2;c++) {
				System.out.println(data[r][c]);
			}
			System.out.println("----------------");
		}
	}
	
	public void display() {
		for (int r=0; r<modules.length;r++) {
			System.out.print(modules[r]);
			for(int c=0;c<=data.length;c++) {
				System.out.println(data[r][c]);
			}
			System.out.println("----------------");
		}
	}
}