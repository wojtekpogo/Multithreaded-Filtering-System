package gmit.ie.sw;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class ImageScanner {

	private String path;
	
	ArrayList<ImageDetails> images = new ArrayList<ImageDetails>();
	
	Scanner in = new Scanner(System.in);
	
	public ImageScanner() {
		setPath();
		addImagesToTheList();
		
	}
	
	public void setPath() {
		System.out.println("[¬] Enter Directory Path>");
		this.path = in.nextLine();
		
	}
	
	public void addImagesToTheList() {
		
		File f = new File(path);
		int count = 1;
		
		System.out.println("[¬] List of Images>");
		for(File file : f.listFiles()) {
			if(file.isFile() && (file.getName().endsWith(".jpg") || file.getName().endsWith(".jpeg") || file.getName().endsWith(".png"))) {
				try {
					ImageDetails img = new ImageDetails(ImageIO.read(file), file.getName(), file.getPath());
					images.add(img); //adding images to the ArrayList
					System.out.println(count +")"+file.getName()+"\n");
					
					
				}catch (IOException e) {
					e.printStackTrace();
				}
				count ++;
				
			}//for
		}
		
	}
	
	public ArrayList<ImageDetails> getImages(){
		return images;
	}
}
