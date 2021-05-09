package common.entities;

public class Tour 
{
	private String name;
	private String tdescription;
	private boolean recommanded;
	private double length;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTdescription() {
		return tdescription;
	}
	public void setTdescription(String tdescription) {
		this.tdescription = tdescription;
	}
	public boolean isRecommanded() {
		return recommanded;
	}
	public void setRecommanded(boolean recommanded) {
		this.recommanded = recommanded;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	
}
