package apiCaller;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public abstract class apiToolBase {
	
	private String _apiHost;
	public apiToolBase(String apiHost) {
		_apiHost = apiHost;
	}
	
	
	String buildUruFor(String uriPart) {
		URL mergedURL = null;
		try {
			mergedURL = new URL(new URL(_apiHost), uriPart);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String finalUrl = mergedURL.toString();
		return finalUrl;
	}
	
	
	String getRequest(String url) {
		RestTemplate restTemplate = new RestTemplate();
		String res = restTemplate.getForObject(url, String.class);
		
		return res;
	}
	
	
	String postRequest(String url, String requestBody) {
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<String> request = new HttpEntity<String>(requestBody, headers);
	    
	    RestTemplate restTemplate = new RestTemplate();
		String res = restTemplate.postForObject(url, request, String.class);
		
		return res;
	}
	
}
