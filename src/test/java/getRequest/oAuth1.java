package getRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class oAuth1 {
	
	@Test
	public void postTweet() {
		
		Response resp = RestAssured.given()
						.auth()
						.oauth("", "", "", "")
						.post("");
		
		System.out.println("My first tweet is "+resp.getBody().jsonPath().prettify());
		JsonPath jsonpath = resp.jsonPath();
		String tweetId = jsonpath.get("");
		System.out.println("My first tweet is "+resp.getStatusCode());
		
	}

}
