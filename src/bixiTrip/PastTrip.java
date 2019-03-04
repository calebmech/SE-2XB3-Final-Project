package bixiTrip;

/**
 * 
 * Class that looks at compares past trips
 * 
 * @author Matthew Braden
 */
public class PastTrip implements Comparable<PastTrip> {
    protected int stationStart;
    protected int stationEnd;
    private int duration;

    /**
     * Function that stores the past trips results
     * 
     * @param stationStart
     * @param stationEnd
     * @param duration
     */
    public PastTrip(int stationStart, int stationEnd, int duration){
        this.stationStart = stationStart;
        this.stationEnd = stationEnd;
        this.duration = duration;
    }

    /**
     * Function that returns the starting station
     * 
     * @return The start station
     */
    public int getStationStart(){
        return stationStart;
    }

    /**
     * Function that returns the ending station
     * 
     * @return The end station
     */
    public int getStationEnd(){
        return stationEnd;
    }

    /**
     * Function that return the duration of the trip
     * 
     * @return The duration of the trip
     */
    public int getDuration(){
        return duration;
    }

    /**
     * Function that compares different trips
     * 
     * @param trip A seperate trip
     * @return A boolean of the compared trips
     */
    @Override
    public int compareTo(PastTrip trip){
        int start = Integer.compare(this.getStationStart(), trip.getStationStart());
        if (start == 0) {
        	return Integer.compare(this.getStationEnd(), trip.getStationEnd());
        } else {
        	return start;
        }
    }
}
