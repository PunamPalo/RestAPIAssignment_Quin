package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException
	{
		
		if(req==null)
		{
		PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
		 req=new RequestSpecBuilder()
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
		.setContentType(ContentType.JSON).build().headers("X-Master-Key", "$2b$10$ny7gi6kk.p7AzIo4oeBo7ecw63D6O/frcHg7eEhMzGlp1gaCHK0za");
		 return req;
		}
		return req;		
	}
		
	public String getJsonPath(Response response,String key)
	{
		String resp=response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}
}
