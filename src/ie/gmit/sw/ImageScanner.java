package ie.gmit.sw;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 * Image Scanner Class adds Buffered Images to the ArrayList
 * setPath method asks user for a @param path which is then passed to the addImages method
 * <p>
 * addImages method checks if the directory contains images with specified extensions
 * and then add them to they ArrayList
 * getImages method @return list of BufferedImages
 * 
 * 
 */

public class ImageScanner {

	private String path;
	
	ArrayList<ImageDescription> images = new ArrayList<ImageDescription>();
	
	Scanner in = new Scanner(System.in);
	
	public ImageScanner() {
		setPath();
		addImages();
		
	}
	
	public void setPath() {
		System.out.println("[¬] Enter Directory Path>");
		this.path = in.nextLine();
		
	}
	
	public void addImages() {
		
		File f = new File(path);
		int count = 1;
		
		System.out.println("[¬] List of Images>");
		for(File file : f.listFiles()) {
			if(file.isFile() && (file.getName().endsWith(".jpg") || file.getName().endsWith(".jpeg") || file.getName().endsWith(".png"))) {
				try {
					ImageDescription img = new ImageDescription(ImageIO.read(file), file.getName(), file.getPath());
					images.add(img); //adding images to the ArrayList
					System.out.println(count +")"+file.getName()+"\n");
					
					
				}catch (IOException e) {
					e.printStackTrace();
				}
				count ++;
				
			}//for
		}
		
	}
	
	public ArrayList<ImageDescription> getImages(){
		return images;
	}
}
