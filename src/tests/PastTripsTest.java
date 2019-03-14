package tests;

import org.junit.Test;

import java.util.ArrayList;

import org.junit.Before;

import bixiTrip.PastTrips;
import bixiTrip.PastTrip;

public class PastTripsTest {

	PastTrips pastTrips = new PastTrips();
	PastTrips newTrips2 = new PastTrips();
	
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
	public void testGetNextPathAndAddTrip() {
		ArrayList<PastTrip> newTrip = new ArrayList<PastTrip>();
		PastTrip test1 = new PastTrip(500, 1000, 180);
		newTrip.add(test1);
		assert pastTrips.getNextPath() == newTrip;
	}
}
