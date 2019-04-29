/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  public static void testKeepBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }
  
  public static void testNegate() {
	  Picture beach = new Picture("beach.jpg");
	    beach.explore();
	    beach.negate();
	    beach.explore();
  }
  
  public static void testGray() {
	  Picture beach = new Picture("beach.jpg");
	    beach.explore();
	    beach.grayscale();
	    beach.explore();
  }
  
  public static void testAllGray() {
	    Picture beach = new Picture("beach.jpg");
	    beach.grayscale();
	    beach.explore();
	    beach = new Picture("beach.jpg");
	    beach.grayscaleAverage();
	    beach.explore();
	    beach = new Picture("beach.jpg");
	    beach.grayscaleLightness();
	    beach.explore();
	    beach = new Picture("beach.jpg");
	    beach.grayscaleLuminosity();
	    beach.explore();
  }
  
  public static void testFixU() {
	  Picture water = new Picture("water.jpg");
	  water.explore();
	  water.fixUnderwater();
	  water.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }
  
  public static void testMirrorHorizontal() {
	  Picture caterpillar = new Picture("caterpillar.jpg");
	    caterpillar.explore();
	    caterpillar.mirrorHorizontal();
	    caterpillar.explore();
  }
  public static void testMirrorHorizontalBotToTop() {
	  Picture caterpillar = new Picture("caterpillar.jpg");
	    caterpillar.explore();
	    caterpillar.mirrorHorizontalBotToTop();
	    caterpillar.explore();
  }
  
  public static void testMirrorDiagonal() {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.mirrorDiagonal();
	  beach.explore();
	  
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testEdgeDetection2()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection2(15);
    swan.explore();
  }
  
  public static void testBlur(int x, int y, int w, int h, int n) {
	  Picture redMoto = new Picture("redMotorcycle.jpg");
	  for (int i = 0; i< n; i++) {
		  redMoto.blur(x, y, w, h);
	  }
	  redMoto.explore();
  }
  
  public static void testMirrorArms() {
	  Picture snowman = new Picture("snowman.jpg");
	  snowman.explore();
	  snowman.mirrorArms();
	  snowman.explore();
  }
  
  public static void testMirrorGull() {
	  Picture seagull = new Picture("seagull.jpg");
	  seagull.explore();
	  seagull.mirrorGull();
	  seagull.explore();
  }
  
  public static void testMirrorRectangle() {
	  Picture seagull = new Picture("seagull.jpg");
	  seagull.explore();
	  seagull.mirrorRectangle(232, 238, 322, 344, true);
	  seagull.explore();
	  Picture snowman = new Picture("snowman.jpg");
	  snowman.explore();
	  snowman.mirrorRectangle(160, 104 ,196, 295, false);
	  snowman.explore();
  }
  
  public static void testCopyS() {
	  Picture canvas = new Picture("640x480.jpg");
	  canvas.copy(new Picture("seagull.jpg"), 0, 0, 200, 200, 0, 0);
	  canvas.explore();
  }
  
  public static void testMyCollage() {
	  Picture canvas = new Picture("640x480.jpg");
	  canvas.myCollage();
	  canvas.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
	//testMirrorDiagonal();
    /*testZeroBlue();
    testKeepBlue();
    testNegate();
    testGray();*/
	  //testMyCollage();
	  //testMirrorRectangle();
	//testNegate();
	//testAllGray();
	//testMirrorVerticalRightToLeft();
    /*testKeepOnlyBlue();
    testKeepOnlyRed();
    testKeepOnlyGreen();
    testNegate();
    testGrayscale();
    testFixUnderwater();*/
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    /*testMirrorDiagonal();*/
    //testCollage();
    //testCopy();
    //testEdgeDetection2();
	  testBlur(180, 160, 25, 25, 10);
    /*testEdgeDetection2();
    testChromakey();
    testEncodeAndDecode();
    testGetCountRedOverValue(250);
    testSetRedToHalfValueInTopHalf();
    testClearBlueOverValue(200);
    testGetAverageForColumn(0);*/
  }
}