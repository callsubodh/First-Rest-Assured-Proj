package passHeaders;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {
	
	static String token = "abcdzzz";
	
	@Test(description="This is just a code demo as the url is wrong")
	public void passJSONBody() {
		
		Response resp = RestAssured.given()
				//.header("Authorization", "bearer "+token)
				.body("{\"phone_number\":\"2222222222\",\"\r\n" + 
	                    "               + \" \"country_code\": \"+91\",\"\r\n" + 
	                    "               + \" \"login_type\": 0}")
				.post("http://url/api/v1/login");
		
		System.out.println(resp.asString());

	}

	public static Headers headerManager() {
		
		Header contentType = new Header("content-Type","application/json");
		Header auth = new Header("Authorization","my token");
		
		List<Header> listHead = new ArrayList<Header>();
		listHead.add(contentType);
		listHead.add(auth);
		Headers head = new Headers(listHead);
		
		return head;
	}
	
	public void create() {
		
		Response resp = RestAssured.given()
					.headers(headerManager())
					.passJSONBody()
				.when()
					.post("");
				.then()
					.contentType(equalTo("Hello World"));
	}
}
