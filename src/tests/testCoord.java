package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bixiTrip.Coord;
import bixiTrip.Station;

public class testCoord {
	// create some test objects
		Coord coord1 = new Coord(43.2609, -79.9192);
		Coord coord2 = new Coord(-20.2984, 0.5748);
		Station test1 = new Station(3056, "Station 1", coord1);
		Station test2 = new Station(5049, "Station 2", coord2);
	

	@Test
<<<<<<< HEAD
	public void testLogitude() {
		assert coord1.getLong() == -79.9192;
		assert coord2.getLong() == 0.5748;
=======
	public void testLongitude() {
		assert coord1.getLong() == 43.2609;
		assert coord2.getLong() == -20.2984;
>>>>>>> 762377b62b8099ec921a40f724a8b0045cadf986
	}
	
	@Test
	public void testLatitude() {
<<<<<<< HEAD
		assert coord1.getLat() == 43.2609;
		assert coord2.getLat() == -20.2984;
=======
		assert coord1.getLat() == -79.9192;
		assert coord2.getLat() == 0.5748;
>>>>>>> 762377b62b8099ec921a40f724a8b0045cadf986
	}
}
