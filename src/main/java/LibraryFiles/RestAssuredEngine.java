

package LibraryFiles;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredEngine 
{

    private RequestSpecBuilder builder = new RequestSpecBuilder();


    public Response runApi(String httpMethodName,String requestURL,  Object body) 
    {    	
    	if(httpMethodName.equals("POST") || httpMethodName.equals("PUT"))
    	{
    		builder.setBody(body);
    	}
    	
        RequestSpecification requestSpecification = builder.build().log().all();
        RequestSpecification request = RestAssured.given();
        //setup content type
        request.contentType(ContentType.JSON);
        request.spec(requestSpecification);
        
        if(httpMethodName.equalsIgnoreCase("GET")) {
            return request.get(requestURL);
        }
        else if(httpMethodName.equalsIgnoreCase("POST")) {
            return request.post(requestURL);
        }
        else if(httpMethodName.equalsIgnoreCase("DELETE")) {
            return request.delete(requestURL);
        }
        else if(httpMethodName.equalsIgnoreCase("PUT")) {
            return request.put(requestURL);}
        return null;
    }
    

 

}
