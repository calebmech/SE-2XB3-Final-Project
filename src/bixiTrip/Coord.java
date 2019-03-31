package bixiTrip;

/**
 * This class initializes the coordinates of the stations.
 * 
 * @author Harsh Mahajan
 *
 */
public class Coord {
	private final double longitude;
	private final double latitude;

	/**
	 * Constructor that assigns the longitude and latitude to the respective station
	 * object.
	 * 
	 * The values of Latitudes and Longitudes are in Degrees.
	 * 
	 * +ve Longitude values mean the number of degrees east of the Prime Meridian
	 * and west for -ve values. +ve Latitude values mean the number of degrees north
	 * of the Equator and south for -ve values.
	 * 
	 * @param _long Longitude of coordinate
	 * @param _lat  Latitude of coordinate
	 */
	public Coord(double _lat, double _long) {
		this.longitude = _long;
		this.latitude = _lat;
	}

	/**
	 * Accessor function for the Longitude.
	 * 
	 * @return Longitude of coordinate
	 */
	public double getLong() {
		return longitude;
	}

	/**
	 * Accessor function for the Latitude.
	 * 
	 * @return Latitude of coordinate
	 */
	public double getLat() {
		return latitude;
	}

	/**
	 * Converts coordinate to string
	 * 
	 * @return String representation of coordinate
	 */
	public String toString() {
		return getLat() + "," + getLong();
	}
}
