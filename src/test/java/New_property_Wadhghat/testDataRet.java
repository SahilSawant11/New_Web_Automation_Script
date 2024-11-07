package New_property_Wadhghat;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class testDataRet {
	static public String url;
	static public String userid;
	static public String password;
	static public String node;
	static public String sector;
	
	
	
	@SuppressWarnings("resource")
	public static void GetData() throws IOException
	{
		XSSFWorkbook workbook;
		XSSFSheet s;
		XSSFCell c;
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\InputData\\CMS Data.xlsx");
		workbook = new XSSFWorkbook(file);
		s = workbook.getSheet("Sheet1");
		
		c = s.getRow(1).getCell(0);
		c.setCellType(CellType.STRING);
		userid = c.getStringCellValue();
		
		c = s.getRow(1).getCell(1);
		c.setCellType(CellType.STRING);
		password = c.getStringCellValue();
		
		c = s.getRow(1).getCell(2);
		c.setCellType(CellType.STRING);
		url = c.getStringCellValue();
		
		c = s.getRow(1).getCell(3);
		c.setCellType(CellType.STRING);
		node = c.getStringCellValue();
		
		c = s.getRow(1).getCell(4);
		c.setCellType(CellType.STRING);
		sector = c.getStringCellValue();
	}
}
