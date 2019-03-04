package bixiTrip;
/**
 * 
 * @author hdmah
 *
 */
public class Coord {
	private final double longitude;
	private final double latitude;

	public Coord(double _longitude, double _latitude) {
		this.longitude = _longitude;
		this.latitude = _latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}
}
