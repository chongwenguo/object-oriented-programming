/*********************************************8
 * 
 * cs1331 hw03
 * @author chongwen guo
 *
 */


public class ImageProcessor {
	
	 private Pic picture;
	
	
/**
 *  constructor 
 *  
 * 	store a picture which is manipulating to a instance of ImageProcessor
 *  @param the name of the picture 
 */
	public ImageProcessor(String name){
		
		picture = new Pic(name);
	}
	
/**
 * 
 *  main method
 *  @param args the command line arguments
 * 
 */
	public static void main(String[] args) {
		 ImageProcessor image = new ImageProcessor(args[0]);
		 image.onlyRed();
		 image.onlyGreen();
		 image.onlyBlue();
		 image.invert();
		 image.greyscale();
		 image.posterize();
		 
		 if(args.length > 1){
		 Pic watermark = new Pic(args[1]);
		 image.watermark(watermark);
		 }
	}
	
/** 
 *  method to modify a image in the way that red channel is the only channel that affects the image
 *
 *	@return a modified image with only red channel
 *
 */ 	
	public Pic onlyRed() {
		Pic newPicture = picture.deepCopy();
		for (int i = 0; i < newPicture.getWidth(); i++) {
			for (int j = 0; j < newPicture.getHeight(); j++) {
				newPicture.getPixel(i, j).setBlue(0);
				newPicture.getPixel(i, j).setGreen(0);
			}
		}
		newPicture.show();
		return newPicture;
	}
	

/** 
 * 
 *	method to modify a image in the way that green channel is the only channel that affects the image
 *
 *	@return a modified image with only green channel
 *
 */ 	
	public Pic onlyGreen() {
		Pic newPicture = picture.deepCopy();
		for (int i = 0; i < newPicture.getWidth(); i++) {
			for (int j = 0; j < newPicture.getHeight(); j++) {
				newPicture.getPixel(i, j).setBlue(0);
				newPicture.getPixel(i, j).setRed(0);
			}
		}
		
		newPicture.show();
		return newPicture;

	}	
			

/** 
 * 
 * 	method to modify a image in the way that blue channel is the only channel that affects the image
 *
 *	@return a modified image with only blue channel
 *
 */ 	
	
	public Pic onlyBlue() {
		Pic newPicture = picture.deepCopy();
		for (int i = 0; i < newPicture.getWidth(); i++) {
			for (int j = 0; j < newPicture.getHeight(); j++) {
				newPicture.getPixel(i, j).setRed(0);
				newPicture.getPixel(i, j).setGreen(0);
			}
		}
		newPicture.show();
		return newPicture;
		
	}
	
	

/** 
 * 
 * 	method to modify a image in the way that set each channel to its respective difference
 *
 *	@return a modified image in which each channel changed to its respective difference
 *	 
 */ 	
	
	public Pic invert() {
		Pic newPicture = picture.deepCopy();
		for (int i = 0; i < newPicture.getWidth(); i++) {
			for (int j = 0; j < newPicture.getHeight(); j++) {
				newPicture.getPixel(i, j).setBlue(
						255 - newPicture.getPixel(i, j).getBlue());
				newPicture.getPixel(i, j).setGreen(
						255 - newPicture.getPixel(i, j).getGreen());
				newPicture.getPixel(i, j).setRed(
						255 - newPicture.getPixel(i, j).getRed());
			}
		}
		newPicture.show();
		return newPicture;
	}
	
/** 
 * 
 * 	method to modify a image in the way that set each of the channels to its averaged value.
 *
 *	@return a modified image in which each channel changed to its averaged value
 *
 */ 	
	
