package ie.gmit.sw;

import java.awt.image.BufferedImage;

/**
 * Image Description class contains info about the image such as it' name and path
 * <p>
@return image, returns BufferedImage
@return imgName returns image name
@return imgPath returns image path
 */

public class ImageDescription {
	
		BufferedImage image;
		String imgName;
		String imgPath;
		
		public ImageDescription(BufferedImage img, String name, String path) {
			setImage(img);;
			setImgPath(path);
			setImgName(name);
					
		}

		//---------GETTERS & SETTERS
		public BufferedImage getImage() {
			return image;
		}

		public void setImage(BufferedImage image) {
			this.image = image;
		}

		public String getImgName() {
			return imgName;
		}

		public void setImgName(String imgName) {
			this.imgName = imgName;
		}

		public String getImgPath() {
			return imgPath;
		}

		public void setImgPath(String imgPath) {
			this.imgPath = imgPath;
		}
		
		
		
	

}
