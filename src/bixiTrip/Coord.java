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
	 * @param _longitude Longitude of coordinate
	 * @param _latitude Latitude of coordinate
	 */
	public Coord(double _longitude, double _latitude) {
		this.longitude = _longitude;
		this.latitude = _latitude;
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
