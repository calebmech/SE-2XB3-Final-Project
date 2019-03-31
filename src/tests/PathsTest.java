package tests;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import bixiTrip.Coord;
import bixiTrip.PastTrip;
import bixiTrip.Path;
import bixiTrip.Paths;
import bixiTrip.Station;
import bixiTrip.Stations;

public class PathsTest {
	private Stations stations;
	private Coord coord = new Coord(0, 0);

	public PathsTest() {
		stations = Stations.getInstance();
		for (int i = 0; i < 6; i++) {
			Station station = new Station(i, "station" + i, coord);
			stations.addStation(station);
		}

		Paths paths = Paths.getInstance();
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
		fail("Not yet implemented");
	}

	@Test
	public void testAddPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testImportPastTrips() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGraph() {
		fail("Not yet implemented");
	}

}
