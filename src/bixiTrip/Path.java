package bixiTrip;

public class Path extends PastTrip {
	private float duration;
	private int count;

	public Path(PastTrip _trip) {
		super(_trip.getStationStart(), _trip.getStationEnd(), 0);
		this.duration = _trip.getDuration();
		count = 1;
	}

	public void addPastTrip(PastTrip trip) {
		duration = (duration * count + trip.getDuration()) / (count + 1);
		count++;
	}

	@Override
	public int getDuration() {
		return Math.round(duration);
	}
}