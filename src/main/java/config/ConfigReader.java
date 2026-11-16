package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import exceptions.FrameworkException;

public class ConfigReader {
	
	private static Properties properties;

    public static void loadProperties() {

    	properties = new Properties();

        try (FileInputStream fis = new FileInputStream(
                "src/test/resources/config.properties")) {

            properties.load(fis);

        } catch (IOException e) {
        	throw new FrameworkException(
                    "Unable to load config.properties", e
            );
        }
        
       
    }
    
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public static String getApplicationUrl() {

        String environment = getEnvironment();

        String urlKey = environment.toLowerCase() + ".url";

        String url = getProperty(urlKey);

        if (url == null || url.isEmpty()) {
            throw new RuntimeException(
                    "Application URL not configured for environment: "
                    + environment
            );
        }

        return url;
    }
    
    public static String getEnvironment() {

        return System.getProperty(
                "environment",
                getProperty("environment")
        );
    }

    
/*
loadProperties() is called.
FileInputStream opens the config file.
new Properties() creates a Properties object.
properties.load(fis) reads all key-value pairs.
getProperty("browser") retrieves the corresponding value.
*/
    
//One important point: loadProperties() must execute before getProperty(). Otherwise, properties will still be null.
//loadProperties() loads the configuration file, whereas getProperty() retrieves an individual value such as browser or url.    

    
}
