//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
  public static int go( List<Integer> ray )
  {
	  int indexOdd = -1;
	  int counter = 0;
	  for (int i : ray) {
		  if (indexOdd == -1) {
			  if (i % 2 == 1) {
				  indexOdd = counter;
			  }
		  }
		  counter++;
	  }
	  
	  if (indexOdd == -1) {
		  return -1;
	  }
	  
	  int counter2 = 0;
	  
	  int evenIndex = -1;
	  for (int i : ray) {
		  if (i % 2 == 0 && counter2 > indexOdd) {
			  evenIndex = counter2;
		  }
		  counter2++;
	  }
	  
	  if (evenIndex == -1) {
		  return -1;
	  }
	  
	  return Math.abs(evenIndex) - Math.abs(indexOdd);
  }
}