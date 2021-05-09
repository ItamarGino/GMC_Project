package common.entities;

public class Map 
{
	private String MapID;
	private String mapDescription;
	private double price;
	private static int mapWatchQuantity; // Per instance!
	private static int mapDownloadQuantity; // Per instance!
	
	@Override
	public boolean equals(Object obj)
	{
		Map other = (Map) obj;
		if(other.MapID.equals(this.MapID) == true)
			return true;
		return false;
	}
	
	public String getMapID() {
		return MapID;
	}
	public void setMapID(String mapID) {
		MapID = mapID;
	}
	public String getMapDescription() {
		return mapDescription;
	}
	public void setMapDescription(String mapDescription) {
		this.mapDescription = mapDescription;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public static int getMapWatchQuantity() {
		return mapWatchQuantity;
	}
	public static void setMapWatchQuantity(int mapWatchQuantity) {
		Map.mapWatchQuantity = mapWatchQuantity;
	}
	public static int getMapDownloadQuantity() {
		return mapDownloadQuantity;
	}
	public static void setMapDownloadQuantity(int mapDownloadQuantity) {
		Map.mapDownloadQuantity = mapDownloadQuantity;
	}
	
}
