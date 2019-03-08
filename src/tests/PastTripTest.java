package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bixiTrip.PastTrip;

/**
 * Class that is used to test the different functions in the PastTrip.java
 * module
 * 
 * @author Matthew Braden
 *
 */
public class PastTripTest {

	PastTrip test1 = new PastTrip(500, 1000, 180);
	PastTrip test2 = new PastTrip(673, 539, 300);
	PastTrip test3 = new PastTrip(400, 680, 730);

	@Test
	public void testGetStationStart() {
		assert test1.getStationStart() == 500;
	}

	@Test
	public void testGetStationStart2() {
		assert test2.getStationStart() == 673;
	}

	@Test
	public void testGetStationEnd1() {
		assert test1.getStationEnd() == 1000;
	}

	@Test
	public void testGetStationEnd2() {
		assert test2.getStationEnd() == 539;
	}

	@Test
	public void testGetDuration1() {
		assert test1.getDuration() == 180;
	}

	@Test
	public void testGetDuration2() {
		assert test2.getDuration() == 300;
	}

}
