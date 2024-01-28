package getRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Post_Del_PutDemo {

	String uri = "http://reqres.in";
	
	@Test(description="This is a post demo.")
	public void post() {
		
	
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("id", "21");
		jsonobj.put("title", "Learn Selenium");
		jsonobj.put("author", "Subodh");
		
		request.body(jsonobj.toJSONString());
		
		Response resp = request.post("http://localhost:3000/posts");
		
		int stCode = resp.getStatusCode();
		
		Assert.assertEquals(stCode, 201);
	
	}
	
	@Test(description="This is a put demo.")
	public void put() {
		
	
		RequestSpecification request = RestAssured.given();
		request.header("Content_type", "application/json");
		
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("id", "21");
		jsonobj.put("title", "Learn Selenium");
		jsonobj.put("author", "Sierra");
		
		request.body(jsonobj.toJSONString());
		
		Response resp = request.put("http://localhost:3000/posts");
		
		int stCode = resp.getStatusCode();
		
		Assert.assertEquals(stCode, 201);
	
	}
	
	@Test(description="This is a delete demo.")
	public void delete() {
		
	
		RequestSpecification request = RestAssured.given();
		
		Response resp = request.delete("http://localhost:3000/posts/25");
		
		int stCode = resp.getStatusCode();
		
		Assert.assertEquals(stCode, 201);
	
	}
	
	@Test(description="This is a get demo.")
	public void get() {
		
	
		RequestSpecification request = RestAssured.given();
		
		Response resp = request.get("http://localhost:3000/posts/25");
		
		int stCode = resp.getStatusCode();
		
		Assert.assertEquals(stCode, 200);
	
	}
}
