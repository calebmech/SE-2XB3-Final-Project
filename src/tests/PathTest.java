package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bixiTrip.Coord;
import bixiTrip.PastTrip;
import bixiTrip.Path;
import bixiTrip.Station;
import bixiTrip.Stations;

public class PathTest {
	private PastTrip pastTrip1;
	private PastTrip pastTrip2;
	private PastTrip pastTrip3;
	private PastTrip pastTrip4;
	private Path path;

	Coord coord = new Coord(0, 0);
	Station station1 = new Station(123, "station1", coord);
	Station station2 = new Station(456, "station2", coord);
	Stations stations = Stations.getInstance();

	public PathTest() {
		stations.addStation(station1);
		stations.addStation(station2);
	}

	@Before
	public void setUp() throws Exception {
		pastTrip1 = new PastTrip(123, 456, 12);
		pastTrip2 = new PastTrip(123, 456, 18);
		pastTrip3 = new PastTrip(1223, 456, 12);
		pastTrip4 = new PastTrip(0, 0, 0);

		path = new Path(pastTrip1);
	}

	@Test // Basic input
	public void testPathConstructor1() {
		assertEquals(123, path.getStartCode());
	}

	@Test // Zero values
	public void testPathConstructor2() {
		Path path = new Path(pastTrip4);
		assertEquals(0, path.getStartCode());
	}

	@Test // Basic input
	public void testAddPastTrip1() {
		path.addPastTrip(pastTrip2);
		assertEquals(123, path.getStartCode());
	}

	@Test(expected = IllegalArgumentException.class)
	// Test not the same stations
	public void testAddPastTrip2() {
		path.addPastTrip(pastTrip3);
	}

	@Test
	public void testStartIndex() {
		assertEquals(stations.getIndex(123), path.getStartIndex());
	}

	@Test
	public void testEndIndex() {
		assertEquals(stations.getIndex(456), path.getEndIndex());
	}

	@Test // Zero duration
	public void getDuration1() {
		Path path0 = new Path(pastTrip4);
		assertEquals(0, path0.getDuration());
	}

	@Test // Basic input
	public void getDuration2() {
		assertEquals(12, path.getDuration());
	}

	@Test // After add
	public void getDuration3() {
		path.addPastTrip(pastTrip2);
		assertEquals(15, path.getDuration());
	}
}