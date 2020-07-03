package appTools;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class settingReader {

	public static final String apiHost = "api.Host";
	
	
	String settingFile;
	public settingReader() {
		settingFile = "src/resources/config.properties";
	}
	
	public settingReader(String settingFile) {
		this.settingFile = settingFile;
	}
	
	
	
	public String readPropertyValue(String propertyKey) {
		Properties p = getProperties();
		String res = p.getProperty(propertyKey);
        return res;
	}
	
	
	Properties getProperties() {
		FileInputStream fis;
        Properties property = new Properties();
        try {
			fis = new FileInputStream(settingFile);
			property.load(fis);
			return property;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return null;
	}

	
}