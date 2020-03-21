package Library_API;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Files.payLoad;
import Files.resources;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Library_POST_GET_Delet_API {

	Properties prop;
	FileInputStream fs;
	String ID;

	@BeforeTest
	public void init() throws IOException {

		try {
			if (prop == null) {
				prop= new Properties();
				fs = new FileInputStream(System.getProperty("user.dir") + "\\src\\Files\\env.properties");
				prop.load(fs);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test(priority = 1)
	public void lib_PostTest() {

		RestAssured.baseURI = prop.getProperty("LIB_BASE_URL");

		Response res = given().body(payLoad.getData("bunty","9999")).when().post(resources.placePOSTData_LibAPI()).then().assertThat()
				.statusCode(200).extract().response();

		String result = res.asString();
		System.out.println("After Submit Value is == > " + result);

		JsonPath js = new JsonPath(result);
		 ID = js.get("ID");
		System.out.println("ID is === > " + ID);

	}

	@Test(priority = 2)
	public void lib_GetTest() {
		RestAssured.baseURI = prop.getProperty("LIB_BASE_URL");

		Response res = given().when().get("Library/GetBook.php?ID="+ID+"").then().assertThat().statusCode(200)
				.extract().response();

		String result = res.asString();
		System.out.println("OutPut is === > " + result);

	}

	@Test(priority = 3)
	public void lib_DeleteTest() {
		RestAssured.baseURI = prop.getProperty("LIB_BASE_URL");

		Response res = given().body(payLoad.removeData(ID)).when().post(resources.placeDeleteData_LibAPI()).then()
				.assertThat().statusCode(200).extract().response();

		String result = res.asString();
		System.out.println("Result Is after deletion === > " + result);

	}

}
