package OAUTH2_0_Authorization;
import static io.restassured.RestAssured.given;


import io.restassured.path.json.JsonPath;



public class oAuthTest {

	public static void main(String[] args) throws InterruptedException {
	
		
		String code =
		"https://rahulshettyacademy.com/getCourse.php?code=4/xwGkMl7jkArdrS6xmXBk8mpuh94Si3nKxTGv0i0JJtHQPzAPLDqvoS0oUZS_yGt2I66cuuc1twOnbkruWrgc_Zw&scope=email+openid+https://www.googleapis.com/auth/userinfo.email&authuser=0&prompt=none";
		
		String first = code.split("code=")[1];
		String actualCode = first.split("&scope")[0];
		System.out.println("Actual Code is === > " + actualCode);
		Thread.sleep(1000);
	
		String accessTokenResponse = given().urlEncodingEnabled(false).log().all()
		.queryParams("code",actualCode)
		.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type","authorization_code")
		.when()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		JsonPath js = new JsonPath(accessTokenResponse);
		String accessTokenNumber = js.getString("access_token");
		System.out.println("Access token is ====== > " + accessTokenNumber);
			
		Thread.sleep(1000);
		
		String result = given().log().all()
		.queryParam("access_token",accessTokenNumber)
		.when()
		.get(" https://rahulshettyacademy.com/getCourse.php").asString();
		
		System.out.println(result);
		
		
		
		

	}

}
