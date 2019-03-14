package tests;

import org.junit.Test;

import static org.junit.Assert.fail;

import org.junit.Before;

import bixiTrip.PastTrips;
import bixiTrip.PastTrip;

public class PastTripsTest {

	PastTrips pastTrips = new PastTrips();

	@Before
	public void setUp() throws Exception {
		pastTrips = new PastTrips();
		PastTrip test1 = new PastTrip(500, 1000, 180);
		PastTrip test2 = new PastTrip(673, 539, 300);
		PastTrip test3 = new PastTrip(5743, 599, 730);
		pastTrips.addTrip(test1);
		pastTrips.addTrip(test2);
		pastTrips.addTrip(test3);
	}

	@Test
	public void testGetInstance() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddTrip() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNextPath() {
		assert pastTrips.getNextPath() == [500,1000,180];
	}

	@Test
	public void testInitialize() {
		fail("Not yet implemented");
		
	}
}
