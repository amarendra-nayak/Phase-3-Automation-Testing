package RestAPI;


	import org.testng.annotations.Test;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
	import org.testng.annotations.Test;

	import io.restassured.RestAssured;
	import io.restassured.path.json.JsonPath;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;


	public class GetRequest {
		
		
		@Test
		public void GetCall() {
			Logger logger = Logger.getLogger("APILogs");
	        PropertyConfigurator.configure("log4j.properties");
	        logger.setLevel(Level.DEBUG);
	        logger.info("********* started the get call***********");
			
			
			RestAssured.baseURI ="https://reqres.in/api/users";
			
			RequestSpecification request = RestAssured.given();
			
		     Response response =request.get();
		     //Response response =request.param("id","1").get("/employees");
		     
		     
		     String ResponseBody = response.body().asString();
		     
		     System.out.println(ResponseBody);
		}
	}


