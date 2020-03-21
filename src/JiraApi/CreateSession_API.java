package JiraApi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;


public class CreateSession_API {

	Properties prop;
	FileInputStream fs;

	@Test
	public void createSessionTest() throws IOException {

		try {
			if (prop == null) {
				prop = new Properties();
				fs = new FileInputStream(System.getProperty("user.dir") + "\\src\\Files\\env.properties");
				prop.load(fs);
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		RestAssured.baseURI = prop.getProperty("JIRA_BASEURL");
		
		//given().
		//body("").
		
		
		
		
		
		

	}

}
