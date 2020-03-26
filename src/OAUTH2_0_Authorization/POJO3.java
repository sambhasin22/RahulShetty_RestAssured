package OAUTH2_0_Authorization;
//To get code :- 

//https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php

import static io.restassured.RestAssured.given;

import java.util.List;

import POJO3.getAllCources;
import POJO_Serialization.GetCources;
import POJO_Serialization.WebAutomation_SubClass_Cources;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class POJO3 {
	public static void main(String[] args) throws InterruptedException {

		String code = "https://rahulshettyacademy.com/getCourse.php?code=4/xwEXQ2JganQV7RQvCZkCBRyoZHZUTYbDUA8vSXajoPDGIC6tWuhv2__ffRqQUIonPn2781aOth-3pPkh3FWDI9M&scope=email+https://www.googleapis.com/auth/userinfo.email+openid&authuser=0&prompt=none";

		String first = code.split("code=")[1];
		String actualCode = first.split("&scope")[0];
		System.out.println("Actual Code is === > " + actualCode);
		Thread.sleep(1000);

		String accessTokenResponse = given().urlEncodingEnabled(false).log().all().queryParams("code", actualCode)
				.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParams("grant_type", "authorization_code").when()
				.post("https://www.googleapis.com/oauth2/v4/token").asString();
		JsonPath js = new JsonPath(accessTokenResponse);

		String accessTokenNumber = js.getString("access_token");

		System.out.println("Access token is ====== > " + accessTokenNumber);

		
		//ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
//		GetCources getCourceObject = mapper.readValue(given().queryParam("access_token", accessTokenNumber).expect()
//				.defaultParser(Parser.JSON).when().get("https://rahulshettyacademy.com/getCourse.php"), getAllCources.class);
		
		
		/*
		GetCources getCourceObject = given().queryParam("access_token", accessTokenNumber).expect()
				.defaultParser(Parser.JSON)
				// expect().defaultParser(Parser.JSON) It will tell that
				// Response will get in Default JSON
				.when().get("https://rahulshettyacademy.com/getCourse.php").as(getAllCources.class)getAllCources.class;*/
		
		
		
		
		
		// .as(GetCources.class) with this response will convert in to
		// GetCources class object {Previously we convert the response in to
		// String using .asString()}

//		System.out.println("Linked In Value is === > " + getCourceObject.getLinkedIn());
//		System.out.println("WebAutomation[1] CourceTitle is === > "
//				+ getCourceObject.getCourses().getWebAutomation().get(1).getCourseTitle());
//		System.out.println("WebAutomation[1] CourceTitle is === > "
//				+ getCourceObject.getCourses().getWebAutomation().get(1).getPrice());
//
//		List<WebAutomation_SubClass_Cources> data = getCourceObject.getCourses().getWebAutomation();
//		for (int i = 0; i < data.size(); i++) {
//			System.out.println("Cource Name === > " + data.get(i).getCourseTitle() + " and " + "Cource Price is === > "
//					+ data.get(i).getPrice());
//		}
//
	}

}
