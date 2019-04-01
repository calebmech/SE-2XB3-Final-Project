package bixiTrip;

/**
 * 
 * Class that looks at compares past trips
 * 
 * @author Matthew Braden
 */
public class PastTrip implements Comparable<PastTrip> {
	protected final int startCode;
	protected final int endCode;
	private final int duration;

	/**
	 * Function that stores the past trips results
	 * 
	 * @param _startCode Station start code
	 * @param _endCode   Station end code
	 * @param _duration  Duration of the trip
	 */
	public PastTrip(int _startCode, int _endCode, int _duration) {
		this.startCode = _startCode;
		this.endCode = _endCode;
		this.duration = _duration;
	}

	/**
	 * Function that returns the starting station
	 * 
	 * @return The start station
	 */
	public int getStartCode() {
		return this.startCode;
	}

	/**
	 * Function that returns the ending station
	 * 
	 * @return The end station
	 */
	public int getEndCode() {
		return this.endCode;
	}

	/**
	 * Function that return the duration of the trip
	 * 
	 * @return The duration of the trip
	 */
	public int getDuration() {
		return this.duration;
	}

	/**
	 * Function that compares different trips
	 * 
	 * @param trip A seperate trip
	 * @return A boolean of the compared trips
	 */
	@Override
	public int compareTo(PastTrip trip) {
		int start = Integer.compare(this.getStartCode(), trip.getStartCode());
		if (start == 0) {
			return Integer.compare(this.getEndCode(), trip.getEndCode());
		} else {
			return start;
		}
	}
}
