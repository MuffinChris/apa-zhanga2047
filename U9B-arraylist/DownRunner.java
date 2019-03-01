import java.util.Arrays;
import java.util.List;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class DownRunner
{
  public static void main( String args[] )
  {						
	  List<Integer> ray = Arrays.asList(-99,1,2,3,4,5,6,7,8,9,10,12345);
	  System.out.println(ListDown.go(ray));
	  List<Integer> ray2 = Arrays.asList(10,9,8,7,6,5,4,3,2,1,-99);
	  System.out.println(ListDown.go(ray2));
	  List<Integer> ray3 = Arrays.asList(10,10,10,11,456);
	  System.out.println(ListDown.go(ray3));
	  List<Integer> ray4 = Arrays.asList(9,10,-8,10000,-5000,1000);
	  System.out.println(ListDown.go(ray4));
  }
}