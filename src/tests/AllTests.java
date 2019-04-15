package tests;

/** 
 * Test suite for all internal test classes.
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CoordTest.class, PastTripTest.class, PastTripsTest.class, PathsTest.class, PathTest.class,
		StationTest.class, StationsTest.class, ParserTest.class, })
public class AllTests {

}
