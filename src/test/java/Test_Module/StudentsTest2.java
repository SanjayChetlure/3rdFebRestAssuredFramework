package Test_Module;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

import Helper_Module.StudentsHelper;
import LibraryFiles.UtilityClass;
import Pojo_Moduel.StudentPojo;
import io.restassured.response.Response;

public class StudentsTest2 
{
	StudentsHelper StudentHelper=new StudentsHelper();
	JsonMapper mapper=new JsonMapper();
	SoftAssert soft=new SoftAssert();

	//@Test(dataProvider = "GetTD", dataProviderClass = UtilityClass.class, priority = 1)
    public void TC15_getStudentDetailsAndMapToPojo(String httpMethodName, String requestURL, int statusCode) throws JsonMappingException, JsonProcessingException 
    {
    	Response resp =  StudentHelper.getStudent(httpMethodName, requestURL);
    	Assert.assertEquals(resp.getStatusCode(), statusCode, "Status code failed");
    	
    	StudentPojo pojo = mapper.readValue(resp.body().asString(), StudentPojo.class);
    	soft.assertEquals(pojo.getId(), "1","Failed TC15- Id mismatch");
    	soft.assertEquals(pojo.getName(), "john","Failed TC15- name mismatch");
    	soft.assertEquals(pojo.getLocation(), "india","Failed TC15- location mismatch");
    	soft.assertEquals(pojo.getCources()[0], "Java","Failed TC15- Course mismatch");
    	soft.assertAll();
    }
	
    
    //@Test(dataProvider = "GetTD", dataProviderClass = UtilityClass.class, priority = 2)
//  public void TC16_getallStudentDetailsAndMapToPojo(String methodName, String serviceEndpoint, int statusCode) throws JsonMappingException, JsonProcessingException 
//  {
//  	Response resp =  StudentHelper.postStudent(methodName, serviceEndpoint);
//  	Assert.assertEquals(resp.getStatusCode(), statusCode, "Status code failed");
//  	
//  	// List<StudentPojo> pojo = mapper.readValue(resp.body().asString(), new TypeReference<List<StudentPojo>>() {});
//  	 StudentPojo[] ar = mapper.readValue(resp.body().asString(), StudentPojo[].class);
//  	 
//  	soft.assertEquals(ar[1].getId(), "2","Failed TC16- Id mismatch");
//  	soft.assertEquals(ar[1].getName(), "KIM","Failed TC16- name mismatch");
//  	soft.assertEquals(ar[1].getLocation(), "US","Failed TC15- location mismatch");
//  	soft.assertEquals(ar[1].getCources()[0], "python","Failed TC15- cources mismatch");
//  	soft.assertAll();
//  }
    
	
	
	@Test(dataProvider = "GetTD", dataProviderClass = UtilityClass.class, priority = 2)
    public void TC16_getallStudentDetailsAndMapToPojo(String httpMethodName, String requestURL, int statusCode) throws JsonMappingException, JsonProcessingException 
    {
    	Response resp =  StudentHelper.getStudent(httpMethodName, requestURL);
    	Assert.assertEquals(resp.getStatusCode(), statusCode, "Status code failed");
    	
    	// List<StudentPojo> pojo = mapper.readValue(resp.body().asString(), new TypeReference<List<StudentPojo>>() {});
    	 StudentPojo[] ar = mapper.readValue(resp.body().asString(), StudentPojo[].class);
     	 List<StudentPojo> pojoList = Arrays.asList(ar);
    	 
    	soft.assertEquals(pojoList.get(0).getId(), "1","Failed TC16- Id mismatch");
    	soft.assertEquals(pojoList.get(1).getName(), "KIM","Failed TC16- name mismatch");
    	soft.assertEquals(pojoList.get(0).getLocation(), "india","Failed TC15- location mismatch");
    	soft.assertEquals(pojoList.get(0).getCources()[0], "Java","Failed TC15- courses mismatch");
    	soft.assertAll();
    }
	

	
    
	
}




