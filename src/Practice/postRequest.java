package Practice;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Files.payLoad;
import Files.resources;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.util.Properties;

public class postRequest {
	
	Properties prop;
	FileInputStream fileInputStream;

	@BeforeTest
	public void init() {

		try {

			if (prop == null) {
				prop = new Properties();
				fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\Files\\env.properties");
				prop.load(fileInputStream);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());

		}
	}

	@Test
	public void postRequestTest() {
		RestAssured.baseURI = prop.getProperty("BASE_URL");

		given().queryParam("key", prop.getProperty("KEY")).body(payLoad.getPostData())

				.when().post(resources.placePostData()).then().assertThat().statusCode(200);

	}

	
}
