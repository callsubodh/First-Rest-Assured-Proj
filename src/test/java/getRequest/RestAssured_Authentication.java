package getRequest;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssured_Authentication {
	
	@Test
	public void preemptive_auth_test() {
	
	int code = RestAssured.given()
			.auth()
			.preemptive()
			.basic("postman","password")
			.when()
			.get("https://postman-echo.com/basic-auth")
			.getStatusCode();
	
	System.out.println("Code is: "+code);
	
	Assert.assertEquals(code, 200);
	
	}

	}

