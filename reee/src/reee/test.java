package reee;
import static java.lang.System.*; 

public class test {

	public static void main(String[] args) {
		G one = new G();
		out.println(one);
		one.setX(5);
		out.println(one);
		H two = new H();
		two.setX(-2);
		two.setY(11);
		out.println(two);

		G four = new H();
		four.setX(11);
		out.println(four);
		four.setX(6);
		((H)four).setY(14);
		out.println(four);

		H five= new H();
		five.setY(7);
		out.println(five);
		five.setX(16);
		five.setY(9);
		out.println(five);

	}
	
}
