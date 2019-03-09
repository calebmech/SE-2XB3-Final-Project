package bixiTrip;

public class Parser {
	
	
	public PastTrips parsePastTrips(String dirPath) {
		//temporary for writing the main function
		//assume that a PastTrips object has been created already
		PastTrips pastTrips = PastTrips.getInstance();
		return pastTrips;
	}
	
	public Stations parseStations(String filePath) {
		//temporary for writing the main function
		//assume that a Stations object has been created already
		Stations stations = Stations.getInstance();
		return stations;
	}
}
