package Practice;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class post_deleteRequest {
	
	Properties prop;
	FileInputStream fileInputStream;
	
	@BeforeTest
	public void init(){
		
		try{
			
			if(prop==null){
				prop = new Properties();
				fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\Files\\env.properties"); 
				prop.load(fileInputStream);
			}
					
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			
		}
	}
	

	@Test
	public void post_deleteRequestTest() {
		String completeBody = 
				"{\n" + "  \"name\": \"Sumit\",\n" + "  \"salary\": \"500000\",\n" + "  \"age\": \"20\"\n"
				+ "}";

		Response res = null;

		RestAssured.baseURI = prop.getProperty("HOST");

		res = given().body(completeBody).log().all().

				when().post("/create").

				then().assertThat().and().statusCode(200).extract().response();
		String result = res.asString();
		System.out.println("Complete Response Post Value is === > " + result);
			 
		JsonPath js = new JsonPath(result);
		//int ID = js.get("age");
		//System.out.println("JSON OBJECT === > " + ID);
		
	}
}
