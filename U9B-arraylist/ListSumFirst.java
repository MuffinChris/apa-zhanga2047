//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.List;
import java.util.ArrayList;

public class ListSumFirst
{
  public static int go(List<Integer> ray)
  {
	  int max = ray.get(0);
	  int sum = 0;
	  for (int i : ray) {
		  if (i > max) {
			  sum+=i;
		  }
	  }
	  
	  if (sum == 0) {
		  return -1;
	  }
	  return sum;
	  
  }
}