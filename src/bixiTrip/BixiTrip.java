package bixiTrip;

/**
 * The main implementation of BixiTrip.
 * 
 * @author Jonathan Janzen
 *
 */

public class BixiTrip {
	
	private static void longLine() {
		System.out.println("-----------------------------------------------------------");
	}
	
	/**
	 * Main function for BixiTrip.
	 * 
	 * @param args First argument represents start station code, second represents
	 *             end station code.
	 */
	public static void main(String args[]) {
		Station start, end;
		Integer startCode, endCode;
		Trip mainTrip;
		String url;
		Paths paths;

		// read input codes
		try {
			startCode = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println(
					"ERROR: Station Start code could not be parsed properly. Please correct input and try again.");
			return;
		}

		try {
			endCode = Integer.parseInt(args[1]);
		} catch (Exception e) {
			System.out.println(
					"ERROR: Station End code could not be parsed properly. Please correct input and try again.");
			return;
		}

		// initialize PastTrips and Stations abstract objects
		Stations stations = new Stations();
		PastTrips pastTrips = new PastTrips();

		System.out.println("Welcome to BixiTrip. Please wait while we import our data...");
		longLine();

		// read data from files
		stations = Parser.parseStations("stations\\Stations_2018.csv");
		System.out.println("Stations imported successfully.");
		pastTrips = Parser.parsePastTrips("pastTrips");
		System.out.println("Past trips imported successfully.");
		System.out.println("Data import successful.");
		longLine();

		//calculate paths
		System.out.println("Converting past trips to paths...");
	    paths = Paths.getInstance();
	    paths.importPastTrips();
	    System.out.println("Conversion successful.");
	    longLine();
	    
		// define start and end stations
		System.out.println("Parsing stations from input...");
		try {
			start = stations.getStationByCode(startCode);
		} catch (Exception e) {
			System.out.println("ERROR: Start station could not be found in station list.");
			return;
		}
		System.out.println("Start station '" + start.getName() + "' found successfully.");

		try {
			end = stations.getStationByCode(endCode);
		} catch (Exception e) {
			System.out.println("ERROR: End station could not be found in station list.");
			return;
		}
		System.out.println("End station '" + end.getName() + "' found successfully.");
		longLine();

		mainTrip = new Trip(start, end);
		System.out.println("Finding best route from " + start.getName() + " to " + end.getName() + "...");
		url = mainTrip.getUrl();
		System.out.println();
		System.out.println("Your trip will take an estimated" + mainTrip.getDuration() + "minutes in total.");
		System.out.println("Here is your Google Maps trip URL:" + url);
	}

}
