package selenium.academy.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static List<Map<String, String>> getExcelDataAsListofMaps(String excelFileName, String sheetName) {
		// Create a Workbook
		
		List<Map<String, String>> dataList = new ArrayList<>();
		List<String> headers=new ArrayList<>();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelFileName);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh=wb.getSheet(sheetName);
			XSSFRow firstRow=sh.getRow(0);
			int length=firstRow.getLastCellNum();
			for(int i=0;i<length;i++) {
				XSSFCell cell=firstRow.getCell(i);
				headers.add(cell.toString());
			}
			System.out.println("headers" +headers);
			int lastRowNum=sh.getLastRowNum();
			for(int j=1;j<=lastRowNum;j++) {
				Map<String,String> rowData=new HashMap<>();
				XSSFRow row=sh.getRow(j);
				String cellValue="";
				for(int k=0;k<length;k++) {
					XSSFCell c=row.getCell(k);
					if(c==null || c.getCellType()==CellType.BLANK) {
						cellValue="";
					}else {
						cellValue=row.getCell(k).toString();
					}
					rowData.put(headers.get(k), cellValue);
							
				}
				dataList.add(rowData);
			}
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("IN progress");
		return dataList;
		
		
	}
}
