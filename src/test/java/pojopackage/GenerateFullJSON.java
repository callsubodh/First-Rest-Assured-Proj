package pojopackage;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class GenerateFullJSON {
	
		public static void main(String args[]) throws JsonProcessingException {
		
		IssueType it = new IssueType("tasks");
		Projects pro = new Projects("FirstRestAssuredProj");
		TestJSON tjsonobj = new TestJSON("testjsonvalue");
		Payload pl = new Payload("This is the proj summary","This is the proj description",it,pro, tjsonobj);
		Fields f = new Fields(pl);
		
		ObjectMapper objMap = new ObjectMapper();
		String issueValues = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(tjsonobj);
		System.out.println(issueValues);
			
		}
		
	}
