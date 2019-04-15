package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bixiTrip.*;

/**
 * Class used to test file and directory reading from Parser.java module
 * 
 * @author Meghan Mazer
 *
 */

public class ParserTest {
	
	Stations stations = new Stations();
	PastTrips pastrips = new PastTrips();
	@Before
	public void setUp() throws Exception {
		Station station1 = new Station(43, "Station 1", new Coord(4.5843, 9.2940));
		Station station2 = new Station(33, "Station 2", new Coord(69.5435, -12.2423));
		Station station3 = new Station(484, "Station 3", new Coord(12.4233, -45.2329));
		stations.addStation(station1);
		stations.addStation(station2);
		stations.addStation(station3);
		
		PastTrip test1 = new PastTrip(500, 1000, 180);
		PastTrip test2 = new PastTrip(673, 539, 300);
		PastTrip test3 = new PastTrip(673, 539, 730);
		pastrips.addTrip(test1);
		pastrips.addTrip(test2);
		pastrips.addTrip(test3);
		
		
	}

	
	@Test
	public void testbaseStations() {
		Stations testbase = Parser.parseStations("src\\tests\\StationTest.csv");
		assert testbase.getStationByCode(43).getCode() == stations.getStationByCode(43).getCode();
	}
	
	@Test
	public void testbasePastTrips() {
		PastTrips testbasetrips = new PastTrips();
		testbasetrips = Parser.parsePastTrips("src\\tests\\PastTripsTest.csv");
		System.out.println(testbasetrips.getNextPath().get(1).getStartCode());
		System.out.println(pastrips.getNextPath().get(1).getStartCode());
		//assert testbasetrips.getNextPath().get(1).getStartCode() == pastrips.getNextPath().get(1).getStartCode();

	}
}
