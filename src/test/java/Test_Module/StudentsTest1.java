package Test_Module;

import org.testng.Assert;
import org.testng.annotations.Test;

import Helper_Module.StudentsHelper;
import LibraryFiles.UtilityClass;
import io.restassured.response.Response;

public class StudentsTest1 
{
	StudentsHelper StudentHelper=new StudentsHelper();
	String friendId="";

	@Test(dataProvider = "GetTD", dataProviderClass = UtilityClass.class, priority = 1)
    public void TC11_postStudent(String httpMethodName, String requestURL, int statusCode) 
    {
    	Response resp =  StudentHelper.postStudent(httpMethodName, requestURL);
    	Assert.assertEquals(resp.getStatusCode(), statusCode, "Status code failed");
    	
    	friendId=resp.jsonPath().getString("id");
    	System.out.println("id: "+friendId);
    }
	
    @Test(dataProvider = "GetTD", dataProviderClass = UtilityClass.class,priority = 2)
    public void TC12_getStudent(String httpMethodName, String requestURL, int statusCode) 
    {
    	Response resp =   StudentHelper.getStudent(httpMethodName, requestURL+friendId);
    	Assert.assertEquals(resp.getStatusCode(), statusCode, "Status code failed");
    }
        
    
    @Test(dataProvider = "GetTD", dataProviderClass = UtilityClass.class, priority = 3)
    public void TC13_updateStudent(String httpMethodName, String requestURL, int statusCode) 
    {
    	Response response =  StudentHelper.updateStudent(httpMethodName, requestURL+friendId);
    	Assert.assertEquals(response.getStatusCode(), statusCode, "Status code failed");
    }
    
    
    @Test(dataProvider = "GetTD", dataProviderClass = UtilityClass.class, priority = 4)
    public void TC14_deleteStudent(String methodName, String serviceEndpoint, int statusCode) 
    {
    	Response response =  StudentHelper.deleteStudent(methodName, serviceEndpoint+friendId);
    	Assert.assertEquals(response.getStatusCode(), statusCode, "Status code failed");
    }
    
	
}




