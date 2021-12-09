package RestAPI;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	@Test
	public void PostCall() {
		
		Logger logger = Logger.getLogger("APILogs");
        PropertyConfigurator.configure("log4j.properties");
        logger.setLevel(Level.DEBUG);
        logger.info("********* started the get call***********");
		
		RestAssured.baseURI ="https://reqres.in/api/users";
		
		RequestSpecification request = RestAssured.given();
		
		Response response =request.contentType(ContentType.JSON)
		                           .accept(ContentType.JSON)
		                           .body(" {\n" + 
		                           		"        \"id\": 100,\n" + 
		                           		"        \"email\": \"abc@xyz.com\",\n" + 
		                           		"        \"first_name\": \"Amarendra\",\n" + 
		                           		"        \"last_name\": \"Nayak\",\n" + 
		                           		"        \"avatar\": \"https://reqres.in/img/faces/1-image.jpg\"\n" + 
		                           		"}")
		                           .post();
		                           
		
		    String ResponseBody = response.body().asString();
		                  	     
		   
		    System.out.println(ResponseBody);
		
		int ActResponse =response.statusCode();
		int ExpResponse=201;
		
		
		AssertJUnit.assertEquals(ActResponse, ExpResponse);
		
		
	}

}


