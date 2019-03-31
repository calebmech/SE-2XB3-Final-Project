package tests;

import org.junit.Test;

import java.util.ArrayList;

import org.junit.Before;

import bixiTrip.PastTrips;
import bixiTrip.PastTrip;

public class PastTripsTest {

	PastTrips pastTrips = new PastTrips();
	PastTrips newTrips2 = new PastTrips();
	PastTrips pastTrips2 = new PastTrips();

	@Before
	public void setUp() throws Exception {
		pastTrips = new PastTrips();
		pastTrips2 = new PastTrips();
		PastTrip test1 = new PastTrip(500, 1000, 180);
		PastTrip test2 = new PastTrip(673, 539, 300);
		PastTrip test3 = new PastTrip(5743, 599, 730);
		pastTrips.addTrip(test1);
		pastTrips.addTrip(test2);
		pastTrips.addTrip(test3);
		pastTrips2.addTrip(test2);
		pastTrips2.addTrip(test1);
		pastTrips2.addTrip(test3);
	}

	@Test
	public void testGetNextPathStart() {
		assert (pastTrips.getNextPath().get(0).getStartCode() == 500);
	}

	@Test
	public void testGetNextPathStart2() {
		pastTrips2.getNextPath();
		assert (pastTrips2.getNextPath().get(0).getStartCode() == 673);
	}

	@Test
	public void testGetNextPathEnd() {
		assert (pastTrips.getNextPath().get(0).getEndCode() == 1000);
	}

	@Test
	public void testGetNextPathEnd2() {
		pastTrips2.getNextPath();
		assert (pastTrips2.getNextPath().get(0).getEndCode() == 539);
	}

	@Test
	public void testGetNextPathDuration() {
		assert (pastTrips.getNextPath().get(0).getDuration() == 180);
	}

	@Test
	public void testGetNextPathDuration2() {
		pastTrips2.getNextPath();
		assert (pastTrips2.getNextPath().get(0).getDuration() == 300);
	}
}
