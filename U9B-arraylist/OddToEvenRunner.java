import java.util.Arrays;
import java.util.List;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class OddToEvenRunner
{
  public static void main( String args[] )
  {
	  List<Integer> ray = Arrays.asList(7,1,5,3,11,5,6,7,8,9,10,12345,11);
	  System.out.println(ListOddToEven.go(ray));
	  List<Integer> ray1 = Arrays.asList(2,4,6,8,8);
	  System.out.println(ListOddToEven.go(ray1));
	  List<Integer> ray2 = Arrays.asList(2,7,11,21,5,7);
	  System.out.println(ListOddToEven.go(ray2));
	  List<Integer> ray3 = Arrays.asList(7,7,7,11,2,7,7,11,11,2);
	  System.out.println(ListOddToEven.go(ray3));
  }
}