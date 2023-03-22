package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public FileInputStream fi;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;   
	String path;
	
	 public ExcelReader(String path)
	{
		this.path=path;
	}
		
	public int getRowCount(String sheetName) throws IOException 
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;		
	}
	

	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
	}
	
	
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try{
		data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
		}
		catch(Exception e)
		{
			data="";
		}
		workbook.close();
		fi.close();
		return data;
	}
	/*public String getCode(String sheetName,int rownum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(0);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try{
		data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
		}
		catch(Exception e)
		{
			data="";
		}
		workbook.close();
		fi.close();
		return data;
	
	}*/
	public static String[][] getData() throws IOException
	{
		//String projectDir=System.getProperty("user.dir");
		String path="/Users/uvaraj/eclipse-workspace/dsAlgo/src/test/resources/LoginData.xlsx";
		File ExcelFile= new File(path);
		FileInputStream FIS= new FileInputStream(ExcelFile);
		XSSFWorkbook workbook= new XSSFWorkbook(FIS);
		XSSFSheet sheet=workbook.getSheet("Sheet2");
		int row= sheet.getLastRowNum();
		System.out.println("rows"+row);
		Row rowcell=sheet.getRow(0);
		int totcol=rowcell.getLastCellNum();
		System.out.println("column"+totcol);
		DataFormatter format= new DataFormatter();
		String testdata[][]= new String[row][totcol];
		for(int i=1;i<=row;i++)
		{
			for(int j=0;j<totcol;j++)
			{
				testdata[i-1][j]=format.formatCellValue(sheet.getRow(i).getCell(j));
				//System.out.println(testdata[i-1][j]);
			}
		}
		
		return testdata;
	
	
	}

	

	
}
	
