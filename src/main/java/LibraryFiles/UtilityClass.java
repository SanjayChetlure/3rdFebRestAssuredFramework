package LibraryFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;


public class UtilityClass
{	  
	   @DataProvider
	   public static Iterator<Object[]> GetTD(Method method) throws IOException
	   {
	       FileInputStream file = new FileInputStream("D:\\workspace\\3rdFebRestAssuredFramework\\src\\test\\resources\\TestData2.xlsx");
	       Workbook book = WorkbookFactory.create(file);
	       Sheet sh = book.getSheet("Sheet1");
	       
	       ArrayList<Object[]> al = new ArrayList<Object[]>();
	      
	       //Getting row data for test case
	       for (int i = 1; i <= sh.getLastRowNum(); i++)
	       {         
	           String ServiceEndpoint;
	   	        
	            String TCCellName = sh.getRow(i).getCell(1).getStringCellValue();;   //TC3
	         	          
	           //Checking test case name and returning that data
	           if (method.getName().equalsIgnoreCase(TCCellName))  // T3 ==Tc3
	           {	        	   
	        	   String ServiceBaseURL= sh.getRow(i).getCell(2).getStringCellValue();
		           String ServiceURI= sh.getRow(i).getCell(3).getStringCellValue();
		           String methodName = sh.getRow(i).getCell(4).getStringCellValue();
		           String statusCodeCell = sh.getRow(i).getCell(5).getStringCellValue();
		           //String respMsg = sh.getRow(i).getCell(6).getStringCellValue();
	        	   
	               //Set URL with URI
		           ServiceEndpoint = ServiceBaseURL + ServiceURI;
	               Object ob[] = {methodName, ServiceEndpoint,Integer.parseInt(statusCodeCell)};
	               al.add(ob);
	           }
	       }
	      
	      Iterator<Object[]> itr = al.iterator();
	       
	       book.close();
	       return itr;
	   }
}
