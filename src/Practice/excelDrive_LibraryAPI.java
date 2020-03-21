package Practice;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class excelDrive_LibraryAPI {
	
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
		
		
		 RestAssured.baseURI="http://216.10.245.166";
		 
		 given().body("{\r\n\r\n\"name\":"
		 		+ "\"Learn Appium Automation with Java\",\r\n\"isbn\":"
		 		+ "\"bcd\",\r\n\"aisle\":\"227\",\r\n\"author\":\"John foe\"\r\n}\r\n");
		 
		 
		
		
		
		
	}
}
