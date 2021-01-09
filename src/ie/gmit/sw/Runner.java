package ie.gmit.sw;

import java.util.concurrent.*;
/**
 * Runner class consist of a switch statement where we can control the available options.
 * First case starts both Producer and Reducer threads where the image filtering happens
 * Fourth case terminates the application.
 */

public class Runner {

	public static void main(String[] args) {
		
		Menu menu = new Menu();
		BlockingQueue<Task> q = new ArrayBlockingQueue<>(5); //
		
		
		switch(menu.getOption()) {
		
		//Image Directory
		case 1:
			ImageProducer ip = new ImageProducer(q); //
			ImageReducer ic = new ImageReducer(q);
			new Thread(ip).start(); //starting producer
			new Thread(ic).start(); //starting reducer
			break;
		//Single Image
		case 2:
			System.out.println("[?]");	
			break;
		//Custom Filter
		case 3:
			System.out.println("[?]");		
			break;
		//Quit
		case 4: 
			System.out.println("bye...");
		    System.exit(0);
			break;
			
		}//switch

	}

}
