package selenium.academy.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static List<LinkedHashMap<String, String>> getExcelDataAsMap(String excelFileName, String sheetName) throws IOException {
		// Create a Workbook
		
		List<LinkedHashMap<String, String>> dataList = new ArrayList<>();
		FileInputStream fis=new FileInputStream("C:\\Users\\tmahe\\eclipse-workspace\\academy\\src\\main\\java\\selenium\\academy\\testdata//LoginData.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet(sheetName);
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();

		for (int r = 0; r <= sh.getLastRowNum(); r++) {
			int key = (int)sh.getRow(r)
                      .getCell(0)
                      .getNumericCellValue();
			String value = sh.getRow(r)
                           .getCell(1)
                           .getStringCellValue();
			map.put(key, value);
    }
		
		return dataList;
	}
}
