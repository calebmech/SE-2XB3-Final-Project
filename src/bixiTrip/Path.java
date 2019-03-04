package bixiTrip;

public class Path extends PastTrip {
	private float duration;
	private int count;

	public Path(PastTrip _trip) {
		stationStart = _trip.getStationStart();
		stationEnd = _trip.getStationEnd();
		duration = _trip.getDuration();
		count = 1;
	}

	void addPastTrip(PastTrip _trip) {
		duration = (duration * count + _trip.getDuration()) / (count + 1);
		count++;
	}

	@Override
	int getDuration() {
		return Math.round(duration);
	}
}