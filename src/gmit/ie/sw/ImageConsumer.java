package gmit.ie.sw;

import java.util.concurrent.BlockingQueue;

public class ImageConsumer implements Runnable {
	
	private BlockingQueue<Task> que;
	
	private boolean isRunning = true;
	
	//private ArrayList<ImageDetails> imagesDetails;
	
	
	public ImageConsumer(BlockingQueue<Task>q) {
		super();
		this.que = q;
		
	}

	@Override
	public void run() {
		while(isRunning) {
			
			try {
				Task t = que.take();
				
				if(t instanceof Poison) {
					isRunning = false;
					System.out.println("[¬] Queue Poisoned "+ t);
				}
				
				System.out.println("[¬] Removing->" +t);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	

}
