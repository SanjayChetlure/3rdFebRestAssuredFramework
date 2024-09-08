package Test_Module;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Given;

import Helper_Module.ResReqHelper;
import LibraryFiles.UtilityClass;
import io.restassured.response.Response;

public class ReqResTest 
{
	ResReqHelper reqHelper=new ResReqHelper();

    @Test(dataProvider = "GetTD", dataProviderClass = UtilityClass.class,priority = 1)
    public void TC1_getUser(String httpMethodName, String requestURL, int statusCode) 
    {
    	Response resp = reqHelper.getUser(httpMethodName, requestURL);
    	Assert.assertEquals(statusCode, resp.statusCode(),"Failed: TC1 status code mismatch");
    }
    
    
    @Test(dataProvider = "GetTD", dataProviderClass = UtilityClass.class,priority = 1)
    public void TC2_postUser(String httpMethodName, String requestURL, int statusCode) 
    {
    	Response resp = reqHelper.postUser(httpMethodName, requestURL);
    	Assert.assertEquals(statusCode, resp.statusCode(),"Failed: TC1 status code mismatch");
    }
    
   
    
    @Test(dataProvider = "GetTD", dataProviderClass = UtilityClass.class, priority = 3)
    public void TC3_updateUser(String methodName, String serviceEndpoint, int statusCode) 
    {
    	Response resp =  reqHelper.updateUser(methodName, serviceEndpoint);
    	Assert.assertEquals(resp.getStatusCode(), statusCode, "Status code failed");
    }
    
    
    @Test(dataProvider = "GetTD", dataProviderClass = UtilityClass.class, priority = 2)
    public void TC4_deleteUser(String methodName, String serviceEndpoint, int statusCode) 
    {
    	Response response =  reqHelper.deleteUser(methodName, serviceEndpoint);
    	Assert.assertEquals(response.getStatusCode(), statusCode, "Status code failed");
    }
    
	
}




