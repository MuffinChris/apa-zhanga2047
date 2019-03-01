//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.List;
import java.util.ArrayList;

public class ListDown
{
  //go() will return true if all numbers in numArray
  //are in decreasing order [31,12,6,2,1]
  public static boolean go(List<Integer> numArray)
  {
	  int prev = 99999999;
	  for (int i : numArray) {
		  if (i < prev) {
			  prev = i;
		  } else {
			  return false;
		  }
	  }
    return true;
  }	
}