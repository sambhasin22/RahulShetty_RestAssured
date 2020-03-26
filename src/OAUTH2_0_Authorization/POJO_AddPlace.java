package OAUTH2_0_Authorization;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import Dserialization.AddPlace_MainClass;
import POJO_Deserialization.LocationClass;

public class POJO_AddPlace {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
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
		

		Response res = given().log().all()
				.queryParam("key", "qaclick123")
				.body(addPlace)
				.when()
				.post("/maps/api/place/add/json")
				.then().assertThat().statusCode(200)
				.extract().response();

		String result = res.asString();
		System.out.println("Response is ===== > " + result);
		/*JsonPath js = new JsonPath(result);
		String placeID = js.get("place_id");
		System.out.println("Plca id is === > " + placeID);*/

	}

}
