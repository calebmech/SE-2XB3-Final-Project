package tests;

/** 
 * Test suite for all internal test classes.
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PastTripTest.class, PathTest.class, StationsTest.class, StationTest.class })
public class AllTests {

}
