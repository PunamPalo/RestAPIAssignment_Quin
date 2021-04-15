package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class stepDefinition extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data =new TestDataBuild();
	static String bin_id;
	

	 @Given("User makes a request to CreateBinAPI with {string}  {string}")
	 public void user_makes_a_request_to_create_bin_api_with(String name, String address) throws IOException {
		 res=given().spec(requestSpecification())
					.body(data.addBinPayLoad(name,address));
	 }
	
	@Then("the API call request gets success with status code {int}")
	public void the_api_call_request_gets_success_with_status_code(Integer int1) {	    
		assertEquals(200, response.getStatusCode());
	}
	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
	    
		APIResources resourceAPI=APIResources.valueOf(resource);		
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("POST"))
		{
			response =res.when().post(resourceAPI.getResource());
			bin_id = response.then().contentType(ContentType.JSON).extract().path("metadata.id");			
		}
		else if(method.equalsIgnoreCase("GET"))
			 response =res.when().get(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("PUT"))
			response =res.when().put(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("DELETE"))
			response =res.when().delete(resourceAPI.getResource());		
	}
	
	@Given("User makes a request to ReadBinAPI with {string}")
	public void user_makes_a_request_to_read_bin_api_with(String Id)  throws IOException {
	    
		res=given().spec(requestSpecification()).pathParam("BIN_ID", bin_id);
	}
	
	@Given("User makes a request to UpdateBinAPI with {string}  {string}")
	public void user_makes_a_request_to_update_bin_api_with(String name, String address) throws IOException {
		res=given().spec(requestSpecification())
				.body(data.addBinPayLoad(name,address)).pathParam("BIN_ID", bin_id);

	}
	
	@Given("User makes a request to DeleteBinAPI")
	public void user_makes_a_request_to_delete_bin_api()  throws IOException {
		res=given().spec(requestSpecification()).pathParam("BIN_ID", bin_id);
	}
	
	
}
