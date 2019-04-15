package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

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
	PastTrips badpastrips = new PastTrips();
	PastTrip test1 = new PastTrip(500, 1000, 180);
	PastTrip test2 = new PastTrip(673, 539, 300);
	PastTrip test3 = new PastTrip(673, 539, 730);

	@Before
	public void setUp() throws Exception {
		Station station1 = new Station(43, "Station 1", new Coord(4.5843, 9.2940));
		Station station2 = new Station(33, "Station 2", new Coord(69.5435, -12.2423));
		Station station3 = new Station(484, "Station 3", new Coord(12.4233, -45.2329));
		stations.addStation(station1);
		stations.addStation(station2);
		stations.addStation(station3);
	}

	@Test
	public void testbaseStations() throws FileNotFoundException {
		Stations testbase = Parser.parseStations("src\\tests\\StationTest.csv");
		assert testbase.getStationByCode(43).getCode() == stations.getStationByCode(43).getCode();
	}

	@Test
	public void testbasePastTrips() throws FileNotFoundException {
		pastrips = Parser.parsePastTrips("src\\tests\\PastTripsTesting");
		assert (test1.getStartCode() == pastrips.getNextPath().get(0).getStartCode());

	}

	@Test(expected = NullPointerException.class)
	public void testbaddirPath() throws FileNotFoundException {
		Parser.parsePastTrips("src\\tests\\badPath");
	}

	@Test(expected = FileNotFoundException.class)
	public void testbadfilePath() throws FileNotFoundException {
		Parser.parseStations("src\\tests\\badPath.csv");

	}

	@Test(expected = FileNotFoundException.class)
	public void testemptyDir() throws FileNotFoundException {
		Parser.parsePastTrips("src\\tests\\testdirPath");
	}

}
