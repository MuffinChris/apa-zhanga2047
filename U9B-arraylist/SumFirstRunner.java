import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class SumFirstRunner
{
  public static void main( String args[] )
  {
	  List<Integer> li = Arrays.asList(-99,1,2,3,4,5,6,7,8,9,10,5);
	  System.out.println(ListSumFirst.go(li));
	  List<Integer> liX = Arrays.asList(10,20,30,40,50,-11818,40,30,20,10);
	  System.out.println(ListSumFirst.go(liX));
	  List<Integer> liY = Arrays.asList(250,19,17,15,13,11,10,9,6,3,2,1,0);
	  System.out.println(ListSumFirst.go(liY));
  }
}