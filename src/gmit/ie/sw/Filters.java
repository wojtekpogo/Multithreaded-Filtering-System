package gmit.ie.sw;

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
	
	
	
public float [][] Identity(){
		
		float [][] kernel = {
				{0, 0, 0},
				{0, 1, 0},
				{0, 0, 0}
				
		};
		return kernel;
	}
	
public float [][] EdgeDetection(){
		
		float [][] kernel = {
				{1, 0, -1},
				{0, 0, 0},
				{-1, 0, 1}
				
		};
		return kernel;
	}

public float [][] Sharpen(){
	
	float [][] kernel = {
			{0, -1, 0},
			{-1, 5, -1},
			{0, -1, 0}
			
	};
	return kernel;
}

public float [][] HorizontalLines() {
	
	float [][] kernel ={
			{-1, -1, -1},
			{2, 2, 2},
			{-1, -1, -1}
	};
	
	return kernel;	
}

public float [][] Laplacian(){
	
	float [][]kernel = {
			{0, -1, 0},
			{-1, 4, -1},
			{0, -1, 0}
			
	};
	
	return kernel;
}

public float [][] VerticalLines(){
	
	float [][]kernel = {
			{-1, 2, -1},
			{-1, 2, -1},
			{-1, 2, -1}
	};
	return kernel;
}

public float [][] Diagonal45Lines(){
	
	float[][] kernel = {
			{-1, -1, 2},
			{-1, 2, -1},
			{2, -1, -1}
	};
	
	return kernel;
}

public float [][] SobelVertical(){
	
	
	float [][] kernel = {
			{-1, 0, 1},
			{-2, 0, 2},
			{-1, 0, 1}
	};
	return kernel;
}


	

}
