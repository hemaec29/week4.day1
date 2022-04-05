package week4.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LearnWindowsClass {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook("./test_Data/testdat1.xlsx");
		//to access the sheet
		XSSFSheet sheetAt = book.getSheetAt(0);
		//to get the number of active rows
		int rowNum = sheetAt.getLastRowNum();
		//get the number of active cols
		int colNum = sheetAt.getRow(0).getLastCellNum();
		//Iterate thru rows
		for (int i = 1; i < rowNum; i++) {
			XSSFRow eachrow = sheetAt.getRow(i);
			for (int j = 0; j <=colNum; j++) {
				XSSFCell eachcol = eachrow.getCell(j);
				String value = eachcol.getStringCellValue();
				System.out.println(value);
				book.close();
			}
				
				
			}
			
		}
	}

