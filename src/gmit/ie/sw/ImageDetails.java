package gmit.ie.sw;

import java.awt.image.BufferedImage;

public class ImageDetails {
	
		BufferedImage image;
		String imgName;
		String imgPath;
		
		public ImageDetails(BufferedImage img, String name, String path) {
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
