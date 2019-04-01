package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import bixiTrip.Coord;
import bixiTrip.PastTrip;
import bixiTrip.PastTrips;
import bixiTrip.Path;
import bixiTrip.Paths;
import bixiTrip.Station;
import bixiTrip.Stations;

public class PathsTest {
	private Stations stations;
	private Coord coord = new Coord(0, 0);
	private Paths paths;

	public PathsTest() {
		stations = Stations.getInstance();
		for (int i = 0; i < 6; i++) {
			Station station = new Station(i, "station" + i, coord);
			stations.addStation(station);
		}

		paths = Paths.getInstance();
		paths.addPath(new Path(new PastTrip(1, 2, 5)));
		paths.addPath(new Path(new PastTrip(2, 3, 5)));
		paths.addPath(new Path(new PastTrip(1, 3, 1)));
		paths.addPath(new Path(new PastTrip(4, 5, 3)));
		paths.addPath(new Path(new PastTrip(5, 3, 1)));
		paths.addPath(new Path(new PastTrip(5, 6, 1)));
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetInstance() {
		assertTrue(paths instanceof Paths);
	}

	@Test
	public void testAddPath() {
		paths.addPath(new Path(new PastTrip(6, 7, 67)));
		assertEquals(67, paths.getPath(6, 7).getDuration());
	}
	
	@Test
	public void testGetPath() {
		assertEquals(3, paths.getPath(4, 5).getDuration());
	}

	@Test
	public void testImportPastTrips() {
		PastTrips pastTrips = PastTrips.getInstance();
		pastTrips.addTrip(new PastTrip(10, 11, 25));
		pastTrips.addTrip(new PastTrip(10, 11, 75));
		pastTrips.addTrip(new PastTrip(12, 13, 20));
		
		paths.importPastTrips();
		
		assertEquals(50, paths.getPath(10, 11).getDuration());
		assertEquals(20, paths.getPath(12, 13).getDuration());
	}

	@Test
	public void testGetGraph() {
		assertEquals(10003, paths.getGraph().V());
	}

}