	public Pic greyscale() {
		
		Pic newPicture = picture.deepCopy();
		for (int i = 0; i < newPicture.getWidth(); i++) {
			for (int j = 0; j < newPicture.getHeight(); j++) {
				int average = (newPicture.getPixel(i, j).getRed()
						+ newPicture.getPixel(i, j).getBlue()
						+ newPicture.getPixel(i,j).getGreen()) / 3;
				newPicture.getPixel(i, j).setRed(average);
				newPicture.getPixel(i, j).setBlue(average);
				newPicture.getPixel(i, j).setGreen(average);
			}
		}
		newPicture.show();
		return picture;
	}


/** 
 * 
 * 	method to posterize a image 
 *
 *	@return a modified image which only remains its highest value color 
 *
 *
 */ 
	public Pic posterize(){
		Pic newPicture = picture.deepCopy();
		for (int i = 0; i < newPicture.getWidth(); i++) {
			for (int j = 0; j < newPicture.getHeight(); j++) {
				int max = newPicture.getPixel(i, j).getRed();
				String channel = "red";
				
				if (newPicture.getPixel(i, j).getGreen() > max) {
					max = newPicture.getPixel(i, j).getGreen();
					channel = "green";
				}
				
				if (newPicture.getPixel(i, j).getBlue() > max) {
					max = newPicture.getPixel(i, j).getBlue();
					channel = "blue";
				}

				switch (channel) {
				case "red":
					newPicture.getPixel(i, j).setBlue(0);
					newPicture.getPixel(i, j).setGreen(0);
					break;
					
				case "green":
					newPicture.getPixel(i, j).setBlue(0);
					newPicture.getPixel(i, j).setRed(0);
					break;
					
				case "blue":
					newPicture.getPixel(i, j).setRed(0);
					newPicture.getPixel(i, j).setGreen(0);
					break;
				}
			}	
		}

		newPicture.show();
		return newPicture;
	}

	
/** 
 * 
 *  methord to add a watermark to the image
 *
 *  @param watermark -> the watermark picture to be added to the picture
 *	@return a modified image which has a watermark on it 
 *
 *
 */ 
	
	public Pic watermark(Pic watermark) {

		Pic newPicture = picture.deepCopy();
		
		if (watermark.getWidth() >= newPicture.getWidth()) {
			if (watermark.getHeight() >= newPicture.getHeight()) { //watermark is larger in both width and height
				for (int i = 0; i < newPicture.getWidth(); i++) {
					for (int j = 0; j < newPicture.getHeight(); j++) {
						newPicture.getPixel(i, j).setRed((newPicture.getPixel(i, j).getRed() + watermark.getPixel(i, j).getRed()) / 2);
						newPicture.getPixel(i, j).setBlue((newPicture.getPixel(i, j).getBlue() + watermark.getPixel(i, j).getBlue()) / 2);
						newPicture.getPixel(i, j).setGreen((newPicture.getPixel(i, j).getGreen() + watermark.getPixel(i, j).getGreen()) / 2);
					}
				}
			} else { //watermark is larger in width, smaller in height
				for (int i = 0; i < newPicture.getWidth(); i++) {
					for (int j = 0; j < watermark.getHeight(); j++) {
						newPicture.getPixel(i, j).setRed((newPicture.getPixel(i, j).getRed() + watermark.getPixel(i, j).getRed()) / 2);
						newPicture.getPixel(i, j).setBlue((newPicture.getPixel(i, j).getBlue() + watermark.getPixel(i, j).getBlue()) / 2);
						newPicture.getPixel(i, j).setGreen((newPicture.getPixel(i, j).getGreen() + watermark.getPixel(i, j).getGreen()) / 2);
					}
				}
			}
		} else { 
			if (watermark.getHeight() >= newPicture.getHeight()) { //watermark is smaller in width but larger in height
				for (int i = 0; i < watermark.getWidth(); i++) {
					for (int j = 0; j < newPicture.getHeight(); j++) {
						newPicture.getPixel(i, j).setRed((newPicture.getPixel(i, j).getRed() + watermark.getPixel(i, j).getRed()) / 2);
						newPicture.getPixel(i, j).setBlue((newPicture.getPixel(i, j).getBlue() + watermark.getPixel(i, j).getBlue()) / 2);
						newPicture.getPixel(i, j).setGreen((newPicture.getPixel(i, j).getGreen() + watermark.getPixel(i, j).getGreen()) / 2);
					}
				}
			} else {
				for (int i = 0; i < watermark.getWidth(); i++) {  //watermark is smaller in both width and height
					for (int j = 0; j < watermark.getHeight(); j++) {
						newPicture.getPixel(i, j).setRed((newPicture.getPixel(i, j).getRed() + watermark.getPixel(i, j).getRed()) / 2);
						newPicture.getPixel(i, j).setBlue((newPicture.getPixel(i, j).getBlue() + watermark.getPixel(i, j).getBlue()) / 2);
						newPicture.getPixel(i, j).setGreen((newPicture.getPixel(i, j).getGreen() + watermark.getPixel(i, j).getGreen()) / 2);
					}
				}
			}
		}
		newPicture.show();
		return newPicture;
	}


}
