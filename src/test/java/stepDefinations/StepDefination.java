package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.GetMovie;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class StepDefination extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data =new TestDataBuild();
	static String place_id;

	@Given("View Movie with {string}  {string} {string} {string}")
	public void add_Place_Payload_with(String string, String string2, String string3, String string4) {
		 try {
			res=given().spec(requestSpecification())
			.body(((TestDataBuild) data).viewMoviePayLoad("apikey","t","y","type"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

@When("user calls {string} with {string} http request")
public void user_calls_with_http_request(String resource, String method) {
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST"))
		 response =res.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
			 response =res.when().get(resourceAPI.getResource());
}

	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(),200);
	}

	@Then("{string} in response body is {int}")
	public void in_response_body_is(String keyValue, int Expectedvalue) {
	String responseBody = res.get().body().asString();
	System.out.println(responseBody);
	
	}
	/*
	 * @Then("{string} in response body is {int}") public void
	 * in_response_body_is(String keyValue, String Expectedvalue) {
	 * assertEquals(getJsonPath(response,keyValue),Expectedvalue); }
	 */

	private RequestSpecification assertThat() {
		// TODO Auto-generated method stub
		return null;
	}
	

	




}
