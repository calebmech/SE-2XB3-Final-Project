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
		//setup a new Stations object to do tests on
		stations = new Stations();
		Station station1 = new Station(43, "Station 1", new Coord(4.5843, 9.2940));
		Station station2 = new Station(33, "Station 2", new Coord(69.5435, -12.2423));
		Station station3 = new Station(484, "Station 3", new Coord(12.4233, -45.2329));
		stations.addStation(station1);
		stations.addStation(station2);
		stations.addStation(station3);
	}
	
	//case1 where station is present
	@Test
	public void testGetStation1() {
		assert stations.getStation(43).getCode() == 43;
	}
	
	//case2 where station is present
	@Test
	public void testGetStation2() {
		assert stations.getStation(484).getCode() == 484;
	}
	
	//case3 where station is not present
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testGetStation3() {
		stations.getStation(11);
	}
	
	//general test case to ensure stations are returned properly
	@Test
	public void testGetStations() {
		ArrayList<Station> out = stations.getStations();
		Integer[] expected = {33, 43, 484};
		for (int i = 0; i < out.size(); i++) {
			assert (out.get(i).getCode() - expected[i] == 0);
		}
	}

}
