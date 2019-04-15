/**
 * Implements Parser Class
 * Reads data from inputted CSVs
 * Creates appropriate abstract objects
 * 
 * @author Meghan Mazer
 *
 * March 11/2019
 *
 */

package bixiTrip;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {

	/**
	 * Parse CSV of past trips information
	 * 
	 * @param dirPath inputed directory path
	 * @return object containing past trips data
	 * @throws FileNotFoundException Throws exception if file does not exist.
	 */
	public static PastTrips parsePastTrips(String dirPath) throws FileNotFoundException {

		// Get instance/any previous instance of pastTrips object
		PastTrips pastTrips = PastTrips.getInstance();

		// List of files within provided directory path
		File folder = new File(dirPath);
		File[] listOfFiles = folder.listFiles();
		if (listOfFiles.length == 0)
			throw new FileNotFoundException("Empty folder.");
		for (File file : listOfFiles) {
			if (file.isFile()) {
				try {
//					if (file == listOfFiles[0])
//						System.out.print("Importing ");
//					System.out.print(file.getName() + (file == listOfFiles[listOfFiles.length - 1] ? ". " : ", "));
					Scanner input = new Scanner(file);
					if (input.hasNextLine())
						input.nextLine();

					// Read each line of the file and split by comma regex
					while (input.hasNext()) {
						String trip = input.nextLine();
						String[] tempArray = trip.split(",");

						// Local variables to store attributes of each trip
						int startStation = Integer.parseInt(tempArray[1]);
						int endStation = Integer.parseInt(tempArray[3]);
						int duration = Integer.parseInt(tempArray[4]);

						// Add a past trip to past trips object
						pastTrips.addTrip(new PastTrip(startStation, endStation, duration));

					}
					input.close();
				}

				// Catch block
				catch (FileNotFoundException e) {
					throw e;
				}
			}
		}

		return pastTrips;
	}

	/**
	 * Parse CSV of station information
	 * 
	 * @param filePath inputted file path
	 * @return object containing station data
	 * @throws FileNotFoundException Throws exception if file does not exist.
	 */
	public static Stations parseStations(String filePath) throws FileNotFoundException {

		// Get instance/any previous instance of stations object
		Stations stations = Stations.getInstance();

		File file = new File(filePath);

		try {
			Scanner input = new Scanner(file);
			input.nextLine();

			// Read each line of the file and split by comma regex
			while (input.hasNext()) {
				String station = input.nextLine();
				String[] tempArray1 = station.split(",");

				// Local variables to store attributes of each station
				int code = Integer.parseInt(tempArray1[0]);

				String name = tempArray1[1];

				double latitude = Double.parseDouble(tempArray1[2]);
				double longitude = Double.parseDouble(tempArray1[3]);
				Coord coords = new Coord(latitude, longitude);

				// Add a station to stations object
				stations.addStation(new Station(code, name, coords));
			}
			input.close();
		}

		// Catch block
		catch (FileNotFoundException e) {
			throw e;
		}
		return stations;
	}
}
