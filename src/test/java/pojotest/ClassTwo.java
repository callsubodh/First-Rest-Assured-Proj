package pojotest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClassTwo {

	public static void main(String[] args) throws JsonProcessingException {
		
		ClassOne oneobj = new ClassOne("taskone");
		
		ObjectMapper objmap = new ObjectMapper();
		String payload = objmap.writerWithDefaultPrettyPrinter().writeValueAsString(oneobj);
		System.out.println(payload);

	}

}
