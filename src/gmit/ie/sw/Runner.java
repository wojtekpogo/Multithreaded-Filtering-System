package gmit.ie.sw;

import java.util.concurrent.*;


public class Runner {

	public static void main(String[] args) {
		
		Menu menu = new Menu();
		
		BlockingQueue<Task> q = new ArrayBlockingQueue<Task>(5);
		
		switch(menu.getOption()) {
		
		//Image Directory
		case 1:
			ImageProducer ip = new ImageProducer(q);
			ImageConsumer ic = new ImageConsumer(q);
			new Thread(ip).start();
			new Thread(ic).start();
			break;
		//Single Image
		case 2:
			
			break;
		//Custom Filter
		case 3:
			
			break;
		//Quit
		case 4: 
			System.out.println("bye...");
		    System.exit(0);
			break;
			
		}

	}

}
