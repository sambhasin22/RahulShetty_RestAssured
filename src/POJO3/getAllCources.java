package POJO3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class getAllCources {
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	
	private String instructor;
	private String url;
	private String services;
	private String experties;
	private Cources cources;
	private String linkedin;
		
	
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExperties() {
		return experties;
	}
	public void setExperties(String experties) {
		this.experties = experties;
	}
	public Cources getCources() {
		return cources;
	}
	public void setCources(Cources cources) {
		this.cources = cources;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
