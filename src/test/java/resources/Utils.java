package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;
	
	/**  
	 * To set the mandatory params in header of API requests 
	 */
	
	public RequestSpecification requestSpecification() throws IOException
	{		
		if(req==null)
		{
		PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
		 req=new RequestSpecBuilder()
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
		.setContentType(ContentType.JSON).build().header("X-Master-Key",getGlobalValue("X-Master-Key"));
		 return req;
		}
		return req;		
	}
	
	/** 
	 * Using this method we can call the global property values
	 */
	
	public String getGlobalValue(String key) throws IOException
	{
		Properties prop =new Properties();
		
		FileInputStream propertyFile =new FileInputStream("src/test/java/resources/global.properties");
		prop.load(propertyFile);
		return prop.getProperty(key);
	
	}
	
	/**
	 *  This method is to get response of a request
	 */	
	
	public String getJsonPath(Response response,String key)
	{
		String resp=response.asString();
		JsonPath jpath = new JsonPath(resp);
		return jpath.get(key).toString();
	}
}
