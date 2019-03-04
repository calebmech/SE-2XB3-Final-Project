package tests;

/** 
 * A test class for the Station module/data type.
 * 
 * @author Jonathan Janzen
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bixiTrip.Coord;
import bixiTrip.Station;

public class StationTest {

	// create some test objects
	Coord coord1 = new Coord(43.2609, -79.9192);
	Coord coord2 = new Coord(-20.2984, 0.5748);
	Coord coord3 = new Coord(-3.1415, 9.2677);
	Station test1 = new Station(3056, "Station 1", coord1);
	Station test2 = new Station(5049, "Station 2", coord2);
	Station test3 = new Station(1, "Station 3", coord3);

	@Test
	public void testGetCode1() {
		assert test1.getCode() == 3056;
	}

	@Test
	public void testGetCode2() {
		assert test2.getCode() == 5049;
	}

	@Test
	public void testGetName1() {
		assert test1.getName().equals("Station 1");
	}

	@Test
	public void testGetName2() {
		assert test2.getName().equals("Station 2");
	}

	@Test
	public void testGetCoords1() {
		assert test1.getCoords() == coord1;
	}

	@Test
	public void testGetCoords2() {
		assert test2.getCoords() == coord2;
	}

	@Test
	public void testCompareTo1() {
		assert test1.compareTo(test2) == -1;
	}

	@Test
	public void testCompareTo2() {
		assert test2.compareTo(test3) == 1;
	}

}
