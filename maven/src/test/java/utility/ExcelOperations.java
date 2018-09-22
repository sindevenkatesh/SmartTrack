package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {
	public static FileInputStream file;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static String data;

	public int GetRowCount(String path, int sheetno) throws IOException {
		FileInputStream file = new FileInputStream(path);
		wb = new XSSFWorkbook(file);
		ws = wb.getSheetAt(sheetno);
		int rowcount = ws.getLastRowNum();
		return rowcount;
	}

	public Row getRowData(String path, String sheet, int r) throws IOException {
		file = new FileInputStream(path);
		wb = new XSSFWorkbook(file);
		ws = wb.getSheet(sheet);

		Row row = ws.getRow(r);
		return row;
	}

	public String getCellData(String path, int sheetno, int r, int c) throws IOException {
		FileInputStream file = new FileInputStream(path);
		wb = new XSSFWorkbook(file);
		ws = wb.getSheetAt(sheetno);
		String data = ws.getRow(r).getCell(c).getStringCellValue();
		return data;

	}

	public double getCellvalue(String path, int sheetno, int r, int c) throws IOException {
		FileInputStream file = new FileInputStream(path);
		wb = new XSSFWorkbook(file);
		ws = wb.getSheetAt(sheetno);
		double data = ws.getRow(r).getCell(c).getNumericCellValue();
		return data;
 
	}

	public String setCellData(String path, String shname, int r, int c, String value) throws IOException {
		FileInputStream file = new FileInputStream(path);
		wb = new XSSFWorkbook(file);
		ws = wb.getSheet(shname);		
		ws.getRow(r).getCell(c).setCellValue(value);
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		fos.close();
		return value;
	}

}
