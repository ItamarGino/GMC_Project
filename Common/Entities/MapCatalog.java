package common.entities;

public class MapCatalog extends GenericEntity<MapCollection>
{
	private String cityName;
	private String siteName;
	private String citySiteDescription;
	private int mapQuantity;
	private int siteQuantity;
	private int pathQuantity;
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getCitySiteDescription() {
		return citySiteDescription;
	}
	public void setCitySiteDescription(String citySiteDescription) {
		this.citySiteDescription = citySiteDescription;
	}
	public int getMapQuantity() {
		return mapQuantity;
	}
	public void setMapQuantity(int mapQuantity) {
		this.mapQuantity = mapQuantity;
	}
	public int getSiteQuantity() {
		return siteQuantity;
	}
	public void setSiteQuantity(int siteQuantity) {
		this.siteQuantity = siteQuantity;
	}
	public int getPathQuantity() {
		return pathQuantity;
	}
	public void setPathQuantity(int pathQuantity) {
		this.pathQuantity = pathQuantity;
	}
	
}
