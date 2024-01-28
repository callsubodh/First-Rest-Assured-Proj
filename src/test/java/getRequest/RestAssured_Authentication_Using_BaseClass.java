package getRequest;

import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utility.BaseClass;

public class RestAssured_Authentication_Using_BaseClass extends BaseClass {
	
	@Test
	public void preemptive_auth_test() {
	
	int code = given()
			  .get()
			  .getStatusCode();
	
	System.out.println("Code is: "+code);
	
	Assert.assertEquals(code, 200);
	
	}

	}

