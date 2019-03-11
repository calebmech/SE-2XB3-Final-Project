package bixiTrip;

/**
 * A class representing the Station abstract data type.
 * 
 * @author Jonathan Janzen
 *
 */

public class Station implements Comparable<Station> {
	private final Integer code;
	private final String name;
	private final Coord coords;

	/**
	 * Constructor for a new Station object.
	 * 
	 * @param _code   Integer representing the station code.
	 * @param _name   String representing the station's name.
	 * @param _coords Coord representing the coordinates of the station.
	 */
	public Station(int _code, String _name, Coord _coords) {
		this.code = _code;
		this.name = _name;
		this.coords = _coords;
	}

	/**
	 * Getter for the station's code.
	 * 
	 * @return Returns station's code as an integer.
	 */
	public int getCode() {
		return this.code;
	}

	/**
	 * Getter for the name of the station.
	 * 
	 * @return Returns station's name as a string.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Getter for the coordinates of the station.
	 * 
	 * @return Returns station's coordinates as type coord.
	 */
	public Coord getCoords() {
		return this.coords;
	}

	/**
	 * A function to implement the Comparable interface to the Station data type.
	 * 
	 * @param that A Station object to be compared to the local object.
	 * @return Returns an integer 1 if the object's code is greater than that, -1 if
	 *         it is less and 0 if they are the same.
	 */
	@Override
	public int compareTo(Station that) {
		return (this.code).compareTo(that.getCode());
	}

}
