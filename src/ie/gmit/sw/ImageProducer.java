package ie.gmit.sw;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * ImageProducer class adds to the queue. It won't try to put more images to the queue if it's full.
 * The Max Capacity of the queue is specified in the Runner class. @See #Runner
 * Inside the run method new Task is created which is added to the queue.
 * <p>
 * After that, the applyFilter method is invoked.
 */

public class ImageProducer implements Runnable {
	
	private int count =0;
	private BlockingQueue<Task> que;
	private ArrayList<ImageDescription> images;
	
	ImageScanner s = new ImageScanner();
	
	public ImageProducer(BlockingQueue<Task> q) {
		super();
		this.que = q;
		images = s.getImages();
	}
	
	@Override
	public void run() {
		while(images.size() > count) {
			
			Task t = new Task(count, images.get(count)); // create new task with the counter
			System.out.println("[¬] Added image> \n "+t);
			System.out.println(images.get(count).imgName);
			try {
				que.put(t); //blocking method
				t.applyFilter();
			}catch (Exception e) {
				e.printStackTrace();
			}
			count++;
			
		} //while
		
		try {
			que.put(new Poison(-1, images.get(count-1)));
		} catch (InterruptedException e ) {
			e.printStackTrace();
		}
		
	}

}
