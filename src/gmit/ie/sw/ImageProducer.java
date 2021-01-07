package gmit.ie.sw;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class ImageProducer implements Runnable {
	
	private int count =0;
	private BlockingQueue<Task> que;
	private ArrayList<ImageDetails> images;
	
	ImageScanner s = new ImageScanner();
	
	public ImageProducer(BlockingQueue<Task> q) {
		super();
		this.que = q;
		images = s.getImages();
	}
	
	@Override
	public void run() {
		while(images.size() > count) {
			
			Task t = new Task(count, images.get(count));
			System.out.println("[¬] Adding images> \n "+t);
			System.out.println(images.get(count).imgName);
			try {
				que.put(t);
				t.startImageFilter();
			}catch (Exception e) {
				e.printStackTrace();
			}
			count++;
			
		} //while
		
		try {
			que.put(new Poison(-1, images.get(count-1))  );
		} catch (InterruptedException e ) {
			e.printStackTrace();
		}
		
	}

}
