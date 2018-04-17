package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {
	
	//To get the data
	public static String getData(String pathname,String sheetname,int rn,int cn)
	{
		try 
		{
			FileInputStream fis=new FileInputStream(new File(pathname));
			Workbook wb = WorkbookFactory.create(fis);
			String data=wb.getSheet(sheetname).getRow(rn).getCell(cn).toString();
			return data;			
		} 
		catch (Exception e) 
		{
			return " ";	
		}		
	}
	
	//to get the row count
	public static int getRowCount(String sheetname,String pathname)
	{
		try 
		{
			FileInputStream fis=new FileInputStream(new File(pathname));
			Workbook wb = WorkbookFactory.create(fis);
			int rc=wb.getSheet(sheetname).getLastRowNum();
			return rc;			
		} 
		catch (Exception e) 
		{
			return 0;	
		}		
	}
	
	//to get the cell count
	public static int getCellCount(String sheetname,String pathname,int rn)
	{
		try 
		{
			FileInputStream fis=new FileInputStream(new File(pathname));
			Workbook wb = WorkbookFactory.create(fis);
			int cc=wb.getSheet(sheetname).getRow(rn).getLastCellNum();
			return cc;			
		} 
		catch (Exception e) 
		{
			return 0;	
		}
	}

}
