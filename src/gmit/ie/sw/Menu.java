package gmit.ie.sw;

import java.util.Scanner;

public class Menu {
	
	Scanner in = new Scanner(System.in);
	
	int option;
	
	public Menu() {
		
		System.out.println("----- Image Filtering System ----- \n"+ "1) Enter Image Directory \n"+
		"2) Select Single Image \n"+ "3) Add a Custom Filter \n"+"4) Quit \n" +"Select Option (1-4)> \n");
		
		setOption();
		
	}
	
	public void setOption() {
		option = Integer.parseInt(in.nextLine());
		
	}
	
	public int getOption() {
		return this.option;
	}

}
