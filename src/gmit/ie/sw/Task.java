/**
 * 
 */

package gmit.ie.sw;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Task {
	
	private final int KERNEL_SIZE = 10; //amount of filters
	private int number;
	private BufferedImage image;
	private ImageDetails iD;
	Filters f = new Filters();
	
	int filterOption;
	
	public Task(int num, ImageDetails img) {
		super();
		this.iD = img;
		this.number = num;
	}
	
	public void startImageFilter() throws InterruptedException{
		
		Thread t = null;
		
		for(int i =1; i<KERNEL_SIZE-1; i++) {
			
			t = new Thread(new ImageFilter(iD, f.getFilter(i)));
			t.setName("T-"+i);
			System.out.println("Thread-"+t.getName());
			t.start();
			
		}
		t.join();
	}
	
	
	public synchronized ArrayList<ImageDetails> getImageList(){
		
		return null;
	}
	
	
	public String toString() {
		return "Task [number = "+number + ", file= "+image + "]";
		
	}

}
