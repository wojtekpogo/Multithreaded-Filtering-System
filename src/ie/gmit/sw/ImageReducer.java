package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

/**
 * 
 * ImageReducer class takes from the queue. 
 * Queue stops when Task is an instance of Poison, 
 * changing the @param isRunning to false interrupts the queue
 *
 */

public class ImageReducer implements Runnable {
	
	private BlockingQueue<Task> que;
	private  volatile boolean isRunning = true; // won't be cached if we use volatile keyword

	public ImageReducer(BlockingQueue<Task>q) {
		super();
		this.que = q;
		
	}

	@Override
	public void run() {
		while(isRunning) {
			
			try {
				Task t = que.take(); //blocking method
				if(t instanceof Poison) {
					isRunning = false; // stopping the queue
					System.out.println("[¬] Queue Poisoned "+ t);
				}
				
				System.out.println("[¬] Removing->" +t);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	

}
