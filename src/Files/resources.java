package Files;

public class resources {
	public static String placePostData() {

		String res = "/maps/api/place/add/json";
		return res;

	}

	public static String placePOSTData_LibAPI(){
		String resource = "Library/Addbook.php";
		return resource;
	}
	
	public static String placeDeleteData_LibAPI(){
		String res = "/Library/DeleteBook.php";
		return res;
	}
	
}
