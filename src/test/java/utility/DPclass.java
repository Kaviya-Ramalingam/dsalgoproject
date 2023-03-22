package utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DPclass {
	
	@DataProvider
	public static String[][]codedata() throws IOException {
		
		String path = "/Users/uvaraj/eclipse-workspace/dsAlgo/src/test/resources/LoginData.xlsx";
		ExcelReader excelreader =new ExcelReader(path);
		
		int totalrows = excelreader.getRowCount("Sheet2");
		int totalcolumns = excelreader.getCellCount("Sheet2",1 );
		
		String codedata[][]= new String[totalrows][totalcolumns];
		for(int i=1;i<=totalrows;i++) 
		{
			for(int j=0;j<totalcolumns;j++) {
				System.out.println("cell::"+excelreader.getCellData("Sheet2", i, j));
				
				codedata[i-1][0]=excelreader.getCellData("Sheet2", i, j);
			}
		}
		System.out.println("Log"+codedata);
		return codedata;
	}
	@DataProvider
	public static String[][]Logindata() throws IOException {
		//System.out.println("inside");
		String path = "/Users/uvaraj/eclipse-workspace/dsAlgo/src/test/resources/LoginData.xlsx";
		ExcelReader excelreader =new ExcelReader(path);
		
		int totalrows = excelreader.getRowCount("sheet1");
		//System.out.println("totalrows::"+totalrows);
		
		int totalcolumns = excelreader.getCellCount("sheet1",1 );
		//System.out.println("totalrows::"+totalcolumns);
		String Logindata[][]= new String[totalrows][totalcolumns];
		for(int i=1;i<=totalrows;i++) 
		{
			for(int j=0;j<totalcolumns;j++)
			{
				
				Logindata[i-1][j]=excelreader.getCellData("sheet1", i, j);
			}
		}
		//System.out.println("Log"+Logindata);
		return Logindata;
	}	

}
