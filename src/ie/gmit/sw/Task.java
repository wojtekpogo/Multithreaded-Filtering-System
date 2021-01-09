package ie.gmit.sw;

import java.awt.image.BufferedImage;
import java.util.Scanner;

/**
 * Task class creates new Thread of ImageFilter with passed @param iD which is an image itself and
 * @param filterOption to pick one of the available filters.
 * <p>
 * User is able to control which filter to apply by prompting 1-8. 
 */

public class Task {
	
	private final int SIZE = 10; //loop controller
	private int number;
	private BufferedImage image;
	private ImageDescription iD;
	Filters f = new Filters();
	
	int filterOption;
	Scanner in = new Scanner(System.in);
	
	public Task(int num, ImageDescription img) {
		this.iD = img;
		this.number = num;
	}
	
	public void applyFilter() throws InterruptedException{
		
		Thread t = null;
		
		System.out.println("[¬] Pick a filter you would like to apply \n"+"1) Identity \n" +"2) EdgeDetection \n"+
				"3) Sharpen \n"+"4) HorizontalLines \n" + "5) Laplacian \n"+"6) VerticalLines \n" +"7) Diagonal45Lines \n"+"8) SobelVertical \n");
				filterOption = in.nextInt();
		
		for(int i =1; i<SIZE-1; i++) {
			
			t = new Thread(new ImageFilter(iD, f.getFilter(filterOption)));
			t.setName("T-"+i);
			//System.out.println("Thread-"+t.getName());
			t.start();
			
		}
		t.join(); //waits for thread to finish
	}
	
	public String toString() {
		return "Task [number = "+number + ", file= "+image + "]";
		
	}

}
