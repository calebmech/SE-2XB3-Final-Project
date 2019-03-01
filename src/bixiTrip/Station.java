package bixiTrip;

/**
 * A class representing the Station abstract data type.
 * 
 * @author Jonathan Janzen
 *
 */

public class Station {
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
	public Station(Integer _code, String _name, Coord _coords) {
		this.code = _code;
		this.name = _name;
		this.coords = _coords;
	}

	/**
	 * Getter for the station's code.
	 * 
	 * @return Returns station's code as an integer.
	 */
	private Integer getCode() {
		return this.code;
	}

	/**
	 * Getter for the name of the station.
	 * 
	 * @return Returns station's name as a string.
	 */
	private String getName() {
		return this.name;
	}

	/**
	 * Getter for the coordinates of the station.
	 * 
	 * @return Returns station's coordinates as type coord.
	 */
	private Coord getCoords() {
		return this.coords;
	}

}
