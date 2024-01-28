package getRequest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData_Best_Practice {

	String url="https://api.openweathermap.org/data/2.5/weather?q=kirkland&appid=bd5ace359adb2b7e0b596ef3edb86be6";
	
	@Test
	public void testResponseCode() {
		// TODO Auto-generated method stub
		
		Response resp = RestAssured.given().get(url);
		Reporter.log(resp.asPrettyString());
		int code = resp.getStatusCode();
		//System.out.println("Status code of the weather is: "+ code);
		Assert.assertEquals(code, 200);		

	}
	
	@Test(enabled=false)
	public void testBody() {
		// Best way to write API code
		
		int code = get(url).getStatusCode();
		String body = get(url).getBody().asPrettyString();
		long time = get(url).getTime();
		
		System.out.println("Beautify body is: "+body);
		System.out.println("Status code of the weather is: "+ code);
		Assert.assertEquals(code, 200);	
		System.out.println("Time taken to execute: "+time);

	}

}
