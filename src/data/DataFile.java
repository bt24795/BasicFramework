package data;

import utilities.Xls_Reader;

public class DataFile {
	
	Xls_Reader d= new Xls_Reader("D:\\Selenium_Class\\testing\\ScotiaTest.xlsx");
	String sheetName = "Data1";
	
	public String wrongEmail= d.getCellData(sheetName, "wrongEmail", 2);
	public String wrongPassword= d.getCellData(sheetName, "wrongPassword", 2);
	public String emailWithSpecialChar = d.getCellData(sheetName, "emailWithSpecialChar", 2);
	public String globalErr=  d.getCellData(sheetName, "globalErr", 2);
	public String specialCharErr= d.getCellData(sheetName, "specialCharErr", 2);
	public String emptyEmailErr = d.getCellData(sheetName, "emptyEmailErr", 2);
	public String emptyPasswordErr = d.getCellData(sheetName, "emptyPasswordErr", 2);
}