package ie.gmit.sw;

/**
 * Poison class which inherits from Task class interrupt both producer and reducer threads.
 * Producer puts a 'poison' into the queue and exit and when Reducer sees the 'poison'
 * then it stops and exits.
 * Class contains a constructor where we pass the image and the negative value to stop the queue
 * @param t negative value to 'poison the queue' and stop it.
 * @param img Buffered Image
 */

public class Poison extends Task {
	
	public Poison(int t, ImageDescription img) {
		super(t, img);
	}

}
