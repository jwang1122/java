package algorithms.chapter3;

public class StopWatch {
	long start;
	long stop;
	double duration;
	
	public void start() {
		start = System.currentTimeMillis();
	}
	
	/**
	 * @return return duration in seconds.
	 */
	public double stop() {
		stop = System.currentTimeMillis();
		duration = (stop-start)/60000.0;
		return duration;
	}

}
