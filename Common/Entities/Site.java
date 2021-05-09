package common.entities;

public class Site 
{
	private String name;
	private String location;
	private String catagory;
	private String sdescription;
	private boolean accessibility;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public String getSdescription() {
		return sdescription;
	}
	public void setSdescription(String sdescription) {
		this.sdescription = sdescription;
	}
	public boolean getAccessibility() {
		return accessibility;
	}
	public void setAccessibility(boolean accessibility) {
		this.accessibility = accessibility;
	}
}
