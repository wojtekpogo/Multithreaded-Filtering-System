package ie.gmit.sw;

/**
 * Filters class contains switch statement to control which filter to choose.
 * <p>
 * @param num an integer value to pick one of the filters
 * @return the kernel which is 3x3 matrix
 *
 */

public class Filters {
	
	public float [][] getFilter(int num){
		
		switch(num) {
		
		case 1:
			return Identity();
		case 2:
			return EdgeDetection();
		case 3: 
			return Sharpen();
		case 4:
			return HorizontalLines();
		case 5:
			return Laplacian();
		case 6:
			return VerticalLines();
		case 7:
			return Diagonal45Lines();
		case 8:
			return SobelVertical();
			default:
				System.out.println("No more filters...");
			
		}
		
		return null;
	}//switch
	
	
	
private float [][] Identity(){
		
		float [][] kernel = {
				{0, 0, 0},
				{0, 1, 0},
				{0, 0, 0}
				
		};
		return kernel;
	}
	
private float [][] EdgeDetection(){
		
		float [][] kernel = {
				{1, 0, -1},
				{0, 0, 0},
				{-1, 0, 1}
				
		};
		return kernel;
	}

private float [][] Sharpen(){
	
	float [][] kernel = {
			{0, -1, 0},
			{-1, 5, -1},
			{0, -1, 0}
			
	};
	return kernel;
}

private float [][] HorizontalLines() {
	
	float [][] kernel ={
			{-1, -1, -1},
			{2, 2, 2},
			{-1, -1, -1}
	};
	
	return kernel;	
}

private float [][] Laplacian(){
	
	float [][]kernel = {
			{0, -1, 0},
			{-1, 4, -1},
			{0, -1, 0}
			
	};
	
	return kernel;
}

private float [][] VerticalLines(){
	
	float [][]kernel = {
			{-1, 2, -1},
			{-1, 2, -1},
			{-1, 2, -1}
	};
	return kernel;
}

private float [][] Diagonal45Lines(){
	
	float[][] kernel = {
			{-1, -1, 2},
			{-1, 2, -1},
			{2, -1, -1}
	};
	
	return kernel;
}

private float [][] SobelVertical(){
	
	
	float [][] kernel = {
			{-1, 0, 1},
			{-2, 0, 2},
			{-1, 0, 1}
	};
	return kernel;
}


	

}
