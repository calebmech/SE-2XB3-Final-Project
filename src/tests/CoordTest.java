package tests;

/** 
 * Test class for the Coord abstract data type.
 * 
 * @author Harsh Mahajan
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bixiTrip.Coord;
import bixiTrip.Station;

public class CoordTest {
	// create some test objects
	Coord coord1 = new Coord(43.2609, -79.9192);
	Coord coord2 = new Coord(-20.2984, 0.5748);

	@Test
	public void testLongitude() {
		assert coord1.getLong() == -79.9192;
		assert coord2.getLong() == 0.5748;
	}

	@Test
	public void testLatitude() {
		assert coord1.getLat() == 43.2609;
		assert coord2.getLat() == -20.2984;
	}
}
