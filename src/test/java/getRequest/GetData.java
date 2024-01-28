package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData {

	String url="https://api.openweathermap.org/data/2.5/weather?q=kirkland&appid=bd5ace359adb2b7e0b596ef3edb86be6";
	String name = "Kirkland";
	
	@Test
	public void testResponseCode() {
		
		Response resp = RestAssured.get(url);
		//System.out.println(resp.asPrettyString());
		int code = resp.getStatusCode();
		System.out.println("Status code of the weather is: "+ code);
		Assert.assertEquals(code, 200);

	}

	@Test
	public void getBody(){
		
		Response resp1 = RestAssured.get(url);
		System.out.println("Response1 value is: "+resp1.asPrettyString());
		String txtBody = resp1.asPrettyString();
		
		if(txtBody.contains("weather")){
			Assert.assertEquals(name, "Kirkland");	
		}
		
		Long time = resp1.getTime();		
		System.out.println("Time taken: "+ time);
	}
}
