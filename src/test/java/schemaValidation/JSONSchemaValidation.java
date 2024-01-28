package schemaValidation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class JSONSchemaValidation {

	@Test(enabled=true, priority=1, description="This is to test JSON Schema Validation.")
	public void getReq3() {
		
		RestAssured.baseURI = "https://reqres.in";
		
		given().
			get("/api/users?page=2").
		then().
			assertThat().statusCode(200).and().body(matchesJsonSchemaInClasspath("Schemas/schema.json")).and().
					body("data[0].id", equalTo(7), "data[1].first_name", equalTo("Lindsay"), 
					"data.first_name", hasItems("Rachel", "Lindsay", "Byron"))
			.and().log().all();
		
	}
}
