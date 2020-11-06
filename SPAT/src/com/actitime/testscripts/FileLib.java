package com.actitime.testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	 /**
	  * 
	  * @param key
	  * @return
	  * @throws IOException
	  */
	 public  String getPropertyValue(String key) throws IOException {
	  FileInputStream fis=new FileInputStream("./data/commondata.property");
	  Properties p=new Properties();
	  p.load(fis);
	  String value = p.getProperty(key);
	  return value;
	  }
	 /**
	  * 
	  * @param sheetname
	  * @param rownum
	  * @param cellnum
	  * @return
	  * @throws IOException
	  */
	 public String getExcelValue(String sheetname,int rownum,int cellnum) throws IOException{
	  FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
	  Workbook wb = WorkbookFactory.create(fis);
	  String value = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();
	  return value;
	  }
	 public void setExcelValue(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
	 FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
	  Workbook wb = WorkbookFactory.create(fis);
	  String value= wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();
	  FileOutputStream fos=new FileOutputStream("./data/testscript.xlsx");
	  wb.write(fos);
	  wb.close();
	 
	  }
	}


