package reee;

public class Q extends P 
	{
	   private int x;

	   public Q() { x=23;  } 
	   public Q(int v) { super(v); x=33;  }
	   
	   public double fun() { return x; }
	   public void go() { super.back();  }
	   public void back() { 
	      x=45; 
	   }

	   public String toString() 
	   { 
	      return "class " + getClass().getName() + " " + x
	                      + " " +  super.toString() ;
	   }
	}

