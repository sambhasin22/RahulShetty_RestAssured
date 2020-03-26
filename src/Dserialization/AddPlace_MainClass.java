package Dserialization;

import java.util.List;

import POJO_Deserialization.LocationClass;

public class AddPlace_MainClass {

	private int accuracy;
	private LocationClass location;
	private List<String> type;
	private String name;
	private String phone_number;
	private String address;
	private String website;
	private String language;
		
	
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public LocationClass getLocation() {
		return location;
	}
	public void setLocation(LocationClass location) {
		this.location = location;
	}
	public List<String> getType() {
		return type;
	}
	public void setType(List<String> type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	

	
}
