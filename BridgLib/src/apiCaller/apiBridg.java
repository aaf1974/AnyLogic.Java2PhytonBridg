package apiCaller;

public class apiBridg {

	private String _apiHost;
	public phytonTestMethods phytonTestMethods;
	
	
	public apiBridg(String apiHost){
		_apiHost = apiHost;
		
		phytonTestMethods = new phytonTestMethods(_apiHost);
	}
}



