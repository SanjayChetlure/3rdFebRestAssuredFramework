package Helper_Module;

import LibraryFiles.RestAssuredEngine;
import Pojo_Moduel.ResReqPojo;
import Pojo_Moduel.StudentPojo;
import io.restassured.response.Response;

public class StudentsHelper 
{	
	
	public Response postStudent(String httpMethodName, String requestURL) 
	{		
		StudentPojo pojo=new StudentPojo();
		pojo.setId("4");
		pojo.setName("abc4");
		pojo.setLocation("mumbai");
		pojo.setPhone("4444");
		String [] cources= {"c","c++"}; 
		pojo.setCources(cources);
		
		RestAssuredEngine RAEngine = new RestAssuredEngine();
		return RAEngine.runApi(httpMethodName, requestURL, pojo);
	}

	
	public Response getStudent(String httpMethodName,String requestURL)
	{
		RestAssuredEngine RAEngine = new RestAssuredEngine();
		return RAEngine.runApi(httpMethodName, requestURL, "");
	}

	
	public Response updateStudent(String httpMethodName, String requestURL)
	{
		StudentPojo pojo=new StudentPojo();
		pojo.setId("4");
		pojo.setName("ABCD");
		pojo.setLocation("MUMBAI");
		pojo.setPhone("4444");
		String [] cources= {"C","C++"}; 
		pojo.setCources(cources);
		
		RestAssuredEngine RAEngine = new RestAssuredEngine();
		return RAEngine.runApi(httpMethodName, requestURL, pojo);
	}

	public Response deleteStudent(String httpMethodName, String requestURL)
	{
		RestAssuredEngine RAEngine = new RestAssuredEngine();
		return RAEngine.runApi(httpMethodName, requestURL, "");
	}
	
	
}




