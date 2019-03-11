package tests;

/** 
 * Testing class for the Stations object.
 * 
 * @author Jonathan Janzen
 */
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import bixiTrip.Coord;
import bixiTrip.Station;
import bixiTrip.Stations;

import org.junit.After;
import org.junit.Before;

public class StationsTest {

	Stations stations = new Stations();

	@Before
	public void setUp() throws Exception {
		// setup a new Stations object to do tests on
		stations = new Stations();
		Station station1 = new Station(43, "Station 1", new Coord(4.5843, 9.2940));
		Station station2 = new Station(33, "Station 2", new Coord(69.5435, -12.2423));
		Station station3 = new Station(484, "Station 3", new Coord(12.4233, -45.2329));
		stations.addStation(station1);
		stations.addStation(station2);
		stations.addStation(station3);
	}

	// case1 where station is present
	@Test
	public void testGetStation1() {
		assert stations.getStationByCode(43).getCode() == 43;
	}

	// case2 where station is present
	@Test
	public void testGetStation2() {
		assert stations.getStationByCode(484).getCode() == 484;
	}

	// case3 where station is not present
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testGetStation3() {
		stations.getStationByCode(11);
	}

	// general test case to ensure stations are returned properly
	@Test
	public void testGetStations() {
		ArrayList<Station> out = stations.getStations();
		Integer[] expected = { 33, 43, 484 };
		for (int i = 0; i < out.size(); i++) {
			assert (out.get(i).getCode() - expected[i] == 0);
		}
	}

	// general test 1 for getIndex
	@Test
	public void testGetStationByIndex1() {
		assert stations.getStationByIndex(1).getCode() == 43;
	}

	// general test 2 for getIndex
	@Test
	public void testGetStationByIndex2() {
		assert stations.getStationByIndex(2).getCode() == 484;
	}

	// case where index value does not exist
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetStationByIndex3() {
		stations.getStationByIndex(3);
	}

	// general test 1 for getIndex
	@Test
	public void testGetIndex1() {
		assert stations.getIndex(33) == 0;
	}

	// case where index value does not exist
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetIndex2() {
		stations.getIndex(-1);
	}

}
