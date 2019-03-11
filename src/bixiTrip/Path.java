package bixiTrip;

/**
 * Class representing the Path abstract data type.
 * 
 * @author Caleb Mech
 *
 */

public class Path extends PastTrip {
	private float duration;
	private int count;
	private Stations stations;

	/**
	 * Constructor for a new Path object.
	 * 
	 * @param _trip	PastTrip object to base the Path on.
	 */
	public Path(PastTrip _trip) {
		super(_trip.getStationStart(), _trip.getStationEnd(), 0);
		this.duration = _trip.getDuration();
		this.stations = Stations.getInstance();
		count = 1;
	}

	/**
	 * Recalculate the average duration for the Path
	 * by adding another PastTrip.
	 * 
	 * @param trip PastTrip object with the same start and end.
	 */
	public void addPastTrip(PastTrip trip) {
		duration = (duration * count + trip.getDuration()) / (count + 1);
		count++;
	}
	
	/**
	 * Getter for the index of the start station in the Stations object.
	 * 
	 * @return Returns start station index as an int.
	 */
	public int getStartIndex() {
		return stations.getIndex(stationStart);
	}
	
	/**
	 * Getter for the index of the end station in the Stations object.
	 * 
	 * @return Returns end station index as an int.
	 */
	public int getEndIndex() {
		return stations.getIndex(stationEnd);
	}

	/**
	 * Getter for the average duration of traveling the Path.
	 * 
	 * @return Returns average duration as an int.
	 */
	@Override
	public int getDuration() {
		return Math.round(duration);
	}
}