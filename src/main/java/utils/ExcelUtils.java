package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils
{
	
	public Workbook getWorkbook(File fileName) throws FileNotFoundException, IOException
	{
		Workbook wb = null;
		if (fileName.toString().endsWith(".xls"))
		{
			wb = new HSSFWorkbook(new FileInputStream(fileName));
		} else if (fileName.toString().endsWith(".xlsx"))
		{
			wb = new XSSFWorkbook(new FileInputStream(fileName));
		}
		return wb;
	}
	
	public String[][] readDataFrom(File fileName, String sheetName) throws FileNotFoundException, IOException
	{
		String data[][];
		Workbook wb=getWorkbook(fileName);
		Sheet sheet = wb.getSheet(sheetName);

		data= getDataFromSheet(sheet);
		return data;

	}
	
	public String[][] readDataFrom(File fileName, int sheetNum) throws FileNotFoundException, IOException
	{
		String data[][];
		Workbook wb=getWorkbook(fileName);
		Sheet sheet = wb.getSheetAt(sheetNum);

		return getDataFromSheet(sheet);

	}
	
	
	public String[][] getDataFromSheet(Sheet sheet)
	{
		String data[][];
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		data = new String[rowCount][columnCount];

		for (int row = 0; row < rowCount; row++)
		{
			for (int column = 0; column < columnCount; column++)
			{
				Row currentRow = sheet.getRow(row);
				Cell currentColumn = currentRow.getCell(column);
				CellType cellType = currentColumn.getCellType();

				switch (cellType)
				{
				case NUMERIC:
					System.out.print(currentColumn.getNumericCellValue());
					data[row][column] = String.valueOf(currentColumn.getNumericCellValue());
					break;
				case STRING:
					System.out.print(currentColumn.getStringCellValue());
					data[row][column] = currentColumn.getStringCellValue();
					break;
				case FORMULA:
					System.out.print(currentColumn.getCellFormula());
				case BLANK:
					System.out.print("");
					data[row][column] = "";
					break;
				case BOOLEAN:
					System.out.print(currentColumn.getBooleanCellValue());
					data[row][column] = Boolean.toString(currentColumn.getBooleanCellValue());
					break;
				case ERROR:
					System.out.print(currentColumn.getErrorCellValue());
					break;
				default:
					break;
				}
			}
		}
		return data;
	}
}
