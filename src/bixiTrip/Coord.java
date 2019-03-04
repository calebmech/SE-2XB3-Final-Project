package bixiTrip;

/**
 * This class initializes the co-ordinates of the stations.
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
	 * @param _longitude
	 * @param _latitude
	 */
	public Coord(double _longitude, double _latitude) {
		this.longitude = _longitude;
		this.latitude = _latitude;
	}

	/**
	 * Accessor function for the Longitude.
	 * 
	 * @return
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Accessor function for the Latitude.
	 * 
	 * @return
	 */
	public double getLatitude() {
		return latitude;
	}
}
