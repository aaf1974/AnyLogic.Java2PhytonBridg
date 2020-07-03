package apiCaller;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

public class phytonTestMethods extends apiToolBase {
	
	public static final String testPostMethod = "emb";
	public static final String testGetMethod = "getM";
	public static final String testPostMethodWithParam = "postM";
	
	public phytonTestMethods(String apiHost) {
		super(apiHost);
	}
	
	
	public String callGetMethod() {

		String finalUrl = buildUruFor(testGetMethod);
		return getRequest(finalUrl);
	}
	

	public String callPostMethod() {
		
		String finalUrl = buildUruFor(testPostMethod);
	    return postRequest(finalUrl, "{\"hello\" : 123}");
	}


	public String callPostMethodWithParam() {
		
		String finalUrl = buildUruFor(testPostMethodWithParam);
		
		task t = new task();
		t.id = 333;
		t.title = "java title";
		
		StringWriter writer = new StringWriter();
		 ObjectMapper mapper = new ObjectMapper();
		 try {
			mapper.writeValue(writer, t);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	    return postRequest(finalUrl, writer.toString());
	}
	
	
	@JsonAutoDetect
	class task{
		public int id;
		public String title;
	}
}
