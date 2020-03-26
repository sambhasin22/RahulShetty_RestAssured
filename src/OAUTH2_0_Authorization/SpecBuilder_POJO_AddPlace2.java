package OAUTH2_0_Authorization;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;
import java.util.ArrayList;
import java.util.List;
import Dserialization.AddPlace_MainClass;
import POJO_Deserialization.LocationClass;


public class SpecBuilder_POJO_AddPlace2 {

	public static void main(String[] args) {

		/*RestAssured.baseURI = "https://rahulshettyacademy.com";*/
		
		
		RequestSpecification request = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
										.setContentType(ContentType.JSON).addQueryParam("key","qaclick123").build();
						
		ResponseSpecification resOnseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		
		
		List<String> typeList = new ArrayList<String>();
		typeList.add("WineShop");
		typeList.add("FirnessEqupments Shops");
		LocationClass lc = new LocationClass();
		lc.setLat(-38.383494);
		lc.setLat(38.1111111);
		
		
		AddPlace_MainClass addPlace = new AddPlace_MainClass();
		addPlace.setAccuracy(100);
		addPlace.setAddress("ParkAvenu-GaurCity1");
		addPlace.setLanguage("Punjabi");
		addPlace.setName("SumitBhasin");
		addPlace.setPhone_number("9560249090");
		addPlace.setWebsite("https://udemy.com");
		addPlace.setType(typeList);
		addPlace.setLocation(lc);
		
		
		RequestSpecification res = given().spec(request)
				.body(addPlace);
				
				Response response = res.when()
				.post("/maps/api/place/add/json")
				.then().spec(resOnseSpec)
				.extract().response();

		String result = response.asString();
		System.out.println("Response is ===== > " + result);
		/*JsonPath js = new JsonPath(result);
		String placeID = js.get("place_id");
		System.out.println("Plca id is === > " + placeID);*/

	}

}
