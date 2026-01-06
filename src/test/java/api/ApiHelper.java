package api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import io.restassured.specification.RequestSpecification;
import models.UserRegistrationRequest;

public class ApiHelper {

	public static Response registerFormField(UserRegistrationRequest payload, String register_endpoint) {
		try {
			RequestSpecification request = given().contentType("multipart/form-data")
					.multiPart("name", payload.getName()).multiPart("email", payload.getEmail())
					.multiPart("password", payload.getPassword()).multiPart("title", "Mrs")
					.multiPart("birth_date", "13").multiPart("birth_month", "10").multiPart("birth_year", "1994")
					.multiPart("firstname", "Test").multiPart("lastname", "TestLastname")
					.multiPart("company", "TestCompany").multiPart("address1", "TestAddress").multiPart("address2", "")
					.multiPart("country", "Netherlands").multiPart("zipcode", "testZipcodeAA11")
					.multiPart("state", "Holland").multiPart("city", "nord").multiPart("mobile_number", "0612345678");
			Response response = request.when().post(register_endpoint);
			return response;
		} 
		catch (Exception e) {
			System.err.println("API request failed: " + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}
}
