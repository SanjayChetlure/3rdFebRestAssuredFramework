package Helper_Module;

import LibraryFiles.RestAssuredEngine;
import Pojo_Moduel.ResReqPojo;
import io.restassured.response.Response;

public class ResReqHelper 
{	
	public Response getUser(String httpMethodName,String requestURL)
	{
		RestAssuredEngine RAEngine = new RestAssuredEngine();
		return RAEngine.runApi(httpMethodName, requestURL, "");
	}

	public Response postUser(String httpMethodName, String requestURL) 
	{
		ResReqPojo pojo=new ResReqPojo();
		pojo.setName("Sanjay");
		pojo.setName("Automation Tester");
		
		RestAssuredEngine RAEngine = new RestAssuredEngine();
		return RAEngine.runApi(httpMethodName, requestURL, pojo);
	}

	public Response updateUser(String httpMethodName, String requestURL)
	{
		ResReqPojo pojo=new ResReqPojo();
		pojo.setName("SANJAY");
		pojo.setName("Automation TESTER");
		
		RestAssuredEngine RAEngine = new RestAssuredEngine();
		return RAEngine.runApi(httpMethodName, requestURL, pojo);
	}

	public Response deleteUser(String methodName, String serviceEndpoint)
	{
		RestAssuredEngine RAEngine = new RestAssuredEngine();
		return RAEngine.runApi(methodName, serviceEndpoint, "");
	}
	
	
}




