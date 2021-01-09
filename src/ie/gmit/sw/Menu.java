package ie.gmit.sw;

import java.util.Scanner;

/**
 * @author Wojtek Pogorzelski G00375250
 * @version 1.0
 * Menu class which displays the menu with several options. 
 * Has a scanner to scan the user input and control the menu
 * @return returns option selected by user
 */

public class Menu {
	
	Scanner in = new Scanner(System.in);
	int option;
	
	public Menu() {
		
		System.out.println("----- Image Filtering System ----- \n"+ "1) Enter Image Directory \n"+
		"2) Select Single Image \n"+ "3) Add a Custom Filter \n"+"4) Quit \n" +"Select Option (1-4)> \n");
		setOption();
		
	}
	
	/**
	 * Sets an option for particular action in the menu
	 */
	
	public void setOption() {
		option = Integer.parseInt(in.nextLine());
		
	}
	
	/**
	 * 
	 * @return option to control the menu
	 */
	public int getOption() {
		return this.option;
	}

}
