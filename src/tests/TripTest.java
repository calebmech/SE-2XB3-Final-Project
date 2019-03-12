package tests;

import org.junit.Test;

import bixiTrip.Coord;
import bixiTrip.PastTrip;
import bixiTrip.Path;
import bixiTrip.Paths;
import bixiTrip.Station;
import bixiTrip.Stations;
import bixiTrip.Trip;

public class TripTest {
	private Stations stations;
	private Station station1;
	private Station station2;
	private Station station3;
	private Station station4;
	private Station station5;
	private Station station6;
	private Coord coord = new Coord(0, 0);

	public TripTest() {
		stations = Stations.getInstance();
		station1 = new Station(1, "station1", coord);
		station2 = new Station(2, "station2", coord);
		station3 = new Station(3, "station3", coord);
		station4 = new Station(4, "station4", coord);
		station5 = new Station(5, "station5", coord);
		station6 = new Station(6, "station6", coord);
		stations.addStation(station1);
		stations.addStation(station2);
		stations.addStation(station3);
		stations.addStation(station4);
		stations.addStation(station5);
		stations.addStation(station6);

		Paths paths = Paths.getInstance();
		paths.addPath(new Path(new PastTrip(1, 2, 5)));
		paths.addPath(new Path(new PastTrip(2, 3, 5)));
//		paths.addPath(new Path(new PastTrip(1, 3, 1)));
		paths.addPath(new Path(new PastTrip(3, 4, 3)));
		paths.addPath(new Path(new PastTrip(4, 5, 1)));
		paths.addPath(new Path(new PastTrip(5, 6, 1)));
	}

//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@Test
//	public void testTrip() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetRoute() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetDuration() {
		Trip trip = new Trip(station1, station6);
//		trip.getRoute();
		System.out.println(trip.getUrl());
//		System.out.println(trip.getDuration());
	}

//	@Test
//	public void testGetUrl() {
//		fail("Not yet implemented");
//	}

}
