package learn.ecommerce.scripts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;

import org.apache.logging.log4j.core.tools.picocli.CommandLine.Help.TextTable.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook outputFile=new XSSFWorkbook();
		XSSFSheet outputSheet=outputFile.createSheet("Copied Data");
		
		
		FileInputStream fis=new FileInputStream("/Users/naveenkumarp/Prep_Docs/Opencart_V122/testdata/Data.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int lastRow=sheet.getLastRowNum();
		int lastCell=sheet.getRow(1).getLastCellNum();
		String[][] extractedData=new String[lastRow][lastCell];
		for(int i=1;i<=lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				
				String data=sheet.getRow(i).getCell(j).getStringCellValue();
				extractedData[i-1][j]=data;
				
			}
		}
		
		for(int i=0;i<extractedData.length;i++) {
			Row row=outputSheet.createRow(i);
			for(int j=0;j<lastCell;j++) {
				org.apache.poi.ss.usermodel.Cell cell=row.createCell(j);
				cell.setCellValue(extractedData[i][j]);
				
				
			}
			
		}
		
		
		
		FileOutputStream fos=new FileOutputStream("/orangeCRM-login-automation/testdata/naveen.xlsx");
		outputFile.write(fos);
		workbook.close();
		fis.close();
		

	}

}
