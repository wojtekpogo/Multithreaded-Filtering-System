package gmit.ie.sw;

import java.util.Scanner;

public class FilterPicker {
	
	int filterOption;
	
	Scanner in = new Scanner(System.in);
	
	public int pickFilter() {
		System.out.println("[¬] Pick a filter you would like to apply \n"+"1) Identity \n" +"2) EdgeDetection \n"+
				"3) Sharpen \n"+"4) HorizontalLines \n" + "5) Laplacian \n"+"6) VerticalLines \n" +"7) Diagonal45Lines \n"+"8) SobelVertical \n");
				filterOption = in.nextInt();
				System.out.println(filterOption);
		
		
		return  filterOption;
	}

}
