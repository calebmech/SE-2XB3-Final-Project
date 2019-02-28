package bixiTrip;

public class Path extends PastTrip {
	private float duration;
	private int count;

	public Path(PastTrip trip) {
		stationStart = trip.getStationStart();
		stationEnd = trip.getStationEnd();
		duration = trip.getDuration();
		count = 1;
	}

	void addPastTrip(PastTrip trip) {
		duration = (duration * count + trip.getDuration()) / (count + 1);
		count++;
	}

	@Override
	int getDuration() {
		return Math.round(duration);
	}
}