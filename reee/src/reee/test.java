package reee;
import static java.lang.System.*; 

public class test {
	public static void sort2(int[] list ) 
	{
		int count = 0;
	  for (int i=1; i< list.length; ++i) 
	  {
		  count++;
		  if (count == 5) {
			  break;
		  }
		int bot=0, top=i-1;
		while (bot<=top) 
		{
		   int mid=(bot+top)/2;
		   if (list[mid] < list[i]) {
			bot=mid+1;
		   } else {
			   top=mid-1;
			   
		   }
		}
		int temp=list[i];

		for (int j=i; j>bot; --j) {

			System.out.println("Replacing: " + list[j] + " AND " + list[j-1]);
			list[j]=list[j-1];
		}
		System.out.println("Replacing (tempwise) : " + temp + " AND " + list[bot]);
		list[bot]=temp;
	  }
	}



	public static void main(String[] args) {
		
		int[] clap = new int[] {3,15, 61, 11, 7, 9, 2,};
		sort2(clap);
		for (int i : clap) { 
			System.out.print(i + " ");
		}




	}
	
}
