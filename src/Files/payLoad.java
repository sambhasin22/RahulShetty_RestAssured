package Files;

public class payLoad {

	public static String getPostData() {

		String postData = "{" +

				"\"location\":{" +

				"\"lat\" : -38.383494," +

				"\"lng\" : 33.427362" +

				"}," +

				"\"accuracy\":50," +

				"\"name\":\"Frontline house\"," +

				"\"phone_number\":\"(+91) 983 893 3937\"," +

				"\"address\" : \"29, side layout, cohen 09\"," +

				"\"types\": [\"shoe park\",\"shop\"]," +

				"\"website\" : \"http://google.com\"," +

				"\"language\"+ : \"French-IN\"" +

				"}";

		return postData;

	}

	public static String getData(String isbn , String aisle) {
		String get_Data = "{\r\n\r\n\"name\":"
				+ "\"Learn Appium Automation with Java\",\r\n\"isbn\":\""+isbn+"\",\r\n\"aisle\":\""+aisle+"\",\r\n\"author\":\"John foe\"\r\n}\r\n";

		return get_Data;
	}

	public static String removeData(String ID) {
		String remove = "{\r\n\r\n\"ID\" : \""+ID+"\"\r\n\r\n} \r\n";
		return remove;
	}

}
