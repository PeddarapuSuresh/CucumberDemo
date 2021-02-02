package utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	

	public static int get(int row, int column) throws Exception {
		File file = new File("E:\\eclipseprojects\\Cucumber_Interview\\Testdata\\testdata.xlsx");
		FileInputStream inputStream = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

		XSSFSheet sheet = workbook.getSheet("Sheet1");

		XSSFRow row2 = sheet.getRow(row);

		int cell = (int) row2.getCell(column).getNumericCellValue();
		
		System.out.println("Address is :" + String.valueOf(cell));
		return cell;
	}

	public static void main(String[] args) throws Exception {
		get(1, 1);
	}

}
