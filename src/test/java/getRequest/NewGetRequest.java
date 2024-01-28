package getRequest;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import groovy.transform.stc.MapEntryOrKeyValue;

public class NewGetRequest {
	
	public String baseURI = "https://reqres.in";
	
	@Test(enabled=false, priority=2)
	public void getReq1() {
		/*
		Response resp = RestAssured.get(baseURI+"/api/users?page=2");
		int statusCode = resp.getStatusCode();
		System.out.println(resp.asPrettyString());
		System.out.println(resp.getBody().asString());
		System.out.println("Time Details: " + resp.getTime());
		System.out.println("Status Line Details: " + resp.getStatusLine());
		System.out.println("Content Details: " + resp.getContentType());
		System.out.println("Cookie Details: " + resp.getDetailedCookies());
		
		Assert.assertEquals(statusCode, 200);*/
	}

	@Test(enabled=false, priority=3, description = "This is to verify the RestAssured BaseURI variable.")
	public void getReq2() {
		
		RestAssured.baseURI="https://reqres.in";
		
		Response resp = get("/api/users?page=2");
		int statusCode = resp.getStatusCode();
//		System.out.println(resp.asPrettyString());
//		System.out.println(resp.getBody().asString());
//		System.out.println("Time Details: " + resp.getTime());
//		System.out.println("Status Line Details: " + resp.getStatusLine());
//		System.out.println("Content Details: " + resp.getContentType());
//		System.out.println("Cookie Details: " + resp.getDetailedCookies());
		
		Assert.assertEquals(statusCode, 200);
	}

	@Test(enabled=false, priority=4, description="This is short-cut code of the test method.")
	public void getReq3() {
		
		baseURI = "https://reqres.in";
		
		given().
			get("/api/users?page=2").
		then().
			assertThat().statusCode(200).and().body("data[0].id", equalTo(7), "data[1].first_name", equalTo("Lindsay"), 
					"data.first_name", hasItems("Rachel", "Lindsay", "Byron"));
			//.and().log().all();
		
	}
	
	
	@Test(groups="Regression", enabled=false, priority=5, description="This test is to insert Map values in JSONObject to validate the Post method.")
	public void testPost() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Subodh");
		map.put("job \"Fair\"", "Teacher");
		map.put("Salary", "$"+2345.65);
		System.out.println(map);
		
		JSONObject jsonreq = new JSONObject(map);
		System.out.println("This is jsonreq: "+jsonreq.toJSONString());
		
	}

	@Test(groups="Regression", enabled=false, priority=6, description="This test is to insert values in JSONObject to validate the Post method.")
	public void testPost1() {
		
		JSONObject jsonreq = new JSONObject();
		jsonreq.put("first_name", "Subodh");
		jsonreq.put("last_name", "Teacher");
		jsonreq.put("email", "subodh@mail.com");
		System.out.println("This is jsonreq: "+jsonreq.toJSONString());
		
		given().
			body(jsonreq.toJSONString()).
		when().
			post(baseURI+"/api/users").
		then().
			assertThat().statusCode(201);
		
	}
	
	@Test(groups="Regression", enabled=false, priority=7, description="This test is to validate the Put method.")
	public void testPut() {
		
		JSONObject jsonreq = new JSONObject();
		jsonreq.put("name", "Subodh");
		jsonreq.put("job", "Teacher");
		System.out.println("This is jsonreq: "+jsonreq.toJSONString());
		
		given().
			body(jsonreq.toJSONString()).
		when().
			put(baseURI+"/api/users/2").
		then().
			assertThat().statusCode(200)
			.log().all();
		
	}
	
	@Test(groups="Regression", enabled=true, priority=8, description="This test is to validate the Patch method.")
	public void testPatch() {
		
		JSONObject jsonreq = new JSONObject();
		jsonreq.put("name", "Subodh");
		jsonreq.put("job", "Teacher");
		Reporter.log("This is jsonreq: "+jsonreq.toJSONString());
		
		given().
			body(jsonreq.toJSONString()).
		when().
			patch(baseURI+"/api/users/2").
		then().
			assertThat().statusCode(200);
			//.log().all();
		
	}
	
	@Test(groups="Regression", enabled=true, priority=9, description="This test is to validate the Delete method.")
	public void testDelete() {
		
		when().
			delete(baseURI+"/api/users/2").
		then().
			assertThat().statusCode(204)
			.log().all();
		
	}
}
