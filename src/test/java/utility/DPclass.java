package utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DPclass {
	
	@DataProvider
	public static String[][]codedata() throws IOException {
		
		String path = "/Users/uvaraj/eclipse-workspace/dsAlgo/src/test/resources/LoginData.xlsx";
		ExcelReader excelreader =new ExcelReader(path);
		
		int totalrows = excelreader.getRowCount( "sheet2");
		int totalcolumns = excelreader.getCellCount("sheet2",1 );
		
		String codedata[][]= new String[totalrows][totalcolumns];
		for(int i=1;i<=totalrows;i++) 
		{
			for(int j=0;j<totalcolumns;j++) {
				System.out.println("cell::"+excelreader.getCellData("sheet2", i, j));
				
				codedata[i-1][0]=excelreader.getCellData("sheet2", i, j);
			}
		}
		
		return codedata;
	}
	
	@DataProvider
	public static String[][]Logindata() throws IOException {
		
		String path = "/Users/uvaraj/eclipse-workspace/dsAlgo/src/test/resources/LoginData.xlsx";
		ExcelReader excelreader =new ExcelReader(path);
		
		int totalrows = excelreader.getRowCount("sheet1");
		int totalcolumns = excelreader.getCellCount("sheet1",1 );
	
		String Logindata[][]= new String[totalrows][totalcolumns];
		for(int i=1;i<=totalrows;i++) 
		{
			for(int j=0;j<totalcolumns;j++)
			{
				
				Logindata[i-1][j]=excelreader.getCellData("sheet1", i, j);
			}
		}
		
		return Logindata;
	}	
	
	@DataProvider
	public static String[][]code() throws IOException {
		
		String path = "/Users/uvaraj/eclipse-workspace/dsAlgo/src/test/resources/LoginData.xlsx";
		ExcelReader excelreader =new ExcelReader(path);
		
		int totalrows = excelreader.getRowCount("sheet3");
		int totalcolumns = excelreader.getCellCount("sheet3",1 );
	
		String code[][]= new String[totalrows][totalcolumns];
		for(int i=1;i<=totalrows;i++) 
		{
			for(int j=0;j<totalcolumns;j++)
			{
				
				code[i-1][j]=excelreader.getCellData("sheet3", i, j);
			}
		}
		
		return code;
	}	

}
