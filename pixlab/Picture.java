import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

import com.sun.rowset.internal.Row;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(0);
        pixelObj.setRed(0);
      }
    }
  }
  
  public void negate() {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setGreen(255-pixelObj.getGreen());
	        pixelObj.setRed(255-pixelObj.getRed());
	        pixelObj.setBlue(255-pixelObj.getBlue());
	      }
	    }
  }
  
  public void grayscale() {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setGrayLuminosity();
	      }
	    }
  }
  
  public void grayscaleAverage() {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setGrayAverage();
	      }
	    }
  }
  
  public void grayscaleLightness() {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setGrayLightness();
	      }
	    }
  }
  
  public void grayscaleLuminosity() {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setGrayLuminosity();
	      }
	    }
  }
  
  public void fixUnderwater() {
	  Pixel[][] pixels = this.getPixels2D();
	  int bluerange = 0;
	  int bluemax = 0;
	  for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	    	
	    	  if (pixelObj.getBlue() > bluemax) {
	    		  bluemax = pixelObj.getBlue();
	    	  }
	    	  
	    	  int bluemin = Integer.MAX_VALUE;
	    	  if (pixelObj.getBlue() < bluemin) {
	    		  bluemin = pixelObj.getBlue();
	    	  }
	    	  
	    	  bluerange = bluemax - bluemin;
	      }
	    }
	  
	  for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	    	  if (pixelObj.getBlue() > bluemax - (bluerange * 0.65) && pixelObj.getBlue() < 255 && pixelObj.getGreen() < 170) {
	    		  pixelObj.setBlue(bluemax + (int) (pixelObj.getBlue() * 1.4));
	    	  }
	      }
	    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontal() {
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel topPixel = null;
	    Pixel botPixel = null;
	    int height = pixels.length;
	    for (int row = 0; row < height / 2; row++)
	    {
	      for (int col = 0; col < pixels[0].length; col++)
	      {
	        topPixel = pixels[row][col];
	        botPixel = pixels[height - 1 - row][col];
	        botPixel.setColor(topPixel.getColor());
	      }
	    } 
  }
  public void mirrorHorizontalBotToTop() {
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel topPixel = null;
	    Pixel botPixel = null;
	    int height = pixels.length;
	    for (int row = 0; row < height / 2; row++)
	    {
	      for (int col = 0; col < pixels[0].length; col++)
	      {
	        topPixel = pixels[row][col];
	        botPixel = pixels[height - 1 - row][col];
	        topPixel.setColor(botPixel.getColor());
	      }
	    } 
  }
  
  public void blur(int x, int y, int w, int h) {
	  	Pixel[][] pixels = this.getPixels2D();
	    int height = h + x;
	    int width = w + y;
		    for (int row = x; row <= height; row++) {
		    	for (int col = y; col <= width; col++) {
		    		int averageB = 0;
		    		int averageR = 0;
		    		int averageG = 0;
		    		int terms = 0;
		    		for (int r = -1; r <= 1; r++) {
		    			for (int c = -1; c<= 1; c++) {
		    				averageB+=pixels[row-r][col-c].getBlue();
		    				averageR+=pixels[row-r][col-c].getRed();
		    				averageG+=pixels[row-r][col-c].getGreen();
		    				terms++;
		    			}
		    		}
		    		averageB/=terms;
		    		averageR/=terms;
		    		averageG/=terms;
		    		pixels[row][col].setRed(averageR);
		    		pixels[row][col].setBlue(averageB);
		    		pixels[row][col].setGreen(averageG);
		    	}
		    }
	    }
  
  public void mirrorDiagonal() {
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel blPixel = null;
	    Pixel trPixel = null;
	    int height = pixels.length;
	    int width = pixels[0].length;
	    int side = Math.min(height, width);
	    
	    
	    for (int row = side - 1; row >= 0; row--)
	    {
	      for (int col = side - 1; col >= 0; col--)
	      {
	        trPixel = pixels[row][col];
	        blPixel = pixels[col][row];
	        blPixel.setColor(trPixel.getColor());
	      }
	    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
	int count = 0;
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        count++;
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    System.out.println("COUNT OF ITERATIONS: " + count);
  }
  
  public void mirrorArms()
  {
	int count = 0;
    int mirrorPoint = 196;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 160; row < mirrorPoint; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 104; col < 295; col++)
      {
        count++;
        leftPixel = pixels[row][col];      
        rightPixel = pixels[mirrorPoint - row + mirrorPoint]                       
                         [col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    System.out.println("COUNT OF ITERATIONS: " + count);
  }
  
  public void mirrorGull() {
	  int count = 0;
	    int mirrorPoint = 344;
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    Pixel[][] pixels = this.getPixels2D();
	    
	    // loop through the rows
	    for (int row = 232; row < 322; row++)
	    {
	      // loop from 13 to just before the mirror point
	      for (int col = 238; col < mirrorPoint; col++)
	      {
	        count++;
	        leftPixel = pixels[row][col];      
	        rightPixel = pixels[row]                       
	                         [mirrorPoint - col + mirrorPoint];
	        rightPixel.setColor(leftPixel.getColor());
	      }
	    }
	    System.out.println("COUNT OF ITERATIONS: " + count);
  }
  
  public void mirrorRectangle(int x1, int y1, int x2, int y2, boolean vertical) {
	  
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    Pixel[][] pixels = this.getPixels2D();
	    
	    int rf = 0;
	    int cf = 0;
	    
	    if (vertical) {
	    	rf = 0;
	    	cf = y2;
	    } else {
	    	rf = x2;
	    	cf = 0;
	    }
	    
	    int mr = 1;
	    int cr = 1;
	    
	    if (cf > 0) {
	    	mr = -1;
	    } else {
	    	cr = -1;
	    }
	    // loop through the rows
	    for (int row = x1; row < x2; row++)
	    {
	      // loop from 13 to just before the mirror point
	      for (int col = y1; col < y2; col++)
	      {
	        leftPixel = pixels[row][col];
	        	rightPixel = pixels[rf - mr * row + rf]                       
	                         [cf - cr * col + cf];
	        rightPixel.setColor(leftPixel.getColor());
	      }
	    }
	  
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  public void copy(Picture fromPic, int x1, int y1, int x2, int y2, 
          int startRow, int startCol)
			{
				Pixel fromPixel = null;
				Pixel toPixel = null;
				Pixel[][] toPixels = this.getPixels2D();
				Pixel[][] fromPixels = fromPic.getPixels2D();
				for (int fromRow = x1, toRow = startRow; 
				  fromRow < x2 &&
				  toRow < toPixels.length; 
				  fromRow++, toRow++)
				{
					for (int fromCol = y1, toCol = startCol; 
					    fromCol < y2 &&
					    toCol < toPixels[0].length;  
					    fromCol++, toCol++)
					{
						 fromPixel = fromPixels[fromRow][fromCol];
						 toPixel = toPixels[toRow][toCol];
						 toPixel.setColor(fromPixel.getColor());
			}
			}   
}

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  public void myCollage() {
	  
	    Picture bar1 = new Picture("barbaraS.jpg");
	    Picture bar2 = new Picture("barbaraS.jpg");
	    Picture bar3 = new Picture("barbaraS.jpg");
	    Picture bar4 = new Picture("barbaraS.jpg");
	    bar1.mirrorDiagonal();
	    bar1.fixUnderwater();
	    bar1.zeroBlue();
	    bar1.mirrorVertical();
	    bar2.mirrorHorizontalBotToTop();
	    bar3.fixUnderwater();
	    bar3.mirrorHorizontal();
	    bar4.grayscaleLightness();
	    bar4.mirrorDiagonal();
	    bar4.mirrorHorizontal();
	    bar4.mirrorDiagonal();
	    bar4.mirrorVertical();
	    bar4.mirrorDiagonal();
	    this.copy(bar1,20, 20, 110, 110, 0,0);
	    this.copy(bar2,20, 20, 110, 110, 100,0);
	    this.copy(bar3,20, 20, 110, 110, 200,0);
	    this.copy(bar4,20, 20, 110, 110, 300,0);
	  
  }
  
  public int ed2A(int x1, int y1, int x2, int y2) {
	  Pixel[][] pixels = this.getPixels2D();
	  int coloraverage = 0;
	  int terms = 0;
	  for (int row = x1; row < x2; row++) {
		  for (int col = y1; col < y2; col++) {
			  terms+=3;
			  Pixel p = pixels[row][col];
			  coloraverage+=p.getBlue() + p.getRed() + p.getGreen();
		  }
	  }
	  coloraverage/=terms;
	  return coloraverage;
  }
  
  public void edgeDetection2(int edgeDist)
  {
    Pixel[][] pixels = this.getPixels2D();
    
    int rowstart = pixels.length-1;
    int colstart = pixels[0].length-1;
    
    int rc = 0;
    int cc = 0;
    
    int rowinc = pixels.length/50;
    int colinc = pixels[0].length/50;
    
    while (rc + rowinc <= pixels.length-1) {
    	while (cc + colinc <= pixels[0].length-1) {
    		int avg = ed2A(rc, cc, rc+rowinc, cc+colinc);
    		for (int row = rc; row < rc+rowinc; row++) {
    			for (int col = cc; col < cc + colinc; col++) {
    				Pixel p = pixels[row][col];
    	    		if (Math.abs((p.getBlue() + p.getRed() + p.getGreen()) / 3) - avg >= edgeDist) {
    	    			p.setColor(Color.BLACK);
    	    		} else {
    	    			p.setColor(Color.WHITE);
    	    		}
    	    		
    			}
    		}
    		
    		cc+=colinc;
    	}
    	colstart = pixels[0].length-1;
    	cc = 0;
    	rowstart-=rowinc;
    	rc+=rowinc;
    }
    
  }
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel topPixel = null;
    Pixel botPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color botColor = null;
    for (int row = 0; row < pixels.length - 1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist) {
          leftPixel.setColor(Color.BLACK);
          continue;
        }
      } 
      for (int col = 0; col < pixels[0].length - 1; col++) {  
    	  botPixel = pixels[row+1][col];
          topPixel = pixels[row][col];
          botColor = botPixel.getColor();
	        if (topPixel.colorDistance(botColor) > 
	            edgeDist)
	          topPixel.setColor(Color.BLACK);
	        else
	          topPixel.setColor(Color.WHITE);
      	}
      }
    }
    /*
    for (int row = 0; row < pixels.length - 1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length; col++)
      {
        botPixel = pixels[row+1][col];
        topPixel = pixels[row][col];
        btColor = topPixel.getColor();
        if (topPixel.colorDistance(btColor) > 
            edgeDist)
          botPixel.setColor(Color.BLACK);
        else
          botPixel.setColor(Color.WHITE);
      }
    }*/
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
