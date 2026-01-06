package stepdefinitions;

import java.net.URI;
import static org.testng.Assert.assertEquals;

import com.aventstack.extentreports.ExtentTest;

import TestDataSets.TestData;
import api.ApiHelper;
import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.UserRegistrationRequest;

public class RegisterApiSteps {
	String register_endpoint;
	Response response;
	int response_code;
	String response_message;
	String uniqueEmail;
	private ExtentTest test = Hooks.getTest();
	UserRegistrationRequest payload;

	@Given("the user registration data is prepared")
	public void prepareRegistrationData() {
		uniqueEmail = "testApi" + System.currentTimeMillis() + "@mail.com";
		test.info("Generated dynamic email: " + uniqueEmail);
		payload = new UserRegistrationRequest(uniqueEmail, "Test1234!", "Auto User");

	}

	@When("I send a POST request")
	public void sendPostRequest() {
		try {

			URI uri = URI.create(TestData.base_url);
			register_endpoint = uri.resolve(TestData.create_account_url).toString();

			test.info("Setting API endpoint: " + register_endpoint);
			response = ApiHelper.registerFormField(payload, register_endpoint);

			test.info("Response received:\n" + response.asPrettyString());
			test.pass("API request sent successfully.");

		} catch (Exception e) {
			test.fail("API request failed: " + e.getMessage());
			throw e;
		}

	}

	@Then("the response status code should be {int}")
	public void verifyStatusCode(int expectedStatusCode) {
		try {

			response.then().statusCode(expectedStatusCode);
			test.pass("Status code validation passed: " + expectedStatusCode);

		} catch (Exception e) {
			test.fail("Status code validation failed: " + e.getMessage());
			throw e;
		}
	}

	@And("the response body should contain responseCode {int}")
	public void the_response_should_contain_success(int responseCode) {
		try {
			// JSON in html body
			String raw = response.asString();
			String json = raw.replaceAll("(?s).*<body>", "").replaceAll("</body>.*", "").trim();
			System.out.println("json is: " + json.trim());
			test.info("Extracted JSON: " + json);

			io.restassured.path.json.JsonPath jp = new io.restassured.path.json.JsonPath(json);

			assertEquals(jp.getInt("responseCode"), responseCode);
			assertEquals(jp.getString("message"), "User created!");

			test.pass("Response body validated successfully");

		} catch (Exception e) {
			test.fail("Response body validation failed.\nActual response:\n" + response.asPrettyString());
			throw e;
		}

	}
}
