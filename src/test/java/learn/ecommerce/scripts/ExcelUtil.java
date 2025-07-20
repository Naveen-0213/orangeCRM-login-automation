package learn.ecommerce.scripts;

import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static String[][] extractExcel(String filepath, String sheetName) throws IOException{
		
		XSSFWorkbook workbook=new XSSFWorkbook(filepath);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum();
		int lastCell=sheet.getRow(1).getLastCellNum();
		
		String[][] extactedData=new String[lastRowNum][lastCell];
		
		for(int i=1;i<=lastRowNum;i++) {
			for(int j=0;j<lastCell;j++) {
				
				String cellValue=sheet.getRow(i).getCell(j).getStringCellValue();
				extactedData[i-1][j]=cellValue;
			}
		}
		workbook.close();
		return extactedData;
		
	}

	public static void main(String[] args) {
		

	}

}
