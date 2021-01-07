package gmit.ie.sw;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageFilter implements Runnable{
	
	private BufferedImage input,output;
	private String imageName;
	private float[][] kernel;
	

	public ImageFilter(ImageDetails imageDetails, float[][] k) {
		this.input = imageDetails.image;
		this.kernel = k;
		this.imageName = imageDetails.imgName;
		
		
	}
	@Override
	public void run() {
		
		int WIDTH = input.getWidth();
		int HEIGHT = input.getHeight();
		
		output = new BufferedImage(WIDTH, HEIGHT, input.getType()); //image after applying the filter
		
		System.out.println("[¬]Processing the image...");
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				float red = 0f, green = 0f, blue = 0f;
				for (int i = 0; i < kernel.length; i++) {
					for (int j = 0; j < kernel.length; j++) {
						
						// opposite edge is used
						int imageX = (x - kernel.length / 2 + i + WIDTH) % WIDTH;
						int imageY = (y - kernel.length / 2 + j + HEIGHT) % HEIGHT;

						int RGB = input.getRGB(imageX, imageY);
						int R = (RGB >> 16) & 0xff; // Red Value
						int G = (RGB >> 8) & 0xff; // Green Value
						int B = (RGB) & 0xff; // Blue Value

						// The RGB is multiplied with current kernel element and added on to the
						// variables red, blue and green
						red += (R * kernel[i][j]);
						green += (G * kernel[i][j]);
						blue += (B * kernel[i][j]);
					} //for j
				} //for i 
				int outR, outG, outB;
				// The value is truncated to 0 and 255 if it goes beyond
				outR = Math.min(Math.max((int) (red * 2), 0), 255);
				outG = Math.min(Math.max((int) (green * 2), 0), 255);
				outB = Math.min(Math.max((int) (blue * 2), 0), 255);
				// Pixel is written to output image
				output.setRGB(x, y, new Color(outR, outG, outB).getRGB());
			} //for y
		}//for x
		
		//String outputfname = this.imageName + "_edited";
		
		String outputfname = this.imageName.split("\\.(?=[^\\.]+$)")[0] + "_edited";
		
		
		try {
			ImageIO.write(output, "jpg", new File(outputfname + ".jpg"));
			System.out.println("[¬] Image saved as " + outputfname + ".jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
