package getRequest;

import org.openqa.selenium.devtools.v85.fetch.model.AuthChallengeResponse.Response;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseClass {
	
	@BeforeClass
	public void baseDemo() {
		
		RestAssured.authentication=RestAssured.preemptive().basic("postman", "password");
		RestAssured.get("https://postman-echo.com/basic-auth");
		
		
		
	}

}
