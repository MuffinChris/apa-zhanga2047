package reee;

public class P 
{
	   private int x, y;   

	   public P() { x=7;  y=0;  }
	   public P(int v){x=v; y=7;}
	   
	   public double fun() { return x; }
	   public void go() { back();  } 
	   public void whoot() { go(); }
	   public void back() { 
	      x=992; 
	   }
	   public String toString() 
	   { 
	      return getClass().getName() + " "  + x + " " + y;
	   }
	}
