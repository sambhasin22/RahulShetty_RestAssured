package Practice;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class resuableMethods {

	public JsonPath rawToJson(Response res) {

		String response = res.asString();
		JsonPath jsonpath = new JsonPath(response);
		return jsonpath;

	}

}
