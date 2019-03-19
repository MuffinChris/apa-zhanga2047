package reee;

public class H extends G {
	   private int y;
	   public H() { y=4;}
	   public void setY(int val){
	      y=val;
	   }
	   public String toString() { 
	      return "" + y  + " " + super.toString();
	   }
	}

